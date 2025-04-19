package com.Parameta.Prueba_Parameta.Employee.Exception;

//Importaciones para estructuras de datos
import java.util.HashMap;
import java.util.Map;

//Importaciones para el Logging
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class GlobalException {

    // Configura un logger para registrar eventos y mensajes durante la ejecución
    private static final Logger logger =LoggerFactory.getLogger((GlobalException.class));

    // Manejador para excepciones de validación de argumentos de método
    // Se activa cuando fallan las validaciones definidas con anotaciones como @NotBlank, @Pattern, etc.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>>handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(FieldError error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        // Crea un mapa para almacenar los errores (campo -> mensaje)
        // Recorre cada error de campo y lo añade al mapa
        // Devuelve una respuesta con los errores y código HTTP 400 (BAD REQUEST)
    }

    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        // Crea un mapa para almacenar el mensaje de error
        // Devuelve una respuesta con el error y código HTTP 400 (BAD REQUEST)
    }

}
