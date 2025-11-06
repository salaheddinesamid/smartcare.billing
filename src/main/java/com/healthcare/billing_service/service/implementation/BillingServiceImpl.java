package com.healthcare.billing_service.service.implementation;

import com.healthcare.billing_service.repository.InvoiceRepository;
import com.healthcare.billing_service.service.BillingService;
import org.springframework.stereotype.Service;

@Service
public class BillingServiceImpl implements BillingService {

    private final InvoiceRepository invoiceRepository;

    public BillingServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public void generateInvoice() {

    }

    @Override
    public void payInvoice() {

    }

    @Override
    public void getPatientInvoices() {

    }

    @Override
    public void getUnpaidInvoices() {

    }
}
