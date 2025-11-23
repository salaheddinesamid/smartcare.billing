package com.healthcare.billing_service.service.implementation;

import com.healthcare.billing_service.dto.AppointmentEvent;
import com.healthcare.billing_service.service.InvoiceConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DefaultInvoiceConsumerImpl implements InvoiceConsumer {

    private final InvoiceGeneratorImpl invoiceGenerator;

    public DefaultInvoiceConsumerImpl(InvoiceGeneratorImpl invoiceGenerator) {
        this.invoiceGenerator = invoiceGenerator;
    }

    @Override
    @KafkaListener(topics = "appointment-topic", groupId = "invoice-service-group")
    public void listen(AppointmentEvent appointmentEvent) {
        log.info("Receiving appointment event: {}", appointmentEvent.getAppointmentId());
        invoiceGenerator.generate(appointmentEvent);
    }
}
