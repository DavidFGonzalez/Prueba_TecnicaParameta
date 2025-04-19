package com.Parameta.Prueba_Parameta.Employee.Service.impl;

import com.Parameta.Prueba_Parameta.Employee.Dto.EmployeeResponse;
import com.Parameta.Prueba_Parameta.Employee.Dto.EmployeeRequest;


public interface EmployeeService {

    //Metodo para guardar un empleado en el sistema
    EmployeeResponse saveEmployee(EmployeeRequest request)throws Exception;
}
