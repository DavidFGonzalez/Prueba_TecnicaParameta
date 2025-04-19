package com.Parameta.Prueba_Parameta.WebS;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "serviceStatus",
        "employee"
})
@XmlRootElement(name = "employeeAddResponse")

public class EmployeeAddResponse {
    @XmlElement(required = true)
    protected EmployeeServiceStatus serviceStatus;
    @XmlElement(required = true)
    protected EmployeeType employee;

    public EmployeeServiceStatus getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(EmployeeServiceStatus serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public EmployeeType getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeType employee) {
        this.employee = employee;
    }
}
