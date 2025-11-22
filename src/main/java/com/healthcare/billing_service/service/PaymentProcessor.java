package com.healthcare.billing_service.service;

public interface PaymentProcessor {

    boolean supports();
    void pay();
}
