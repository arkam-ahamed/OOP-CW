package main.service.JFrame;

import main.model.Person;
import main.service.impl.WestminsterSkinConsultationManagerServiceImpl;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.security.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

public class ConsultationGUI extends WestminsterSkinConsultationManagerServiceImpl implements ActionListener {
    private static String doctorName;
    private static int cost;
    private String fullName;

    private String surName;
    private String DOB;
    private String mobileNumber;
    private String idNumber;
    private String hours;


    private static final String[] choices = new String[10];

    private static JFrame frame1;
    private static JFrame frame2;
    private static JFrame frame3;
    private static JFrame frame4;


    private static final JButton viewDoctorButton = new JButton("View Doctors");
    private static final JButton bookDoctorButton = new JButton("Book Doctor");
    private static final JButton saveButton = new JButton("Save");
    private static final JButton resetButton = new JButton("Reset");
    private static final JButton viewButton = new JButton("View Details");
    private static final JButton bookButton = new JButton("Book");
    private static final JButton backButton = new JButton("Go Back");
    private static final JButton backButtonTwo = new JButton("Go Back");
    private static final JButton exitButton = new JButton("Exit");



    private static final JLabel nameLabel = new JLabel("Name");
    private static final JLabel surnameLabel = new JLabel("Surname");
    private static final JLabel dobLabel = new JLabel("Date of Birth");
    private static final JLabel mobileNOLabel = new JLabel("Mobile Number");
    private static final JLabel idLabel = new JLabel("ID Number");
    private static final JLabel durationLabel = new JLabel("Duration of Consultation");
    private static final JLabel firstConsultationLabel = new JLabel("First Consultation?");

    private static final JLabel addNotesLabel = new JLabel("Add Notes");
    private static final JLabel headingLabel = new JLabel("BOOK!!!");
    private static final JLabel doctorNameLabel = new JLabel("Doctor's Name");
    private static final JLabel dateLabel = new JLabel("Date of Consultation");
    private static final JLabel infoOne = new JLabel("Choose the doctor you want to consult with");
    private static final JLabel infoTwo = new JLabel("Enter the date in 'dd/mm/yyyy' format");
    private static final JLabel headingLabelTwo = new JLabel("BOOKING INFORMATION!");

    private static final JLabel mainHeading = new JLabel("Welcome to");
    private static final JLabel mainHeadingTwo = new JLabel("Westminster Skin Consultation Center");
    private static final JLabel paragraph1 = new JLabel("No more worries about your skin");


    private static final JTextField nameText = new JTextField();
    private static final JTextField surnameText = new JTextField();
    private static final JTextField dobText = new JTextField();
    private static final JTextField mobileNoText = new JTextField();
    private static final JTextField idText = new JTextField();
    private static final JTextField durationText = new JTextField();
    private static final JTextField notesText = new JTextField("Add Notes");
    private static final JTextField dateText = new JTextField("dd-mm-yyyy");

    private static final JOptionPane firstOption = new JOptionPane();

    private static JComboBox<String> doctorOption = new JComboBox<>();

    JTable table;

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();

    FileWriter fw = new FileWriter("Consultation.txt",false);


    public ConsultationGUI() throws IOException {
        frame1 = new JFrame();
        frame1.getContentPane().setBackground(Color.lightGray);

        mainHeading.setBounds(180,10,200,50);
        mainHeading.setForeground(Color.black);
        mainHeading.setFont(new Font("Poppins",Font.BOLD,20));

        mainHeadingTwo.setBounds(30,70,500,50);
        mainHeadingTwo.setForeground(Color.black);
        mainHeadingTwo.setFont(new Font("Poppins",Font.BOLD,24));

        paragraph1.setBounds(30,120,500,50);
        paragraph1.setForeground(Color.black);
        paragraph1.setFont(new Font("Poppins",Font.BOLD,15));

        viewDoctorButton.setBounds(10,400,200,40);
        viewDoctorButton.setBackground(Color.white);
        viewDoctorButton.setFocusable(false);
        viewDoctorButton.addActionListener(this);

        bookDoctorButton.setBounds(250,400,200,40);
        bookDoctorButton.setBackground(Color.white);
        bookDoctorButton.setFocusable(false);
        bookDoctorButton.addActionListener(this);



        frame1.add(mainHeading);
        frame1.add(mainHeadingTwo);
        frame1.add(paragraph1);
        frame1.add(viewDoctorButton);
        frame1.add(bookDoctorButton);

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(500,1000);
        frame1.setLayout(null);
        frame1.setVisible(true);


    }
    public void doctorDetails(){
        frame2 = new JFrame();
        frame2.setLayout(new GridLayout(2,2));
        frame2.getContentPane().setBackground(Color.lightGray);

        doctorsList.sort(Comparator.comparing(Person::getName));

        Object[][] data = new Object[doctorsList.size()][6];
        for(int i = 0; i<doctorsList.size(); i++){
            data[i][0] = doctorsList.get(i).getName();
            data[i][1] = doctorsList.get(i).getSurname();
            data[i][2] = doctorsList.get(i).getDOB();
            data[i][3] = doctorsList.get(i).getMobileNo();
            data[i][4] = doctorsList.get(i).getMedicalLicenseNo();
            data[i][5] = doctorsList.get(i).getSpecialization();
        }


        String[] columns = {"Name", "Surname", "D.O.B", "Mobile No.", "License No.", "Specialisation"};

        table = new JTable(data,columns);
        table.setBounds(0,0,500,600);
        table.setBackground(Color.darkGray);
        table.setForeground(Color.white);
        panel1.add(new JScrollPane(table));
        panel1.setBounds(0,0,500,600);
        panel1.setBackground(Color.lightGray);

        bookDoctorButton.setBounds(10,250,400,0);
        bookDoctorButton.setBackground(Color.white);
        bookDoctorButton.setPreferredSize(new Dimension(450,50));
        backButton.setBounds(10,300,400,0);
        backButton.setBackground(Color.white);
        backButton.setPreferredSize(new Dimension(450,50));
        backButton.addActionListener(this);

        panel4.add(bookDoctorButton);
        panel4.add(backButton);
        panel4.setBounds(0,600,500,50);
        panel4.setBackground(Color.lightGray);

        frame2.add(panel1);
        frame2.add(panel4);

        frame2.setSize(500,1000);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);

    }

    public void bookDoctor(){
        frame4 = new JFrame();
        frame4.getContentPane().setBackground(Color.lightGray);
        panel2.setLayout(null);
        panel2.setBackground(Color.lightGray);

        for(int i = 0; i<doctorsList.size(); i++){
            String name = doctorsList.get(i).getName();
            choices[i] = name;
        }

        doctorOption = new JComboBox<>(choices);

        doctorOption.setBounds(180,50,250,25);
        doctorOption.setForeground(Color.black);

        headingLabel.setBounds(180,0,150,25);
        doctorNameLabel.setBounds(10,50,100,25);
        dateLabel.setBounds(10,150,150,25);
        infoOne.setBounds(180,70,250,25);
        infoTwo.setBounds(180,170,250,25);

        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Font("Poppins",Font.BOLD,20));
        doctorNameLabel.setForeground(Color.black);
        dateLabel.setForeground(Color.WHITE);
        infoOne.setForeground(Color.WHITE);
        infoTwo.setForeground(Color.WHITE);

        dateText.setBounds(180,150,250,25);

        bookButton.setBounds(25,350,180,25);
        bookButton.setBackground(Color.white);
        backButtonTwo.setBounds(250,350,180,25);
        backButtonTwo.setBackground(Color.white);

        panel2.add(headingLabel);
        panel2.add(doctorNameLabel);
        panel2.add(doctorOption);
        panel2.add(dateLabel);
        panel2.add(dateText);
        panel2.add(bookButton);
        panel2.add(backButtonTwo);
        panel2.add(infoOne);
        panel2.add(infoTwo);

        backButtonTwo.addActionListener(this);
        bookButton.addActionListener(this);

        frame4.add(panel2);
        frame4.setSize(500,1000);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setVisible(true);

    }


    public void personalDetails(){
        frame3 = new JFrame();
        frame3.getContentPane().setBackground(Color.darkGray);
        panel3.setLayout(null);
        panel3.setBackground(Color.DARK_GRAY);


        nameLabel.setBounds(10,20,120,25);
        surnameLabel.setBounds(10,70,120,25);
        dobLabel.setBounds(10,120,120,25);
        mobileNOLabel.setBounds(10,170,120,25);
        idLabel.setBounds(10,220,120,25);
        durationLabel.setBounds(10,270,150,25);
        firstConsultationLabel.setBounds(10,420,150,25);
        addNotesLabel.setBounds(10,320,120,25);

        nameLabel.setForeground(Color.WHITE);
        surnameLabel.setForeground(Color.WHITE);
        dobLabel.setForeground(Color.WHITE);
        mobileNOLabel.setForeground(Color.WHITE);
        idLabel.setForeground(Color.WHITE);
        durationLabel.setForeground(Color.WHITE);
        firstConsultationLabel.setForeground(Color.WHITE);
        addNotesLabel.setForeground(Color.WHITE);

        nameText.setBounds(235,20,165,25);
        surnameText.setBounds(235,70,165,25);
        surName = surnameText.getText();
        dobText.setBounds(235,120,165,25);
        DOB = dobText.getText();
        mobileNoText.setBounds(235,170,165,25);
        mobileNumber = mobileNoText.getText();
        idText.setBounds(235,220,165,25);
        idNumber = notesText.getText();
        durationText.setBounds(235,270,165,25);
        hours = idText.getText();
        notesText.setBounds(235,320,165,25);



        saveButton.setBounds(20,470,150,50);
        saveButton.setBackground(Color.white);
        resetButton.setBounds(250,470,150,50);
        resetButton.setBackground(Color.white);
        viewButton.setBounds(100,530,150,25);

        saveButton.addActionListener(this);
        resetButton.addActionListener(this);

        panel3.add(nameLabel);
        panel3.add(nameText);
        panel3.add(surnameLabel);
        panel3.add(surnameText);
        panel3.add(dobLabel);
        panel3.add(dobText);
        panel3.add(mobileNOLabel);
        panel3.add(mobileNoText);
        panel3.add(idLabel);
        panel3.add(idText);
        panel3.add(durationLabel);
        panel3.add(durationText);
        panel3.add(notesText);
        panel3.add(saveButton);
        panel3.add(resetButton);
        panel3.add(addNotesLabel);
        panel3.add(firstOption);

        frame3.add(panel3);

        frame3.setSize(500,1000);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setVisible(true);

    }



    public void viewPersonalDetails(){
        JFrame frame5 = new JFrame();
        frame5.getContentPane().setBackground(Color.DARK_GRAY);
        panel5.setLayout(null);
        panel5.setBackground(Color.DARK_GRAY);
        Border blackline = BorderFactory.createLineBorder(Color.black);

        panel5.setBorder(blackline);

        headingLabelTwo.setBounds(80,20,400,50);
        headingLabelTwo.setFont(new Font("Serif", Font.PLAIN, 30));
        headingLabelTwo.setForeground(Color.WHITE);

        JLabel nameLabelTwo = new JLabel("Your Name - " + nameText.getText());
        nameLabelTwo.setBounds(20,70,450,50);
        nameLabelTwo.setFont(new Font("Serif", Font.PLAIN, 20));
        nameLabelTwo.setForeground(Color.WHITE);

        JLabel surnameLabelTwo = new JLabel("Your Surname - " + surnameText.getText());
        surnameLabelTwo.setBounds(20,130,450,50);
        surnameLabelTwo.setFont(new Font("Serif", Font.PLAIN, 20));
        surnameLabelTwo.setForeground(Color.WHITE);

        JLabel dobLabelTwo = new JLabel("Your D.O.B - " + dobText.getText());
        dobLabelTwo.setBounds(20,190,450,50);
        dobLabelTwo.setFont(new Font("Serif", Font.PLAIN, 20));
        dobLabelTwo.setForeground(Color.WHITE);

        JLabel mobileNOLabelTwo = new JLabel("Your Mobile Number - " + mobileNoText.getText());
        mobileNOLabelTwo.setBounds(20,250,450,50);
        mobileNOLabelTwo.setFont(new Font("Serif", Font.PLAIN, 20));
        mobileNOLabelTwo.setForeground(Color.WHITE);

        JLabel idLabelTwo = new JLabel("Your ID Number - " + idText.getText());
        idLabelTwo.setBounds(20,310,450,50);
        idLabelTwo.setFont(new Font("Serif", Font.PLAIN, 20));
        idLabelTwo.setForeground(Color.WHITE);

        JLabel durationLabelTwo = new JLabel("Duration of Consultation - " + durationText.getText() + " Hours");
        durationLabelTwo.setBounds(20,370,450,50);
        durationLabelTwo.setFont(new Font("Serif", Font.PLAIN, 20));
        durationLabelTwo.setForeground(Color.WHITE);

        JLabel costLabel = new JLabel("Total Cost - " + cost + " Pounds");
        costLabel.setBounds(20,430,450,50);
        costLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        costLabel.setForeground(Color.WHITE);

        JLabel doctorNameLabelTwo = new JLabel("Assigned Doctor - " + "Dr. " + doctorName);
        doctorNameLabelTwo.setBounds(20,490,450,50);
        doctorNameLabelTwo.setFont(new Font("Serif", Font.PLAIN, 20));
        doctorNameLabelTwo.setForeground(Color.WHITE);

        JLabel dateLabelTwo = new JLabel("Booking Date - " + dateText.getText());
        dateLabelTwo.setBounds(20,550,450,50);
        dateLabelTwo.setFont(new Font("Serif", Font.PLAIN, 20));
        dateLabelTwo.setForeground(Color.WHITE);


        exitButton.setBounds(100,680,200,50);
        exitButton.setBackground(Color.white);
        exitButton.addActionListener(this);

        panel5.add(headingLabelTwo);
        panel5.add(nameLabelTwo);
        panel5.add(surnameLabelTwo);
        panel5.add(dobLabelTwo);
        panel5.add(mobileNOLabelTwo);
        panel5.add(idLabelTwo);
        panel5.add(durationLabelTwo);
        panel5.add(costLabel);
        panel5.add(doctorNameLabelTwo);
        panel5.add(dateLabelTwo);
        panel5.add(exitButton);


        frame5.add(panel5);
        frame5.setSize(500,1000);


        frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame5.setVisible(true);
    }

    public void reset(){
        nameText.setText(" ");
        surnameText.setText(" ");
        dobText.setText(" ");
        mobileNoText.setText(" ");
        idText.setText(" ");
        durationText.setText(" ");
        notesText.setText(" ");

    }

    private void checkAvailability() {
        if(checkInTextFile(Objects.requireNonNull(doctorOption.getSelectedItem()) + " " + dateText.getText())){
            System.out.println("This slot has been already booked by someone else.. Sorry for the Inconvenience");
            JFrame warning = new JFrame();
            JOptionPane.showMessageDialog(warning,"This slot has been booked by someone else:(","Alert",JOptionPane.WARNING_MESSAGE);
            Random random = new Random();
            String randomName = choices[random.nextInt(10)];
            doctorName = randomName;
            try{
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("----------Consultation of " +fullName+" "+ "--------------");
                bw.newLine();
                bw.write("A booking has been placed with Dr. "+doctorName + " on the date of " + dateText.getText() +"\n");
                bw.newLine();
                bw.write("Your Total Bill- "+cost +"£");
                bw.newLine();
                bw.write("Encrypted Note- " + Arrays.toString(encryptData(notesText.getText())));
                bw.close();
            }catch (IOException e){
                e.printStackTrace();
            } catch (NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException |
                     BadPaddingException | InvalidKeyException e) {
                throw new RuntimeException(e);
            }
            JOptionPane.showMessageDialog(null,"Therefore, Doctor " + randomName + " has been assigned to you with the same date & time","Message",JOptionPane.INFORMATION_MESSAGE);

        }
        else{
            doctorName = doctorOption.getSelectedItem().toString();
            JOptionPane.showMessageDialog(null,"Booking Successfully Done","Message",JOptionPane.INFORMATION_MESSAGE);

            try{
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("----------Consultation of " +fullName+" "+ "--------------");
                bw.newLine();
                bw.write("A booking has been placed with Dr. "+  doctorOption.getSelectedItem().toString() + " on the date of " + dateText.getText()+ "\n");
                bw.newLine();
                bw.write("Your Total Bill- "+cost +"£");
                bw.newLine();
                bw.write("Encrypted Note- " + Arrays.toString(encryptData(notesText.getText())));
                bw.close();
            }catch (IOException e){
                e.printStackTrace();
            } catch (NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException |
                     BadPaddingException | InvalidKeyException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean checkInTextFile(String text) {
        try{
            BufferedReader buff=new BufferedReader(new FileReader("Consultation.txt"));
            String s;
            while((s=buff.readLine())!=null){
                if(s.trim().contains(text)){
                    return true;
                }
            }
            buff.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }



    private byte[] encryptData(String text) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
            //Creating KeyPair generator object
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

            //Initializing the key pair generator
            keyPairGen.initialize(2048);

            //Generating the pair of keys
            KeyPair pair = keyPairGen.generateKeyPair();

            //Creating a Cipher object
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

            //Initializing a Cipher object
            cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());

            //Adding data to the cipher
            byte[] input = text.getBytes();
            cipher.update(input);

            //encrypting the data
        return cipher.doFinal();
        }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewDoctorButton){
            frame1.dispose();
            doctorDetails();
        }
        else if(e.getSource()==bookDoctorButton){
            frame1.dispose();
            bookDoctor();

        }
        else if(e.getSource()==saveButton){
            fullName = nameText.getText();
            surName = surnameText.getText();
            DOB = dobText.getText();
            mobileNumber = mobileNoText.getText();
            idNumber = notesText.getText();
            hours = idText.getText();
            if(fullName.equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "First Name can not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(surName.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Sir Name can not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(DOB.equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "dob can not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(mobileNumber.equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Mobile can not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(idNumber.equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "ID number can not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(hours.equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Duration can not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                String consultation = JOptionPane.showInputDialog("Is this your first consultation. Type 'Yes' or 'No'");
                if (consultation.equalsIgnoreCase("Yes")) {
                    cost = Integer.parseInt(durationText.getText()) * 15;
                } else {
                    cost = Integer.parseInt(durationText.getText()) * 25;
                }
                checkAvailability();
                JOptionPane.showMessageDialog(null, "Saving Done", "Message", JOptionPane.INFORMATION_MESSAGE);
                frame3.dispose();
                viewPersonalDetails();
            }

        }
        else if(e.getSource()==bookButton){
            try{
                frame4.dispose();
                personalDetails();
            } catch (Exception ex){
                JFrame warning = new JFrame();
                JOptionPane.showMessageDialog(warning,"Date format is incorrect enter it in dd-mm-yyyy format","Date Format Wrong",JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(e.getSource()==backButton){
            frame2.dispose();
            try {
                new ConsultationGUI();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
        else if(e.getSource()== backButtonTwo){
            frame4.dispose();
            doctorDetails();
        }
        else if(e.getSource()==exitButton){
            System.exit(0);

        }
        else if(e.getSource()==resetButton){
            reset();
        }
    }

}

