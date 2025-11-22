package com.healthcare.billing_service.service;

import com.healthcare.billing_service.dto.AppointmentEvent;
import com.healthcare.billing_service.dto.NewInvoiceResponseDto;
import com.healthcare.billing_service.model.Invoice;

/**
 * This class is responsible for handling invoice generation.
 * It consumes appointment events from a message producer.
 */
public interface InvoiceGenerator {

    /**
     * This function generate invoice based on new appointment created event.
     * @param appointmentEvent
     * @return invoice.
     */
    Invoice generate(AppointmentEvent appointmentEvent);
}
