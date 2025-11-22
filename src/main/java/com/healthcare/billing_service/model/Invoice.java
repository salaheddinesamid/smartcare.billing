package com.healthcare.billing_service.model;

import com.healthcare.billing_service.utils.InvoiceRefNumberUtils;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    @Column(name = "appointment_id",unique = true)
    private Integer appointmentId;

    @Column(name = "patient_id")
    private Integer patientId;

    @Column(name = "ref_number", unique = true)
    private String refNumber;

    @Column(name = "issue_date")
    private LocalDateTime issueDate;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(name = "amount")
    private double amount;

    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column(name = "status")
    private InvoiceStatus status;

}
