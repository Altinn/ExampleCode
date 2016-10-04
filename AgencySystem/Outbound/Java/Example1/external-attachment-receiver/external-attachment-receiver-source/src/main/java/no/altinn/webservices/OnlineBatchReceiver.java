package no.altinn.webservices;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2016-10-03T15:39:36.586+02:00
 * Generated source version: 3.1.7
 * 
 */
@WebServiceClient(name = "OnlineBatchReceiver", 
                  wsdlLocation = "file:/C:/Users/andreas.naess/IdeaProjects/external-attachment-receiver/external-attachment-receiver/src/main/resources/wsdl/OnlineBatchReciever.wsdl",
                  targetNamespace = "http://AltInn.no/webservices/") 
public class OnlineBatchReceiver extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://AltInn.no/webservices/", "OnlineBatchReceiver");
    public final static QName OnlineBatchReceiverSoap12 = new QName("http://AltInn.no/webservices/", "OnlineBatchReceiverSoap12");
    public final static QName OnlineBatchReceiverSoap = new QName("http://AltInn.no/webservices/", "OnlineBatchReceiverSoap");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/andreas.naess/IdeaProjects/external-attachment-receiver/external-attachment-receiver/src/main/resources/wsdl/OnlineBatchReciever.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(OnlineBatchReceiver.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/andreas.naess/IdeaProjects/external-attachment-receiver/external-attachment-receiver/src/main/resources/wsdl/OnlineBatchReciever.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public OnlineBatchReceiver(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public OnlineBatchReceiver(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public OnlineBatchReceiver() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public OnlineBatchReceiver(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public OnlineBatchReceiver(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public OnlineBatchReceiver(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns OnlineBatchReceiverSoap
     */
    @WebEndpoint(name = "OnlineBatchReceiverSoap12")
    public OnlineBatchReceiverSoap getOnlineBatchReceiverSoap12() {
        return super.getPort(OnlineBatchReceiverSoap12, OnlineBatchReceiverSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns OnlineBatchReceiverSoap
     */
    @WebEndpoint(name = "OnlineBatchReceiverSoap12")
    public OnlineBatchReceiverSoap getOnlineBatchReceiverSoap12(WebServiceFeature... features) {
        return super.getPort(OnlineBatchReceiverSoap12, OnlineBatchReceiverSoap.class, features);
    }


    /**
     *
     * @return
     *     returns OnlineBatchReceiverSoap
     */
    @WebEndpoint(name = "OnlineBatchReceiverSoap")
    public OnlineBatchReceiverSoap getOnlineBatchReceiverSoap() {
        return super.getPort(OnlineBatchReceiverSoap, OnlineBatchReceiverSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns OnlineBatchReceiverSoap
     */
    @WebEndpoint(name = "OnlineBatchReceiverSoap")
    public OnlineBatchReceiverSoap getOnlineBatchReceiverSoap(WebServiceFeature... features) {
        return super.getPort(OnlineBatchReceiverSoap, OnlineBatchReceiverSoap.class, features);
    }

}