package main.service;

import main.model.Doctor;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public interface WestminsterSkinConsultationManagerService {

    Doctor addDoctor(Doctor doctor);

    void deleteDoctor();

    void getAllDoctors();

    void loadFile();

    void saveFile() throws IOException;

    ActionEvent showGUI() throws IOException;

    static List<Doctor> sortBySurname(List<Doctor> list) {
        list.sort(Comparator.comparing(Doctor::getSurname));
        return list;
    }
}
