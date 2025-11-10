package com.healthcare.doctor.service;

import com.healthcare.doctor.model.Doctor;
import com.healthcare.doctor.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Long id, Doctor updated) {
        Doctor doctor = getDoctorById(id);
        doctor.setName(updated.getName());
        doctor.setSpecialization(updated.getSpecialization());
        doctor.setExperience(updated.getExperience());
        doctor.setContactNumber(updated.getContactNumber());
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
