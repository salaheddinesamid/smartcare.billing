package com.healthcare.billing_service.service.implementation;

import com.healthcare.billing_service.dto.AppointmentEvent;
import com.healthcare.billing_service.dto.NewInvoiceResponseDto;
import com.healthcare.billing_service.model.Currency;
import com.healthcare.billing_service.model.Invoice;
import com.healthcare.billing_service.repository.InvoiceRepository;
import com.healthcare.billing_service.service.InvoiceGenerator;
import com.healthcare.billing_service.utils.InvoiceRefNumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InvoiceGeneratorImpl implements InvoiceGenerator {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceRefNumberUtils invoiceRefNumberUtils;

    @Autowired
    public InvoiceGeneratorImpl(InvoiceRepository invoiceRepository, InvoiceRefNumberUtils invoiceRefNumberUtils) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceRefNumberUtils = invoiceRefNumberUtils;
    }

    @Override
    public Invoice generate(AppointmentEvent appointmentEvent) {
        // create new invoice:
        Invoice invoice = new Invoice();
        invoice.setPatientId(appointmentEvent.getPatientId());
        invoice.setAmount(appointmentEvent.getPrice());
        invoice.setCurrency(Currency.MAD);
        invoice.setIssueDate(LocalDateTime.now());
        invoice.setPaymentDate(null);
        // the invoice will due in 10 days:
        invoice.setDueDate(LocalDateTime.now().plusDays(10));
        // generating unique reference number:
        invoice.setRefNumber(invoiceRefNumberUtils.generateInvoiceRefNumber(appointmentEvent.getAppointmentId()));

        // return saved invoice:
        return invoiceRepository.save(invoice);
    }
}
