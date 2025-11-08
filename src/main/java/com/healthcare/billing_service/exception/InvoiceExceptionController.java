package com.healthcare.billing_service.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class InvoiceExceptionController{

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<?> handlePatientNotFound(){
        return
                ResponseEntity.status(404)
                        .body(Map.of("message", "Patient not found"));
    }

    @ExceptionHandler(InvoiceNotFoundException.class)
    public ResponseEntity<?> handleInvoiceNotFoundException(InvoiceNotFoundException e){

        return ResponseEntity
                .status(409)
                .body(Map.of("message", String.format("%s%s","This invoice does not exist",e.getMessage())));
    }
}
