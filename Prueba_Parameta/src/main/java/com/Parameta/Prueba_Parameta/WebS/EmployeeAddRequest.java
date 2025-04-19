package com.Parameta.Prueba_Parameta.WebS;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "employee"
})
@XmlRootElement(name = "employeeAddRequest")

public class EmployeeAddRequest {

    @XmlElement(required = true)
    protected EmployeeType employee;

    public EmployeeType getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeType employee) {
        this.employee = employee;
    }
}
