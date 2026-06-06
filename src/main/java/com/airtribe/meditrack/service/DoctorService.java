package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.entity.Specialization;
import com.airtribe.meditrack.exception.DoctorNotFoundException;
import com.airtribe.meditrack.exception.InvalidDataException;
import com.airtribe.meditrack.util.Validator;

import java.util.HashMap;
import java.util.Map;

public class DoctorService {

    private final Map<Integer, Doctor> doctors = new HashMap<>();

    public void addDoctor(Doctor doctor) throws InvalidDataException {
        Validator.validateName(doctor.getName());
        doctors.put(doctor.getId(), doctor);
    }

    public void updateDoctor(Doctor doctor) throws DoctorNotFoundException {
        if (!doctors.containsKey(doctor.getId())) {
            throw new DoctorNotFoundException("Doctor not found");
        }
        doctors.put(doctor.getId(), doctor);
    }

    public void removeDoctor(int doctorId) throws DoctorNotFoundException {
        if (!doctors.containsKey(doctorId)) {
            throw new DoctorNotFoundException("Doctor not found");
        }
        doctors.remove(doctorId);
    }

    public Doctor searchDoctor(int doctorId) throws DoctorNotFoundException {
        Doctor doctor = doctors.get(doctorId);
        if (doctor == null) {
            throw new DoctorNotFoundException("Doctor not found");
        }
        return doctor;
    }

    public void searchDoctor(Specialization specialization) {
        doctors.values().stream().filter(d -> d.getSpecialization() == specialization).forEach(System.out::println);
    }

    public void getAllDoctors() {
        doctors.values().forEach(System.out::println);
    }

    public Map<Integer, Doctor> getDoctors() {
        return doctors;
    }
}