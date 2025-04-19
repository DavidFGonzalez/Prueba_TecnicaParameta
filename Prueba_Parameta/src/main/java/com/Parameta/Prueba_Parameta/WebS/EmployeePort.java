package com.Parameta.Prueba_Parameta.WebS;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;


@WebService(name = "EmployeePort", targetNamespace = "http://service.parameta.com/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})

public interface EmployeePort {

    @WebMethod
    @WebResult(name = "employeeAddResponse", targetNamespace = "http://service.parameta.com/", partName = "employeeAddResponse")
    public EmployeeAddResponse employeeAdd(
        @WebParam(partName = "employeeAddResponse", name = "employeeAddRequest", targetNamespace = "http://service.parameta.com/")
        EmployeeAddRequest EmployeeAddRequest);
}
