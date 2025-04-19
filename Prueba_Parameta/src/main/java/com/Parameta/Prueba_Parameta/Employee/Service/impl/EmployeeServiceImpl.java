package com.Parameta.Prueba_Parameta.Employee.Service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.Parameta.Prueba_Parameta.Employee.Utils.Function;
import org.springframework.stereotype.Service;

import com.Parameta.Prueba_Parameta.Employee.Dto.EmployeeRequest;
import com.Parameta.Prueba_Parameta.Employee.Dto.EmployeeResponse;
import com.Parameta.Prueba_Parameta.Employee.Service.impl.EmployeeService;
import com.Parameta.Prueba_Parameta.WebS.EmployeeAddRequest;
import com.Parameta.Prueba_Parameta.WebS.EmployeePort;
import com.Parameta.Prueba_Parameta.WebS.EmployeePortService;
import com.Parameta.Prueba_Parameta.WebS.EmployeeType;

@Service

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public EmployeeResponse saveEmployee(EmployeeRequest request) throws Exception {
        validateFechaVinculacion(request.getFechaVinculacion());
        EmployeeResponse response = new EmployeeResponse();
        EmployeePort employeeSoap = new EmployeePortService().getEmployeePortSoap11();
        EmployeeAddRequest requestSoap = createEmployeeAddRequest(request);
        populateEmployeeResponse(response, request);
        return  response;
    }

    private void validateFechaVinculacion (String fechaVinculacion) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate oldDate = LocalDate.parse(fechaVinculacion, formatter);
        LocalDate newDate = LocalDate.now();
        if (oldDate.isAfter(newDate)) {
            throw new IllegalArgumentException("La fecha de vinculacion no puede ser posterior a la fecha actual");
        }
    }

    private EmployeeAddRequest createEmployeeAddRequest (EmployeeRequest request) {
        EmployeeType employeeType = new EmployeeType();
        employeeType.setNombres(request.getNombres());
        employeeType.setApellidos(request.getApellidos());
        employeeType.setTipoDocumento(request.getTipoDocumento());
        employeeType.setNumeroDocumento(request.getNumeroDocumento());
        employeeType.setFechaNacimiento(request.getFechaNacimiento());
        employeeType.setFechaVinculacion(request.getFechaVinculacion());
        employeeType.setCargo(request.getCargo());
        employeeType.setSalario(request.getSalario());
        EmployeeAddRequest requestSoap = new EmployeeAddRequest();
        requestSoap.setEmployee(employeeType);
        return requestSoap;
    }

    private void populateEmployeeResponse(EmployeeResponse response, EmployeeRequest request){
        response.setNombres(request.getNombres());
        response.setApellidos(request.getApellidos());
        response.setTipoDocumento(request.getTipoDocumento());
        response.setNumeroDocumento(request.getNumeroDocumento());
        response.setFechaNacimiento(request.getFechaNacimiento());
        response.setFechaVinculacion(request.getFechaVinculacion());
        response.setCargo(request.getCargo());
        response.setSalario(request.getSalario());
        response.setTimpoVinculacion(Function.calcularTiempoVinculacion(request.getFechaVinculacion()));
        response.setEdadEmpleado(Function.calcularEdadEmpleado(request.getFechaNacimiento()));
    }
}
