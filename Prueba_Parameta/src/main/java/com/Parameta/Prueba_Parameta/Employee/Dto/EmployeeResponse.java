package com.Parameta.Prueba_Parameta.Employee.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombres;

    private String apellidos;

    private String tipoDocumento;

    private String numeroDocumento;

    private String fechaNacimiento;

    private String fechaVinculacion;

    private String cargo;

    private Double salario;

    private String timpoVinculacion;

    private String edadEmpleado;
}
