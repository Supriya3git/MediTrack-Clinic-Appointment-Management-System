package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.*;
import com.airtribe.meditrack.exception.AppointmentNotFoundException;
import com.airtribe.meditrack.exception.DoctorNotFoundException;
import com.airtribe.meditrack.exception.PatientNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {

    private final Map<Integer, Appointment> appointments = new HashMap<>();

    private final PatientService patientService;
    private final DoctorService doctorService;

    public AppointmentService(PatientService patientService, DoctorService doctorService) {
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    public void createAppointment(Appointment appointment) throws PatientNotFoundException, DoctorNotFoundException {
        patientService.searchPatient(appointment.getPatient().getId());
        doctorService.searchDoctor(appointment.getDoctor().getId());
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    public Appointment findAppointment(int appointmentId) throws AppointmentNotFoundException {
        Appointment appointment = appointments.get(appointmentId);
        if (appointment == null) {
            throw new AppointmentNotFoundException("Appointment not found");
        }
        return appointment;
    }

    public void cancelAppointment(int appointmentId) throws AppointmentNotFoundException {
        Appointment appointment = findAppointment(appointmentId);
        appointment.setStatus(AppointmentStatus.CANCELLED);
    }

    public void viewAppointments() {
        appointments.values().forEach(System.out::println);
    }

    public Map<Integer, Appointment> getAppointments() {
        return appointments;
    }
}