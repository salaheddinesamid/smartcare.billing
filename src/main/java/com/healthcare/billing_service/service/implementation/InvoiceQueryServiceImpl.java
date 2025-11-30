package com.healthcare.billing_service.service.implementation;

import com.healthcare.billing_service.dto.InvoiceDetails;
import com.healthcare.billing_service.model.Invoice;
import com.healthcare.billing_service.model.InvoiceStatus;
import com.healthcare.billing_service.repository.InvoiceRepository;
import com.healthcare.billing_service.service.InvoiceQueryService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This class provides query methods to fetch the data from the DB and return a customized response
 */
@Component
public class InvoiceQueryServiceImpl implements InvoiceQueryService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceQueryServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<InvoiceDetails> getAllPendingInvoices() {
        return List.of();
    }

    @Override
    public List<InvoiceDetails> getAllUnpaidInvoices() {
        // fetch data from db
        List<Invoice> invoices = invoiceRepository
                .findAllByStatus(InvoiceStatus.UNPAID);
        // return response
        return invoices.stream().map(InvoiceDetails::new)
                .toList();
    }

    @Override
    public List<InvoiceDetails> getPatientInvoices() {
        return List.of();
    }
}
