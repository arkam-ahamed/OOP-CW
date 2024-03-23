package main.model;

public class Patient extends Person{

    private String patientTitle;
    private String patientId;
    private String patientEmail;
    private String patientCity;


    public void setPatientTitle(String patientTitle){
        this.patientTitle = patientTitle;
    }

    public String getPatientTitle(){
        return patientTitle;
    }

    public void setPatientId(String patientId){
        this.patientId = patientId;
    }

    public String getPatientId(){
        return patientId;
    }

    public void setPatientEmail(String patientEmail){
        this.patientEmail = patientEmail;
    }

    public String getPatientEmail(){
        return patientEmail;
    }

    public void setPatientCity(String patientCity){
        this.patientCity = patientCity;
    }

    public String getPatientCity(){
        return patientCity;
    }

}
