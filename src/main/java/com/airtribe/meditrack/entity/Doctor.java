package com.airtribe.meditrack.entity;

public class Doctor extends Person {

    private Specialization specialization;
    private double consultationFee;

    public Doctor(int id, String name, int age, Specialization specialization, double consultationFee) {
        super(id, name, age);
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "specialization=" + specialization +
                ", consultationFee=" + consultationFee +
                '}'+ super.toString();
    }
}
