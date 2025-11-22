package com.healthcare.billing_service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentEvent {
    private Integer appointmentId;
    private Integer patientId;
    private LocalDateTime createdAt;
    private double price;
}
