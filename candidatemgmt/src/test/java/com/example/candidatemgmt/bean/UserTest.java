package com.example.candidatemgmt.bean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTest {

    User user=new User();

    @Test
    void getBirthdate() {
        String birthdate="17/10/1999";
        user.setBirthdate(birthdate);
        assertEquals(birthdate,user.getBirthdate());
    }

    @Test
    void setBirthdate() {
        String birthdate="17/10/1999";
        user.setBirthdate(birthdate);
        assertEquals(birthdate,user.getBirthdate());
    }

    @Test
    void getId() {
        int id=1;
        user.setId(id);
        assertEquals(id,user.getId());
    }

    @Test
    void setId() {
        int id=1;
        user.setId(id);
        assertEquals(id,user.getId());
    }

    @Test
    void getFirstname() {
        String firstname="yash";
        user.setFirstname(firstname);
        assertEquals(firstname,user.getFirstname());
    }

    @Test
    void setFirstname() {
        String firstname="yash";
        user.setFirstname(firstname);
        assertEquals(firstname,user.getFirstname());
    }

    @Test
    void getLastname() {
        String lastname="gavali";
        user.setLastname(lastname);
        assertEquals(lastname,user.getLastname());
    }

    @Test
    void setLastname() {
        String lastname="gavali";
        user.setLastname(lastname);
        assertEquals(lastname,user.getLastname());
    }

    @Test
    void getCity() {
        String city="pune";
        user.setCity(city);
        assertEquals(city,user.getCity());
    }

    @Test
    void setCity() {
        String city="pune";
        user.setCity(city);
        assertEquals(city,user.getCity());

    }

    @Test
    void getCountry() {
        String country="INDIA";
        user.setCountry(country);
        assertEquals(country,user.getCountry());
    }

    @Test
    void setCountry() {
        String country="INDIA";
        user.setCountry(country);
        assertEquals(country,user.getCountry());
    }

    @Test
    void getPhoneno() {
        String phoneno="9561";
        user.setPhoneno(phoneno);
        assertEquals(phoneno,user.getPhoneno());
    }

    @Test
    void setPhoneno() {
        String phoneno="9561";
        user.setPhoneno(phoneno);
        assertEquals(phoneno,user.getPhoneno());
    }

    @Test
    void getEmail() {
        String email="yash@gmail.com";
        user.setEmail(email);
        assertEquals(email,user.getEmail());
    }

    @Test
    void setEmail() {
        String email="yash@gmail.com";
        user.setEmail(email);
        assertEquals(email,user.getEmail());
    }
}