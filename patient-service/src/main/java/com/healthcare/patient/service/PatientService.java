package com.healthcare.patient.service;

import com.healthcare.patient.model.Patient;
import com.healthcare.patient.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id " + id));
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient updated) {
        Patient patient = getPatientById(id);
        patient.setName(updated.getName());
        patient.setAge(updated.getAge());
        patient.setGender(updated.getGender());
        patient.setContactNumber(updated.getContactNumber());
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
