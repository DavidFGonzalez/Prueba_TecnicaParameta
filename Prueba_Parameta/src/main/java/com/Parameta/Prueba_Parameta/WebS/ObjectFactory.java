package com.Parameta.Prueba_Parameta.WebS;

import com.Parameta.Prueba_Parameta.Employee.Dto.EmployeeRequest;
import jakarta.xml.bind.annotation.XmlRegistry;

@XmlRegistry

public class ObjectFactory {

    public ObjectFactory() {
    }

    public EmployeeAddResponse createEmployeeAddResponse() {
        return new EmployeeAddResponse();
    }

    public EmployeeServiceStatus createEmployeeServiceStatus() {
        return new EmployeeServiceStatus();
    }

    public EmployeeAddRequest createEmployeeAddRequest() {
        return new EmployeeAddRequest();
    }

    public EmployeeType createEmployeeType() {
        return new EmployeeType();
    }
}
