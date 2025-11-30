package com.healthcare.billing_service.dto;

import com.healthcare.billing_service.model.Invoice;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
public class InvoiceDetails {

    private Long invoiceId;
    private Integer appointmentId;
    private Integer patientId;
    private String refNumber;
    private LocalDateTime issueDate;
    private LocalDateTime dueDate;
    private double amount;
    private String currency;
    private String status;

    public InvoiceDetails(Invoice invoice){
        this.invoiceId = invoice.getInvoiceId();
        this.appointmentId = invoice.getAppointmentId();
        this.patientId = invoice.getPatientId();
        this.refNumber = invoice.getRefNumber();
        this.issueDate = invoice.getIssueDate();
        this.dueDate = invoice.getDueDate();
        this.amount = invoice.getAmount();
        this.currency = invoice.getCurrency().toString();
        this.status = invoice.getStatus().toString();
    }
}
