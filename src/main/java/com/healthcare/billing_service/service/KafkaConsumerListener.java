package com.healthcare.billing_service.service;

import com.healthcare.billing_service.dto.AppointmentEvent;
import com.healthcare.billing_service.service.implementation.InvoiceGeneratorImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerListener {
    private final InvoiceGeneratorImpl invoiceGenerator;

    @Autowired
    public KafkaConsumerListener(InvoiceGeneratorImpl invoiceGenerator) {
        this.invoiceGenerator = invoiceGenerator;
    }

    @KafkaListener(topics = "appointment-topic", groupId = "smartcare")
    public void consumeAppointments(AppointmentEvent appointmentEvent){
        log.info("Incoming appointment event...");
        invoiceGenerator.generate(appointmentEvent);
        log.info("Invoice generated successfully for Appointment ID:{}",appointmentEvent.getAppointmentId());
    }
}
