package com.healthcare.appointment.controller;

import com.healthcare.appointment.entity.Appointment;
import com.healthcare.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        return ResponseEntity.ok(service.createAppointment(appointment));
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(service.getAllAppointments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAppointmentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(
            @PathVariable Long id, @RequestBody Appointment updated) {
        return ResponseEntity.ok(service.updateAppointment(id, updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        service.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
