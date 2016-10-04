package application;

import generated.DataBatch;
import generated.OnlineBatchReceipt;
import generated.ResultCodeType;
import no.altinn.webservices.ReceiveOnlineBatchExternalAttachment;
import no.altinn.webservices.ReceiveOnlineBatchExternalAttachmentResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by andreas.naess on 29.09.2016.
 */

/**
 * Processes incoming soap requests, and produces a receipt.
 */
@Component
public class ExternalAttachmentHandler {

    final static Logger logger = Logger.getLogger(ExternalAttachmentHandler.class);

    /**
     * Processer the request, by validating the databatch, checking for uniqueness and writing to disk.
     *
     * @param request The request parameter contains all data received from Altinn.
     * @return A response code; OK, FAILED or FAILED_DO_NOT_RETRY
     */
    public ResultCodeType processRequest(ReceiveOnlineBatchExternalAttachment request) {

        String batch = request.getBatch();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DataBatch.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // The path to the xsd-schema used to validate against is hardcoded. Can implement config-file to make it
            // modular.
            Schema schema = sf.newSchema(getClass().getClassLoader().getResource("xsd/genericbatch.2013.06.xsd"));
            unmarshaller.setSchema(schema);

            StringReader reader = new StringReader(batch);
            unmarshaller.unmarshal(reader);
        } catch (UnmarshalException e) {
            // Only client errors
            logger.error("Feil med data/schema - " + e);
            return ResultCodeType.FAILED_DO_NOT_RETRY;
        } catch (SAXException e) {
            // Includes both internal and client errors
            logger.error("Internfeil - " + e);
            return ResultCodeType.FAILED;

        } catch (JAXBException e) {
            // ALL other JAXB errors
            logger.error("Internfeil - " + e);
            return ResultCodeType.FAILED;
        }

        FileHandler fileHandler = new FileHandler(request.getReceiversReference());

        // Before writing the dataBatch to disk, it is important to check if it already exists. This is accomplished
        // by checking the receivers reference for uniqueness.
        if (fileHandler.fileExists()) {
            return ResultCodeType.FAILED_DO_NOT_RETRY;
        }
        // If it got this far, then it means that the dataBatch is fresh, and can be written to disk.
        try {
            fileHandler.write(batch, request.getAttachments());
        } catch (IOException e) {
            logger.error("Kunne ikke skrive fil til disk - " + e);
            return ResultCodeType.FAILED;
        }
        return ResultCodeType.OK;
    }

    /**
     * Constructs a receipt based on the "OnlineBatchReceipt.xsd"
     * @param resultCode The receipt payload
     * @return A receipt, indicating whether the request was handled successfully, or not
     */
    public ReceiveOnlineBatchExternalAttachmentResponse prepareReceipt(ResultCodeType resultCode) {
        OnlineBatchReceipt onlineBatchReceipt = new OnlineBatchReceipt();
        OnlineBatchReceipt.Result result = new OnlineBatchReceipt.Result();
        result.setResultCode(resultCode);
        onlineBatchReceipt.setResult(result);

        ReceiveOnlineBatchExternalAttachmentResponse response = new ReceiveOnlineBatchExternalAttachmentResponse();
        // Marshalls the onlineBatchReceipt from Java object to string.
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(OnlineBatchReceipt.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            java.io.StringWriter sw = new StringWriter();
            marshaller.marshal(onlineBatchReceipt, sw);
            response.setReceiveOnlineBatchExternalAttachmentResult(sw.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
            logger.error("Internfeil - " + e);
        }
        return response;
    }

}
