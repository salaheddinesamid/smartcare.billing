package com.healthcare.billing_service.service.implementation;

import com.healthcare.billing_service.dto.NewInvoiceDto;
import com.healthcare.billing_service.dto.NewInvoiceResponseDto;
import com.healthcare.billing_service.model.Currency;
import com.healthcare.billing_service.model.Invoice;
import com.healthcare.billing_service.model.InvoiceStatus;
import com.healthcare.billing_service.repository.InvoiceRepository;
import com.healthcare.billing_service.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class BillingServiceImpl implements BillingService {

    @Value("${services.patient}")
    private String PATIENT_SERVICE;

    private final InvoiceRepository invoiceRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public BillingServiceImpl(InvoiceRepository invoiceRepository, RestTemplate restTemplate) {
        this.invoiceRepository = invoiceRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public NewInvoiceResponseDto generateInvoice(Integer appointmentId, Integer patientId, NewInvoiceDto requestDto) {
        /*
        // Check patient existence:
        boolean patientExists = patientExistence(patientId);

        if(!patientExists){
            // throw exception:
        }

         */



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

    /*
    // This function communicates with patient-management service to verify patient existence:
    private boolean patientExistence(Integer patientId){
        String uri = String.format("%s%s",PATIENT_SERVICE,"/api/patient-management/verify-existence")
        ResponseEntity<?> response =
                restTemplate.exchange()
    }

     */


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
