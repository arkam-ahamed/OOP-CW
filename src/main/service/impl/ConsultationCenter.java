package main.service.impl;


import main.model.Doctor;
import main.service.WestminsterSkinConsultationManagerService;

import java.io.IOException;
import java.util.Scanner;

public class ConsultationCenter {


    public boolean start() throws IOException {
        return this.selection();
    }

    private boolean selection() throws IOException {
        WestminsterSkinConsultationManagerService service = new WestminsterSkinConsultationManagerServiceImpl();

        System.out.println("|--------------CONSULTATION CENTER-------------|");
        System.out.println("|Available options:                            |");
        System.out.println("|A: Add a new doctor                           |");
        System.out.println("|D: Delete a doctor                            |");
        System.out.println("|P: Print the list of the doctors              |");
        System.out.println("|S: Save in a file                             |");
        System.out.println("|L: Load file                                  |");
        System.out.println("|G: Open GUI                                   |");
        System.out.println("|Q: Exit Consultation                          |");
        System.out.println("|----------------------------------------------|");
        System.out.print("Choice: ");
        Scanner input = new Scanner(System.in);
        switch (input.next().toUpperCase()) {
            case "A":
                Doctor doctor = new Doctor();
                service.addDoctor(doctor);
                return true;
            case "D":
                service.deleteDoctor();
                return true;
            case "P":
                service.getAllDoctors();
                return true;
            case "S":
                service.saveFile();
                break;
            case "L":
                service.loadFile();
                return true;
            case "G":
                service.showGUI();
                return true;
            case "Q":
                return false;
            default:
                System.out.println("Invalid option, try again.");
        }
        return true;
    }
}



