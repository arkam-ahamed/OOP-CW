package test;


import main.model.Doctor;
import main.service.WestminsterSkinConsultationManagerService;
import main.service.impl.WestminsterSkinConsultationManagerServiceImpl;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class WestminsterSkinConsultationManagerServiceImplTest{
    WestminsterSkinConsultationManagerService service = new WestminsterSkinConsultationManagerServiceImpl();
    @Rule
    public ResourceFile res = new ResourceFile();



    @Test
    public void saveFileTest() throws IOException {
        service.saveFile();

        //checking whether the saved file exists
        assertTrue(res.getFile().exists());
    }

    @Test
        public void loadFileTest(){
        //loading the saved file data
        service.loadFile();
        }

    @Test
    public void addDoctorTest() {
        Doctor doctor = new Doctor();
        doctor.setName("Arkam");
        doctor.setSurname("Ahamed");
        doctor.setDOB("2022/05/20");
        doctor.setMobileNo("0758343194");
        doctor.setMedicalLicenseNo("1234");
        doctor.setSpecialization("heart surgery");

        //when invoked, should specify the same values in order to pass the test
        assertEquals(doctor, service.addDoctor(doctor));
    }

    @Test
    public void deleteDoctorTest() {
        Doctor doctor = new Doctor();
        doctor.setName("Arkam");
        doctor.setSurname("Ahamed");
        doctor.setDOB("2022/05/20");
        doctor.setMobileNo("0758343194");
        doctor.setMedicalLicenseNo("1234");
        doctor.setSpecialization("heart surgery");

        //when invoked, should specify the same values in order to pass the test
        service.addDoctor(doctor);

        //enter 1234 as the medical number to test deleting the above object created
        service.deleteDoctor();

        //enter 1234 as the medical number to test the above deleted object exists or not
        service.deleteDoctor();
    }

    @Test
    public void getAllDoctorTest() {
        Doctor doctor = new Doctor();
        doctor.setName("Arkam");
        doctor.setSurname("Ahamed");
        doctor.setDOB("2022/05/20");
        doctor.setMobileNo("0758343194");
        doctor.setMedicalLicenseNo("1234");
        doctor.setSpecialization("heart surgery");

        //when invoked, should specify the same values in order to pass the test
        service.addDoctor(doctor);

        //we should get the above created doctor
        service.getAllDoctors();
    }
    @Test
    public void sortBySurnameTest(){
        List<Doctor> doctorList = new ArrayList<>();
        Doctor doctor1= new Doctor();
        doctor1.setName("john");
        doctor1.setSurname("doe");
        doctor1.setDOB("2022/05/20");
        doctor1.setMobileNo("0758343194");
        doctor1.setMedicalLicenseNo("1234");
        doctor1.setSpecialization("heart surgery");

        doctorList.add(doctor1);

        Doctor doctor2 = new Doctor();
        doctor2.setName("Arkam");
        doctor2.setSurname("Ahamed");
        doctor2.setDOB("2022/05/20");
        doctor2.setMobileNo("0758343194");
        doctor2.setMedicalLicenseNo("1234");
        doctor2.setSpecialization("heart surgery");

        doctorList.add(doctor2);

        List<Doctor> sortedDoctorsList = WestminsterSkinConsultationManagerService.sortBySurname(doctorList);
        Assert.assertSame(doctor2,sortedDoctorsList.get(0));
    }
}