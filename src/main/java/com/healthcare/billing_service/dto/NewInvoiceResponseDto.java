package com.healthcare.billing_service.dto;

import com.healthcare.billing_service.model.Invoice;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class NewInvoiceResponseDto {

    private Long id;
    private Integer appointmentId;
    private Integer patientId;
    private LocalDateTime issueDate;
    private LocalDateTime dueDate;
    private double amount;
    private String currency;
    private String status;

    public NewInvoiceResponseDto(
            Invoice invoice
    ){
        this.id = invoice.getInvoiceId();
        this.appointmentId = invoice.getAppointmentId();
        this.patientId = invoice.getPatientId();
        this.amount = invoice.getAmount();
        this.dueDate = invoice.getDueDate();
        this.currency = invoice.getCurrency().toString();
        this.status = invoice.getStatus().toString();
    }
}
