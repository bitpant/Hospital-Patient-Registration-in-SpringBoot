package com.patient.registration.patientdetails;

import com.patient.registration.patientDetails.beans.Patient;
import com.patient.registration.patientDetails.beans.Practice;
import com.patient.registration.patientDetails.controller.PatientController;
import com.patient.registration.patientDetails.repository.PatientRepository;
import com.patient.registration.patientDetails.repository.PraticeRepository;
import com.patient.registration.patientDetails.service.PatientService;
import com.patient.registration.patientDetails.service.PracticeService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;


import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDetailsApplicationTests {

    private MockMvc mockMvc;
    @InjectMocks
    private PatientService patientService;

    @InjectMocks
    private PracticeService practiceService;

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private PraticeRepository praticeRepository;

    @InjectMocks
    private PatientController patientController;

    @Mock
    private PracticeService practiceServicemock;

    @Mock
    private PatientService patientServiceMock;

    @Spy
    private Patient patient;


    @Autowired
    private WebApplicationContext wac;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void contextLoads() {
    }


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void verifyGetAllpatientService() throws Exception {

        List<Patient> mockList = Arrays.asList(new Patient(1, "Brijesh", new SimpleDateFormat("yyyy-MM-dd").parse("1962-07-15"), "Delhi", 987654321, 101),
                new Patient(2, "Dheeraj", new SimpleDateFormat("yyyy-MM-dd").parse("1962-07-15"), "Pune", 740935415, 102));


        Mockito.when(
                patientRepository.findAll()).thenReturn(mockList);
        List<Patient> result = patientService.getAllPatients();
        assertEquals(2, result.size());


    }

    @Test
    public void verifyGetAllpatientbyPracticeId() throws Exception {

        List<Patient> mockList = Arrays.asList(new Patient(1, "Brijesh", new SimpleDateFormat("yyyy-MM-dd").parse("1962-07-15"), "Delhi", 987654321, 101),
                new Patient(2, "Dheeraj", new SimpleDateFormat("yyyy-MM-dd").parse("1962-07-15"), "Pune", 740935415, 102));


        Mockito.when(
                patientRepository.findBypraticeid(1)).thenReturn(mockList);
        List<Patient> result = patientService.getPatientByPracticeId(1);
        assertEquals(2, result.size());


    }

    @Test
    public void verifyGetAllPracticeService() throws Exception {

        List<Practice> mockList = Arrays.asList(new Practice((long) 1, "Brijesh"),
                new Practice((long) 2, "Dheeraj"));


        Mockito.when(
                praticeRepository.findAll()).thenReturn(mockList);
        List<Practice> result = practiceService.getAllPractice();
        assertEquals(2, result.size());


    }

    @Test
    public void verifyGetPatientbyIdService() throws Exception {
        List<Patient> mockList = Arrays.asList(new Patient(1, "Brijesh", new SimpleDateFormat("yyyy-MM-dd").parse("1962-07-15"), "Delhi", 987654321, 101),
                new Patient(2, "Dheeraj", new SimpleDateFormat("yyyy-MM-dd").parse("1962-07-15"), "Pune", 740935415, 102));

        when(patientRepository.findAll()).thenReturn(mockList);
        Patient result = patientService.getPatientById(2);
        assertEquals(2, result.getPatientId());
        assertEquals("Dheeraj", result.getPatientName());
    }


    @Test
    public void verifyDeletePatient() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/patient/deletePatient/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.patientName").value("Patient_1"));


    }

    @Test
    public void testUserController() throws Exception {
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post("/patient/addPatients")
                        .header("Content-Type",
                                "application/json")
                        .content("{\n" +

                                "        \"patientName\": \"Saumya\",\n" +
                                "        \"patientDOB\": \"2014-01-01\",\n" +
                                "        \"patientAddress\": \"Kathmandu\",\n" +
                                "        \"patientMobile\": 7017925693,\n" +
                                "        \"praticeId\": 1\n" +
                                "    }");
        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status()
                        .isNotFound())
                .andDo(MockMvcResultHandlers.print());

    }
    @Test
    public void verifySavePatient() throws Exception {


        Patient patient = new Patient(2, "Dheeraj", new SimpleDateFormat("yyyy-MM-dd").parse("1962-07-15"), "Pune", 740935415, 101);
        List<Patient> mockList = Arrays.asList(new Patient(1, "Brijesh", new SimpleDateFormat("yyyy-MM-dd").parse("1962-07-15"), "Delhi", 987654321, 101));

        Mockito.when(patientRepository.findAll()).thenReturn(mockList);
        //Mockito.when(patient.getPraticeid()).thenReturn(Long.valueOf(101));
        Mockito.when(patientRepository.save(patient)).thenReturn(patient);
        Patient p = patientService.addPatient(patient);
        assertEquals(null, p);
    }

    @Test
    public void verifySavePatientService() throws Exception {


        Patient patient = new Patient(2, "Dheeraj", new SimpleDateFormat("yyyy-MM-dd").parse("1962-07-15"), "Pune", 740935415, 101);
        List<Practice> mockList = Arrays.asList(new Practice((long) 101, "Brijesh"));
        Mockito.when(praticeRepository.findAll()).thenReturn(mockList);
        Mockito.when(patientRepository.save(patient)).thenReturn(patient);
        Patient p = patientService.addPatient(patient);
        assertEquals("Dheeraj", p.getPatientName());
    }

    @Test
    public void verifyUpdatePatientService() throws Exception {


        Patient patient = new Patient(2, "Dheeraj", new SimpleDateFormat("yyyy-MM-dd").parse("1962-07-15"), "Pune", 740935415, 101);
        List<Patient> mockList = Arrays.asList(new Patient(2, "Brijesh", new SimpleDateFormat("yyyy-MM-dd").parse("1962-07-15"), "Delhi", 987654321, 101));
        Mockito.when(patientRepository.findAll()).thenReturn(mockList);
        Mockito.when(patientRepository.save(patient)).thenReturn(patient);
        Patient p = patientService.updatePatient(patient);
        assertEquals("Brijesh", p.getPatientName());
    }

    @Test
    public void verifygetAllPractice() throws Exception {
        List<Practice> mockList = Arrays.asList(new Practice((long) 1, "Brijesh"),
                new Practice((long) 2, "Dheeraj"));
        Mockito.when(
                practiceServicemock.getAllPractice()).thenReturn(mockList);
        List<Practice> result = patientController.getAllpractice();
        assertEquals(2, result.size());

    }

    @Test
    public void verifyGetPatientByPracticeId() throws Exception {
        List<Patient> mockList = Arrays.asList(new Patient(1, "Brijesh", new SimpleDateFormat("yyyy-MM-dd").parse("1962-07-15"), "Delhi", 987654321, 101));

        Mockito.when(
                patientServiceMock.getPatientByPracticeId(1)).thenReturn(mockList);
        List<Patient> result = patientController.getPatientByPracticeId(Long.valueOf(1));
        assertEquals(1, result.size());

    }

    @Test
    public void verifyGetAllPatients() throws Exception {
        List<Patient> mockList = Arrays.asList(new Patient(1, "Brijesh", new SimpleDateFormat("yyyy-MM-dd").parse("1962-07-15"), "Delhi", 987654321, 101));

        Mockito.when(
                patientServiceMock.getAllPatients()).thenReturn(mockList);
        List<Patient> result = patientController.getAllpatient();
        assertEquals(1, result.size());

    }


}
