package com.Parameta.Prueba_Parameta.Employee.Controller;

//Importaciones para el logging
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Importaciones de Spring para el manejo de respuestas HTTP y validacion
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Parameta.Prueba_Parameta.Employee.Dto.EmployeeResponse;
import com.Parameta.Prueba_Parameta.Employee.Service.impl.EmployeeService;
import com.Parameta.Prueba_Parameta.Employee.Dto.EmployeeRequest;

@RequestMapping
@RestController

public class EmployeeController {

    //Configuracion del Logger
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Definicion del endpoint POST en la ruta
    @PostMapping("/add")


    public ResponseEntity<EmployeeResponse> ValidarEmployee(@Validated @RequestBody EmployeeRequest request) throws Exception {
        logger.info("Request: {}", request);
        EmployeeResponse response = new EmployeeResponse();
        response = employeeService.saveEmployee(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
