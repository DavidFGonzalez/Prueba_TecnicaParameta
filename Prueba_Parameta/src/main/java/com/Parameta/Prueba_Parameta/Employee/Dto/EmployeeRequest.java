package com.Parameta.Prueba_Parameta.Employee.Dto;

//Importaciones para manejar fechas y serializacion
import java.io.Serializable;
import java.time.LocalDate;

//Importaciones para validar campos
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data

public class EmployeeRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "{nombres.not.null}")
    private String nombres;

    @NotBlank(message = "{apellidos.not.null}")
    private String apellidos;

    @NotBlank(message = "{tipoDocumento.not.null}")
    private String tipoDocumento;

    @NotBlank(message = "{numeroDocumento.not.null}")
    private String numeroDocumento;

    @NotBlank(message = "{fechaNacimiento.not.null}")
    @Pattern(regexp = "^\\d{4}/\\d{2}/\\d{2}$", message = "La fecha de nacimiento debe de estar en el formato YYYY/MM/DD")
    private String fechaNacimiento;

    @NotBlank(message = "{fechaVinculacion.not.null}")
    @Pattern(regexp = "^\\d{4}/\\d{2}/\\d{2}$", message = "La fecha de vinculacion debe de estar en el formato YYYY/MM/DD")
    private String fechaVinculacion;

    @NotNull(message = "{cargo.not.null")
    private String cargo;

    @NotNull(message = "{salario.not.null}")
    @DecimalMin(value = "0.0", inclusive = false, message = "El salario debe de ser mayor que cero")
    private Double salario;


}
