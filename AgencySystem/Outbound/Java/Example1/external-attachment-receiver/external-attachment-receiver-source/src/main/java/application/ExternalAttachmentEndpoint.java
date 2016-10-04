package application;

import generated.ResultCodeType;
import no.altinn.webservices.ReceiveOnlineBatchExternalAttachment;
import no.altinn.webservices.ReceiveOnlineBatchExternalAttachmentResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by andreas.naess on 29.09.2016.
 */

/**
 * Contains the endpoint which receives incoming soap requests.
 */
@Endpoint
public class ExternalAttachmentEndpoint {

    private static final String NAMESPACE_URI = "http://AltInn.no/webservices/";

    final static Logger logger = Logger.getLogger(ExternalAttachmentEndpoint.class);

    private ExternalAttachmentHandler externalAttachmentHandler;

    @Autowired
    public ExternalAttachmentEndpoint(ExternalAttachmentHandler externalAttachmentHandler) {
        this.externalAttachmentHandler = externalAttachmentHandler;
    }

    /**
     * This is the endpoint where the request data is passed in.
     *
     * @param request The request containing DataBatch and Attachments received from Altinn.
     * @return Returns a response message; OK, FAILED or FAILED_DO_NOT_REPLY. OK = The data has been successfully
     * stored, FAILED = internal failure at the receiving end, FAILED_DO_NOT_REPLY = Faults with incoming XML schema, or
     * the schema already exists.
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ReceiveOnlineBatchExternalAttachment")
    @ResponsePayload
    public ReceiveOnlineBatchExternalAttachmentResponse receiveOnlineBatchExternalAttachment
    (@RequestPayload ReceiveOnlineBatchExternalAttachment request) {

        // Perform user authentication. This is just a dummy method in this project.
        if (isAuthenticated(request.getUsername(), request.getPasswd())) {
            // Performs validations and writes to disk
            ResultCodeType resultCode = externalAttachmentHandler.processRequest(request);
            return externalAttachmentHandler.prepareReceipt(resultCode);
        }

        ReceiveOnlineBatchExternalAttachmentResponse authenticationFailedResponse = new ReceiveOnlineBatchExternalAttachmentResponse();
        authenticationFailedResponse.setReceiveOnlineBatchExternalAttachmentResult("AUTHENTICATION_FAILED");
        return authenticationFailedResponse;
    }

    public boolean isAuthenticated(String username, String password) {
        return true;
    }
}
