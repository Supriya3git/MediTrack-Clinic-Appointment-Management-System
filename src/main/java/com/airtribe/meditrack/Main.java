package com.airtribe.meditrack;

import com.airtribe.meditrack.entity.*;
import com.airtribe.meditrack.exception.*;
import com.airtribe.meditrack.service.*;
import com.airtribe.meditrack.strategy.*;
import com.airtribe.meditrack.util.IdGenerator;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        AppointmentService appointmentService = new AppointmentService(patientService, doctorService);

        BillService billService = new BillService(appointmentService);

        while (true) {

            System.out.println("\n===== MediTrack Menu =====");

            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. Create Appointment");
            System.out.println("6. View Appointments");
            System.out.println("7. Cancel Appointment");
            System.out.println("8. Generate Bill");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    try {

                        System.out.println("Enter name:");
                        String name = scanner.nextLine();

                        System.out.println("Enter age:");
                        int age = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Enter contact:");
                        String contact = scanner.nextLine();

                        System.out.println("Enter symptoms:");
                        String symptoms = scanner.nextLine();

                        int id = IdGenerator.getInstance().getNextPatientId();

                        Patient patient = new Patient(id, name, age, contact, symptoms);

                        patientService.createPatient(patient);

                        System.out.println("Patient added");

                    } catch (InvalidDataException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 2:

                    patientService.getAllPatients();

                    break;

                case 3:

                    try {

                        System.out.println("Doctor name:");
                        String doctorName = scanner.nextLine();

                        System.out.println("Doctor age:");
                        int doctorAge = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Consultation fee:");
                        double fee = scanner.nextDouble();
                        scanner.nextLine();

                        int id = IdGenerator.getInstance().getNextDoctorId();

                        Doctor doctor = new Doctor(id, doctorName, doctorAge, Specialization.CARDIOLOGY, fee);

                        doctorService.addDoctor(doctor);

                        System.out.println("Doctor added");

                    } catch (InvalidDataException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 4:

                    doctorService.getAllDoctors();

                    break;

                case 5:

                    try {

                        System.out.println("Patient ID:");
                        int patientId = scanner.nextInt();

                        System.out.println("Doctor ID:");
                        int doctorId = scanner.nextInt();

                        Patient patient = patientService.searchPatientById(patientId);

                        Doctor doctor = doctorService.searchDoctor(doctorId);

                        int appointmentId = IdGenerator.getInstance().getNextAppointmentId();

                        Appointment appointment = new Appointment(appointmentId, patient, doctor, LocalDate.now(), AppointmentStatus.CONFIRMED);

                        appointmentService.createAppointment(appointment);

                        System.out.println("Appointment created");

                    } catch (PatientNotFoundException | DoctorNotFoundException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 6:

                    appointmentService.viewAppointments();

                    break;

                case 7:

                    try {

                        System.out.println("Appointment ID:");
                        int appointmentId = scanner.nextInt();

                        appointmentService.cancelAppointment(appointmentId);

                        System.out.println("Appointment cancelled");

                    } catch (AppointmentNotFoundException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 8:

                    try {

                        System.out.println("Appointment ID:");
                        int appointmentId = scanner.nextInt();

                        BillingStrategy strategy = new StandardBillingStrategy();

                        Bill bill = billService.generateBill(appointmentId, strategy);

                        System.out.println(bill);

                    } catch (AppointmentNotFoundException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 0:

                    System.out.println("Exiting MediTrack...");
                    scanner.close();
                    return;

                default:

                    System.out.println("Invalid choice");
            }
        }
    }
}