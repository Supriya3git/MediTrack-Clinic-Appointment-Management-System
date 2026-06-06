package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.exception.InvalidDataException;
import com.airtribe.meditrack.exception.PatientNotFoundException;
import com.airtribe.meditrack.util.Validator;

import java.util.HashMap;
import java.util.Map;

public class PatientService {

    private final Map<Integer,Patient> patients = new HashMap<>();

    public void createPatient(Patient patient) throws InvalidDataException{
        Validator.validateName(patient.getName());
        Validator.validateAge(patient.getAge());
        Validator.validateContact(patient.getContactNumber());
        patients.put(patient.getId(), patient);
    }

    public void updatePatient(Patient patient) throws PatientNotFoundException {
        if(!patients.containsKey(patient.getId())){
            throw new PatientNotFoundException("Patient not found!!");
        }
        patients.put(patient.getId(), patient);
    }

    public Patient searchPatientById(int id) throws PatientNotFoundException{
        Patient patient = patients.get(id);
        if(patient == null){
            throw new PatientNotFoundException("Patient not found!!");
        }
        return patient;
    }

    public void deletePatient(int id) throws PatientNotFoundException {
        if(!patients.containsKey(id)){
            throw new PatientNotFoundException("Patient not found!!");
        }
        patients.remove(id);
    }

    // Overloading
    public void searchPatient(String name){

        patients.values()
                .stream()
                .filter(p ->
                        p.getName()
                                .equalsIgnoreCase(name))
                .forEach(System.out::println);
    }

    // Overloading
    public void searchPatient(int age){

        patients.values()
                .stream()
                .filter(p -> p.getAge() == age)
                .forEach(System.out::println);
    }

    public void getAllPatients(){

        patients.values()
                .forEach(System.out::println);
    }

    public Map<Integer, Patient> getPatients(){
        return patients;
    }
}
