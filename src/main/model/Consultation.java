package main.model;

import java.util.Date;


public class Consultation extends Person {

    public static Date date;
    private  Doctor doctor;
    private Patient patient;

    public void setDate(Date date){
        this.date = date;
    }

    public Date getDate(){
        return date;
    }

    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }

    public Doctor getDoctor(){
        return doctor;
    }

    public void setPatient(Patient patient){
        this.patient = patient;
    }

    public Patient getPatient(){
        return patient;
    }
}
