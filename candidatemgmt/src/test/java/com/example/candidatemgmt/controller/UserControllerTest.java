package com.example.candidatemgmt.controller;

import com.example.candidatemgmt.bean.User;
import com.example.candidatemgmt.respository.UserRespository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest{

    @InjectMocks
    UserController userController;

    @MockBean
    UserRespository userRespository;

//    @Autowired
//    MockMvc mockMvc;

    TestRestTemplate testRestTemplate= new TestRestTemplate();

    @LocalServerPort
    int port;

    HttpHeaders httpHeaders=new HttpHeaders();
    HttpEntity<List<User>> entity=new HttpEntity<>(null,httpHeaders);

    @SuppressWarnings("unchecked")
            Class<List<User>> userli= (Class)List.class;

    User user;
    List<User> userList;


    @BeforeEach
    void setUp() {
        userList=new ArrayList<>();
        user=new User();
        user.setId(1);
        user.setFirstname("YashTest");
        user.setLastname("GavaliTest");
        user.setPhoneno("9561");
        user.setEmail("yashtest@gmail.com");
        user.setBirthdate("");
        user.setCity("punetest");
        user.setCountry("India");

        userList.add(user);

    }

    @Test
    void test1() {
        String test="testing";
        assertEquals(test,"testing");

    }

//    @Test
//    void getAllUsers() throws Exception{
//
//        Mockito.when(userRespository.getUser()).thenReturn(userList);
//        this.mockMvc.perform(get("/user").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.size()", is(1)));
//    }

//    @Test
//    void getUser() throws Exception{
//        Mockito.when(userRespository.findById(2)).thenReturn(user);
//
//        this.mockMvc.perform(get("/user/2")).andExpect(status().isOk());
//
//    }

    @Test
    void createUser() {

    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() throws Exception {
//        URI url=new URI("/user");
        String url="/user";
        HttpEntity<User> entity=new HttpEntity<>(userList.get(0),httpHeaders);

        ResponseEntity<String> response=testRestTemplate.exchange(url, HttpMethod.POST, entity, new ParameterizedTypeReference<String>() {});

        System.out.println(response.getStatusCode());
        assertTrue(response.getStatusCode()==HttpStatus.OK);
    }
}