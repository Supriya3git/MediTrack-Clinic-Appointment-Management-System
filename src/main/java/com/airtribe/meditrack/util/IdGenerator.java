package com.airtribe.meditrack.util;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {

    private static final IdGenerator INSTANCE = new IdGenerator();

    private AtomicInteger patientCounter;
    private AtomicInteger doctorCounter;
    private AtomicInteger appointmentCounter;
    private AtomicInteger billCounter;

    private IdGenerator(){

        patientCounter = new AtomicInteger(1000);
        doctorCounter = new AtomicInteger(2000);
        appointmentCounter = new AtomicInteger(3000);
        billCounter = new AtomicInteger(4000);
    }

    public static IdGenerator getInstance(){
        return INSTANCE;
    }

    public int getNextPatientId(){
        return patientCounter.incrementAndGet();
    }

    public int getNextDoctorId(){
        return doctorCounter.incrementAndGet();
    }

    public int getNextAppointmentId(){
        return appointmentCounter.incrementAndGet();
    }

    public int getNextBillId(){
        return billCounter.incrementAndGet();
    }
}