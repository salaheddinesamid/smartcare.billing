package com.healthcare.billing_service.unit;

import com.healthcare.billing_service.repository.InvoiceRepository;
import com.healthcare.billing_service.service.implementation.BillingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BillingServiceUnitTest {

    @Mock
    private InvoiceRepository invoiceRepository;

    @InjectMocks
    private BillingServiceImpl billingService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGenerateInvoiceSuccess(){}

    @Test
    void testGenerateInvoiceThrowPatientNotFound(){}

    @Test
    void testGenerateInvoiceThrowAppointmentNotFound(){}
}
