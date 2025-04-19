package com.Parameta.Prueba_Parameta.WebS;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;

@WebServiceClient(name = "EmployeePortService", targetNamespace = "http://service.parameta.com/", wsdlLocation = "http://localhost:8080/Prueba_Parameta/WebS/EmployeePortl")

public class EmployeePortService extends Service {

    private final static URL EMPLOYEEPORTSERVICE_WSDL_LOCATION;
    private final static WebServiceException EMPLOYEEPORTSERVICE_EXCEPTION;
    private final static QName EMPLOYEEPORTSERVICE_QNAME = new QName("http://service.parameta.com/", "EmployeePortService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/Prueba_Parameta/WebS/EmployeePortl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        EMPLOYEEPORTSERVICE_WSDL_LOCATION = url;
        EMPLOYEEPORTSERVICE_EXCEPTION = e;
    }

    public EmployeePortService() { super(__getWsdLocation(),EMPLOYEEPORTSERVICE_QNAME); }

    public EmployeePortService(WebServiceFeature... features) {
        super(__getWsdLocation(), EMPLOYEEPORTSERVICE_QNAME, features);
    }

    public EmployeePortService(URL wsdlLocation) { super(wsdlLocation, EMPLOYEEPORTSERVICE_QNAME);}

    public EmployeePortService(URL wsdlLocation, WebServiceFeature...features) {
        super(wsdlLocation, EMPLOYEEPORTSERVICE_QNAME, features);
    }

    public EmployeePortService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EmployeePortService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    @WebEndpoint(name = "employeePortSoap11")
    public EmployeePort getEmployeePortSoap11() {
        return super.getPort(new QName("http://service.parameta.com/", "employeePortSoap11"), EmployeePort.class);
    }

    @WebEndpoint(name = "employeePortSoap11")
    public EmployeePort getEmployeePortSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.parameta.com/", "employeePortSoap11"), EmployeePort.class, features);
    }

    private static URL __getWsdLocation() {
        if (EMPLOYEEPORTSERVICE_EXCEPTION!= null) {
            throw EMPLOYEEPORTSERVICE_EXCEPTION;
        }
        return EMPLOYEEPORTSERVICE_WSDL_LOCATION;
    }
}
