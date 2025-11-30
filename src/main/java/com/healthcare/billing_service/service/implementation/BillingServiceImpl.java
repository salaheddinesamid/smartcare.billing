package com.healthcare.billing_service.service.implementation;

import com.healthcare.billing_service.dto.AppointmentEvent;
import com.healthcare.billing_service.dto.InvoicePaymentResponse;
import com.healthcare.billing_service.dto.NewInvoiceResponseDto;
import com.healthcare.billing_service.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingServiceImpl implements BillingService {

    private final InvoiceGeneratorImpl invoiceGenerator;

    @Autowired
    public BillingServiceImpl(InvoiceGeneratorImpl invoiceGenerator) {
        this.invoiceGenerator = invoiceGenerator;
    }


    @Override
    public NewInvoiceResponseDto generateInvoice(AppointmentEvent appointmentEvent) {
        return null;
    }

    // This version is preliminary and will be updated with a payment gateway:
    @Override
    public InvoicePaymentResponse payInvoice(Long invoiceId) {

        /*
        // Fetch the invoice:
        Invoice invoice =
                invoiceRepository.findById(invoiceId).orElseThrow(()-> new InvoiceNotFoundException(invoiceId.toString()));

        // Verify if the invoice has already been paid:
        if(invoice.getStatus().equals(InvoiceStatus.PAID)){
            // Throw exception:
        }

        // update invoice status:
        invoice.setStatus(InvoiceStatus.PAID);

        // save the invoice:
        Invoice savedInvoice = invoiceRepository.save(invoice);
        return new InvoicePaymentResponse(
                savedInvoice
        );

         */

        return null;

    }

    @Override
    public void getPatientInvoices() {

    }

    @Override
    public void getUnpaidInvoices() {

    }
}
