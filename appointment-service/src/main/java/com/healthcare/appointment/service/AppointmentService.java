package com.healthcare.appointment.service;

import com.healthcare.appointment.entity.Appointment;
import com.healthcare.appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    public Appointment createAppointment(Appointment appointment) {
        return repository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return repository.findAll();
    }

    public Appointment getAppointmentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    public Appointment updateAppointment(Long id, Appointment updated) {
        Appointment appointment = getAppointmentById(id);
        appointment.setAppointmentTime(updated.getAppointmentTime());
        appointment.setStatus(updated.getStatus());
        return repository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        repository.deleteById(id);
    }
}
