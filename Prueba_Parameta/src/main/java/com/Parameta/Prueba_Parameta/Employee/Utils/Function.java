package com.Parameta.Prueba_Parameta.Employee.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
public class Function {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public static String calcularEdadEmpleado(String fechaNacimiento) {
        LocalDate fechaNacimientoLocalDate = LocalDate.parse(fechaNacimiento, DATE_FORMATTER);
        LocalDate fechaActualLocalDate = LocalDate.now();
        Period period = Period.between(fechaNacimientoLocalDate, fechaActualLocalDate);
        return String.valueOf(period.getYears());
    }

    public static String calcularTiempoVinculacion(String fechaVinculacion) {
        LocalDate fechaVinculacionLocalDate = LocalDate.parse(fechaVinculacion, DATE_FORMATTER);
        LocalDate fechaActualLocalDate = LocalDate.now();
        Period periodo = Period.between(fechaVinculacionLocalDate, fechaActualLocalDate);
        return String.format("%d años, %d meses y %d días", periodo.getYears(), periodo.getMonths(), periodo.getDays());
    }
}