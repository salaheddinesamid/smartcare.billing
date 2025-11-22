package com.healthcare.billing_service.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InvoiceRefNumberUtils {

    public String generateInvoiceRefNumber(Integer appointmentId){
        return String.format("INV%s%s",appointmentId.toString(), LocalDate.now());
    }
}
