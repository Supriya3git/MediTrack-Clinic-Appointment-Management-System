package com.airtribe.meditrack.entity;

public class Patient extends Person implements Cloneable{

    private String contactNumber;
    private String symptoms;

    public Patient(int id, String name, int age, String contactNumber, String symptoms) {
        super(id, name, age);
        this.contactNumber = contactNumber;
        this.symptoms = symptoms;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public Patient clone() {
        try {
            return (Patient) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone operation failed", e);
        }
    }

    @Override
    public String toString() {
        return "Patient{" +
                "contactNumber='" + contactNumber + '\'' +
                ", symptoms='" + symptoms + '\'' +
                "} " + super.toString();
    }
}
