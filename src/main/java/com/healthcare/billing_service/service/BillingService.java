package com.healthcare.billing_service.service;

public interface BillingService {

    /**
     * This function is responsible for generating invoices
     * @param appointmentId
     * @param patientId
     */
    void generateInvoice(Integer appointmentId, Integer patientId);

    /**
     * This function handles business logic for invoice payment by patient
     * @param
     */
    void payInvoice(Long invoiceId);

    /**
     *
     */
    void getPatientInvoices();

    /**
     *
     */
    void getUnpaidInvoices();
}
