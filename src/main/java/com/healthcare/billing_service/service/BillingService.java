package com.healthcare.billing_service.service;

import com.healthcare.billing_service.dto.InvoicePaymentResponse;
import com.healthcare.billing_service.dto.NewInvoiceDto;
import com.healthcare.billing_service.dto.NewInvoiceResponseDto;

public interface BillingService {

    /**
     * This function is responsible for generating invoices
     * @param appointmentId
     * @param patientId
     */
    NewInvoiceResponseDto generateInvoice(Integer appointmentId, Integer patientId, NewInvoiceDto requestDto);

    /**
     * This function handles business logic for invoice payment by patient
     * @param
     */
    InvoicePaymentResponse payInvoice(Long invoiceId);

    /**
     *
     */
    void getPatientInvoices();

    /**
     *
     */
    void getUnpaidInvoices();
}
