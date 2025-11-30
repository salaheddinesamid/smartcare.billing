package com.healthcare.billing_service.service;

import com.healthcare.billing_service.dto.InvoiceDetails;

import java.util.List;

public interface InvoiceQueryService {

    List<InvoiceDetails> getAllPendingInvoices();
    List<InvoiceDetails> getAllUnpaidInvoices();
    List<InvoiceDetails> getPatientInvoices();
}
