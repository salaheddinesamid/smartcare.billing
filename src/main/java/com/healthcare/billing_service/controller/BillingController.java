package com.healthcare.billing_service.controller;

import com.healthcare.billing_service.dto.InvoicePaymentResponse;
import com.healthcare.billing_service.dto.NewInvoiceDto;
import com.healthcare.billing_service.dto.NewInvoiceResponseDto;
import com.healthcare.billing_service.service.implementation.BillingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/billing")
public class BillingController {

    private final BillingServiceImpl billingService;

    @Autowired
    public BillingController(BillingServiceImpl billingService) {
        this.billingService = billingService;
    }


    @PostMapping("new")
    public ResponseEntity<?> newInvoice(@RequestParam Integer appointmentId,
                                        @RequestParam Integer patientId, @RequestBody NewInvoiceDto requestDto) {

        NewInvoiceResponseDto newInvoice = billingService.generateInvoice(
                appointmentId, patientId, requestDto
        );

        return ResponseEntity
                .status(200)
                .body(newInvoice);
    }

    @PutMapping("pay")
    public ResponseEntity<?> payInvoice(@RequestParam Long invoiceId){
        InvoicePaymentResponse response = billingService.payInvoice(invoiceId);

        return ResponseEntity
                .status(200)
                .body(response);
    }

}