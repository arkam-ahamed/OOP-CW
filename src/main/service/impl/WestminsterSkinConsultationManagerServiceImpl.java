package main.service.impl;


import main.model.Doctor;
import main.service.JFrame.ConsultationGUI;
import main.service.WestminsterSkinConsultationManagerService;

import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WestminsterSkinConsultationManagerServiceImpl implements WestminsterSkinConsultationManagerService {

    public static List<Doctor> doctorsList = new ArrayList<>(10);

    @Override
    public void loadFile() {
        try {
            File doctorsListFile = new File("doctors_list.txt");
            Scanner myReader = new Scanner(doctorsListFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {
        if (doctorsList.size() < 10) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter First Name: ");
            String firstName = scanner.nextLine();
            while (firstName == null || firstName.isEmpty()) {
                System.out.println("First Name cannot be empty");
                System.out.println("Enter First Name: ");
                firstName = scanner.nextLine();
            }
            System.out.println("Enter Surname: ");
            String surName = scanner.nextLine();
            while (surName == null || surName.isEmpty()) {
                System.out.println("Sur Name cannot be empty");
                System.out.println("Enter Surname: ");
                surName = scanner.nextLine();
            }
            System.out.println("Enter Date of Birth: ");
            String DOB = scanner.nextLine();
            while (DOB == null || DOB.isEmpty()) {
                System.out.println("DOB cannot be empty");
                System.out.println("Enter Date of Birth: ");
                DOB = scanner.nextLine();
            }
            System.out.println("Enter Mobile No: ");
            String mobileNo = scanner.nextLine();
            while (mobileNo == null || mobileNo.isEmpty()) {
                System.out.println("Mobile No cannot be empty");
                System.out.println("Enter Mobile No: ");
                mobileNo = scanner.nextLine();
            }
            System.out.println("Enter Medical License No: ");
            String medicalLicenseNo = scanner.nextLine();
            while (medicalLicenseNo == null || medicalLicenseNo.isEmpty()) {
                System.out.println("Medical License No cannot be empty");
                System.out.println("Enter Medical License No: ");
                medicalLicenseNo = scanner.nextLine();
            }
            System.out.println("Enter Specialization: ");
            String specializedIn = scanner.next();
            while (specializedIn == null || specializedIn.isEmpty()) {
                System.out.println("Specialization cannot be empty");
                System.out.println("Enter Specialization: ");
                specializedIn = scanner.next();
            }
            doctor.setName(firstName);
            doctor.setSurname(surName);
            doctor.setDOB(DOB);
            doctor.setMobileNo(mobileNo);
            doctor.setMedicalLicenseNo(medicalLicenseNo);
            doctor.setSpecialization(specializedIn);

            doctorsList.add(doctor);
            System.out.println("Successfully added Doctor " + doctor.getName() + " " + doctor.getSurname() + " to the center");
        } else {
            System.out.println("Sorry , The centre can allocate only a maximum of 10 doctors");
        }
        return doctor;
    }

    @Override
    public void deleteDoctor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Medical License No: ");
        String medicalLicenseNo = scanner.nextLine();
        Doctor deleteAbleDoctor = null;
        if (!doctorsList.isEmpty()) {
            for (Doctor doctor : doctorsList) {
                if (doctor.getMedicalLicenseNo().equals(medicalLicenseNo)) {
                    System.out.println("Deleted the doctor named " + doctor.getName() + " " + doctor.getSurname());
                    deleteAbleDoctor = doctor;
                    break;
                }
            }
            if (deleteAbleDoctor != null) {
                doctorsList.remove(deleteAbleDoctor);
            }
            if (doctorsList.size() > 0) {
                System.out.println("Total doctors remaining in our center are " + doctorsList.size());
            } else {
                System.out.println("Currently There are no doctors in our department");
            }
        } else {
            System.out.println("Currently There are no doctors in our department");
        }

    }

    @Override
    public void getAllDoctors() {
        if (!doctorsList.isEmpty()) {
            List<Doctor> sortedList = WestminsterSkinConsultationManagerService.sortBySurname(doctorsList);
            for (Doctor doctor : sortedList) {
                System.out.println("Details of the doctor " + doctor.getName() + " " + doctor.getSurname());
                System.out.println("------------------------------------------------");
                System.out.println("First Name: " + doctor.getName());
                System.out.println("Surname: " + doctor.getSurname());
                System.out.println("Date of Birth: " + doctor.getDOB());
                System.out.println("Mobile No: " + doctor.getMobileNo());
                System.out.println("Medical License No: " + doctor.getMedicalLicenseNo());
                System.out.println("Specialized In: " + doctor.getSpecialization());
                System.out.println("------------------------------------------------");
            }
        } else {
            System.out.println("Currently There are no doctors in our department");
        }
    }

    @Override
    public void saveFile() throws IOException {
        String fileName = "doctors_list.txt";
        FileWriter fw = new FileWriter(fileName, false);
        BufferedWriter bw = new BufferedWriter(fw);

        if (!doctorsList.isEmpty()) {
            for (Doctor doctor : doctorsList) {
                bw.write("-----------------------------");
                bw.newLine();
                bw.write("Details of doctor " + doctor.getName() + " " + doctor.getSurname());
                bw.newLine();
                bw.write("-----------------------------");
                bw.newLine();
                bw.write("Name: " + doctor.getName());
                bw.newLine();
                bw.write("Surname: " + doctor.getSurname());
                bw.newLine();
                bw.write("Date of Birth: " + doctor.getDOB());
                bw.newLine();
                bw.write("Mobile Number: " + doctor.getSurname());
                bw.newLine();
                bw.write("Medical License No: " + doctor.getMedicalLicenseNo());
                bw.newLine();
                bw.write("Specialized In: " + doctor.getSpecialization());
                System.out.println("Adding to the file....");
                System.out.println("file saved....");
            }
        } else {
            bw.write("Currently There are no doctors in our department");
            System.out.println("No data to add......");
        }
        bw.close();
    }

    @Override
    public ActionEvent showGUI() throws IOException {
        new ConsultationGUI();
        return null;
    }
}



