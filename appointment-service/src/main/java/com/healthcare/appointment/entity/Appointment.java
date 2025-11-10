package com.healthcare.appointment.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private Long doctorId;

    private LocalDateTime appointmentTime;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        SCHEDULED, COMPLETED, CANCELLED
    }
}
