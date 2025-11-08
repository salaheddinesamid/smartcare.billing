package com.healthcare.billing_service.service.implementation;

import com.healthcare.billing_service.dto.NewInvoiceDto;
import com.healthcare.billing_service.dto.NewInvoiceResponseDto;
import com.healthcare.billing_service.model.Currency;
import com.healthcare.billing_service.model.Invoice;
import com.healthcare.billing_service.model.InvoiceStatus;
import com.healthcare.billing_service.repository.InvoiceRepository;
import com.healthcare.billing_service.service.BillingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BillingServiceImpl implements BillingService {

    private final InvoiceRepository invoiceRepository;

    public BillingServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public NewInvoiceResponseDto generateInvoice(Integer appointmentId, Integer patientId, NewInvoiceDto requestDto) {
        // Check patient existence:
        boolean patientExists = patientExistence(patientId);

        if(!patientExists){
            // throw exception:
        }

        Invoice invoice = new Invoice();
        invoice.setAmount(requestDto.getAmount());
        invoice.setAppointmentId(appointmentId);
        invoice.setCurrency(Currency.valueOf(requestDto.getCurrency()));
        invoice.setIssueDate(LocalDateTime.now());
        invoice.setDueDate(LocalDateTime.now().plusDays(10)); // (due in 10 days)
        invoice.setStatus(InvoiceStatus.PENDING);

        // save the invoice:
        Invoice savedInvoice = invoiceRepository.save(invoice);

        return new NewInvoiceResponseDto(
                savedInvoice
        );

    }

    private boolean patientExistence(Integer patientId){
        return true;
    }


    @Override
    public void payInvoice(Long invoiceId) {

    }

    @Override
    public void getPatientInvoices() {

    }

    @Override
    public void getUnpaidInvoices() {

    }
}
