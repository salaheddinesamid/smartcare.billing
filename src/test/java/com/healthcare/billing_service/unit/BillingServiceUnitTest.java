package com.healthcare.billing_service.unit;

import com.healthcare.billing_service.model.Currency;
import com.healthcare.billing_service.model.Invoice;
import com.healthcare.billing_service.model.InvoiceStatus;
import com.healthcare.billing_service.repository.InvoiceRepository;
import com.healthcare.billing_service.service.implementation.BillingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class BillingServiceUnitTest {

    @Mock
    private InvoiceRepository invoiceRepository;

    @InjectMocks
    private BillingServiceImpl billingService;

    private Invoice invoice;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        // Mock the invoice:
        invoice.setInvoiceId(1L);
        invoice.setIssueDate(LocalDateTime.of(
                LocalDate.of(2025,12,4), LocalTime.of(10,22)));
        invoice.setAmount(200);
        invoice.setCurrency(Currency.USD);
        invoice.setStatus(InvoiceStatus.PENDING);
        invoice.setAppointmentId(10);
        invoice.setPatientId(1);
    }

    @Test
    void testGenerateInvoiceSuccess(){}

    @Test
    void testGenerateInvoiceThrowPatientNotFound(){}

    @Test
    void testGenerateInvoiceThrowAppointmentNotFound(){}


    @Test
    void testPayInvoiceSuccess(){
        // Arrange:
        when(invoiceRepository.findById(1L)).thenReturn(Optional.of(invoice));

        // Act:
    }

    @Test
    void testPayInvoiceNotFound(){}
}
