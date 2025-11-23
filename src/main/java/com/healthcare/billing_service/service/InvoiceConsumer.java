package com.healthcare.billing_service.service;

import com.healthcare.billing_service.dto.AppointmentEvent;

public interface InvoiceConsumer {

    /**
     *
     * @param appointmentEvent
     */
    void listen(AppointmentEvent appointmentEvent);
}
