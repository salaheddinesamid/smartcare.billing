package com.healthcare.billing_service.service;

import com.healthcare.billing_service.dto.AppointmentEvent;
import com.healthcare.billing_service.dto.InvoicePaymentResponse;
import com.healthcare.billing_service.dto.NewInvoiceDto;
import com.healthcare.billing_service.dto.NewInvoiceResponseDto;

public interface BillingService {

    /**
     * This function is responsible for generating invoices
     * @param event
     * @return new invoice response details.
     */
    NewInvoiceResponseDto generateInvoice(AppointmentEvent event);

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
