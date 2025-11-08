package com.healthcare.billing_service.dto;

import lombok.Data;

@Data
public class NewInvoiceDto {
    private double amount;
    private String currency;
}
