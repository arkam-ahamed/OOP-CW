package main;

import main.service.impl.ConsultationCenter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ConsultationCenter consultationCenter = new ConsultationCenter();
        boolean start = true;
        while (start) {
            start = consultationCenter.start();
        }
        System.out.println("Thank You!!.");
    }
}