package com.healthcare.billing_service.dto;

import com.healthcare.billing_service.model.Invoice;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class InvoicePaymentResponse {

    private Long invoiceId;
    private String referenceNumber;
    private LocalDateTime paymentDate;
    private double amount;
    private String status;


    public InvoicePaymentResponse(
            Invoice invoice
    ){
        this.invoiceId = invoice.getInvoiceId();
        this.referenceNumber  = invoice.getRefNumber();
        this.paymentDate = invoice.getPaymentDate();
        this.amount = invoice.getAmount();
        this.status = invoice.getStatus().toString();
    }
}
