package com.example.candidatemgmt.controller;

import com.example.candidatemgmt.bean.JoiningDetails;
import com.example.candidatemgmt.respository.JoiningDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
//@WebMvcTest(controllers = JoiningDetailsController.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JoiningDetailsControllerTest {

    @LocalServerPort
    private int port;

    TestRestTemplate testRestTemplate=new TestRestTemplate();
    HttpHeaders headers=new HttpHeaders();
    HttpEntity<List<JoiningDetails>> entity=new HttpEntity<>(null,headers);

    Class<JoiningDetails> joiningDetailsClass=(Class) List.class;

    @InjectMocks
    JoiningDetailsController joiningDetailsController;

    @MockBean
    JoiningDetailsRepository joiningDetailsRepository;

    @Autowired
    private MockMvc mockMvc;

    List<JoiningDetails> list;
    JoiningDetails joiningDetails1=new JoiningDetails();
    @BeforeEach
    void setup()
    {
        list=new ArrayList<JoiningDetails>();

        joiningDetails1=new JoiningDetails();
        joiningDetails1.setId(1);
        joiningDetails1.setLocation("Mumbai");
        joiningDetails1.setTechnology("Java");
        joiningDetails1.setFeedback("Very Good");
        joiningDetails1.setDate("2020");

        list.add(joiningDetails1);

        JoiningDetails joiningDetails2=new JoiningDetails();
        joiningDetails2.setId(2);
        joiningDetails2.setLocation("Mumbai");
        joiningDetails2.setTechnology("Java-Spring boot");
        joiningDetails2.setFeedback("Very Good");
        joiningDetails2.setDate("2021");

        list.add(joiningDetails2);

    }

    @Test
    void test1() {
        String expected="testing";
        assertEquals(expected,joiningDetailsController.test());
    }

    @Test
    void getAllJoiningDetails() throws Exception {
        when(joiningDetailsRepository.getJoiningDetails()).thenReturn(list);

        this.mockMvc.perform(get("/joining")).andExpect(status().isOk());

    }

    @Test
    void getJoiningDetails() throws Exception {
        when(joiningDetailsRepository.findById(1)).thenReturn(joiningDetails1);

        this.mockMvc.perform(get("/joining/1")).andExpect(status().isOk());
    }

    @Test
    void createJoiningDetails() throws Exception{
        URI url=new URI("/joining");

        ResponseEntity<Object> response=testRestTemplate.exchange(url, HttpMethod.PUT, entity, new ParameterizedTypeReference<Object>() {
        });
       assertTrue(response.getStatusCode()== HttpStatus.OK);
    }

    @Test
    void updateJoiningDetails() {
    }

    @Test
    void deleteJoiningDetails() {
    }

    @Test
    void getCountPerYear() {

    }
}