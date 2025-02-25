package com.hospital.controller;

import com.hospital.dao.NurseRepository;
import entity.Nurse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class NurseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private NurseRepository nurseRepository;

    @InjectMocks
    private NurseController nurseController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(nurseController).build();
    }

    // Test for Get all nurses
    @Test
    public void testGetAllNurses() throws Exception {
        mockMvc.perform(get("/nurse/allnurses"))
                .andExpect(status().isOk());
    }
/*
    // Test for Login
    @Test
    public void testLogin() throws Exception {
        String username = "pgomez";
        String password = "paco123";
        Nurse nurse = new Nurse();
        nurse.setUsername(username);
        nurse.setPassword(password);

        when(nurseRepository.findByUsernameAndPassword(username, password)).thenReturn(Optional.of(nurse));

        mockMvc.perform(post("/nurse/login")
                        .param("username", username)
                        .param("password", password))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
*/
    // Test for Find nurse by name
    @Test
    public void testFindNurseByName() throws Exception {
        String name = "Paco Gomez";
        
        when(nurseRepository.findByNameContaining(name)).thenReturn(List.of(new Nurse()));

        mockMvc.perform(get("/nurse/findnursebyname")
                        .param("name", name))
                .andExpect(status().isOk());
    }

    // Test for Create Nurse
    @Test
    public void testCreateNurse() throws Exception {
        mockMvc.perform(post("/nurse")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "Jose Gonzalez")
                        .param("username", "jgonzalez")
                        .param("password", "jose123"))
                .andExpect(status().isCreated());
    }

    // Test for Read Nurse by ID
    @Test
    public void testGetNurseById() throws Exception {
        int id = 1;
        Nurse nurse = new Nurse();
        nurse.setId(id);

        when(nurseRepository.findById(id)).thenReturn(Optional.of(nurse));

        mockMvc.perform(get("/nurse/" + id))
                .andExpect(status().isOk());
    }

    // Test for Update Nurse
    @Test
    public void testUpdateNurse() throws Exception {
        int id = 1;
        Nurse nurse = new Nurse();
        nurse.setId(id);
        nurse.setName("Paco Gomez");

        when(nurseRepository.findById(id)).thenReturn(Optional.of(nurse));

        mockMvc.perform(put("/nurse/" + id)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "Paco Gomez")
                        .param("username", "pgomez")
                        .param("password", "paco123"))
                .andExpect(status().isOk());
    }

    // Test for Delete Nurse by ID
    @Test
    public void testDeleteNurseById() throws Exception {
        int id = 4;

        when(nurseRepository.existsById(id)).thenReturn(true);

        mockMvc.perform(delete("/nurse/" + id))
                .andExpect(status().isOk())
                .andExpect(content().string("Nurse deleted successfully"));
    }
}
