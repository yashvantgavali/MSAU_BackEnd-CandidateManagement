package com.example.candidatemgmt.bean;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class JoiningDetailsTest {

    JoiningDetails joiningDetails=new JoiningDetails();

    @Test
    void getId() {
        int id=1;
        joiningDetails.setId(id);
        assertEquals(id,joiningDetails.getId());
    }

    @Test
    void setId() {
        int id=1;
        joiningDetails.setId(id);
        assertEquals(id,joiningDetails.getId());
    }

    @Test
    void getDate() {
        String date="17/03/2021";
        joiningDetails.setDate(date);
        assertEquals(date,joiningDetails.getDate());
    }

    @Test
    void setDate() {
        String date="17/03/2021";
        joiningDetails.setDate(date);
        assertEquals(date,joiningDetails.getDate());
    }

    @Test
    void getTechnology() {
        String technology="Java";
        joiningDetails.setTechnology(technology);
        assertEquals(technology,joiningDetails.getTechnology());
    }

    @Test
    void setTechnology() {
        String technology="Java";
        joiningDetails.setTechnology(technology);
        assertEquals(technology,joiningDetails.getTechnology());
    }

    @Test
    void getLocation() {
        String location="Hydrabad";
        joiningDetails.setLocation(location);
        assertEquals(location,joiningDetails.getLocation());
    }

    @Test
    void setLocation() {
        String location="Hydrabad";
        joiningDetails.setLocation(location);
        assertEquals(location,joiningDetails.getLocation());
    }

    @Test
    void getFeedback() {
        String feedback="Very Good";
        joiningDetails.setFeedback(feedback);
        assertEquals(feedback,joiningDetails.getFeedback());
    }

    @Test
    void setFeedback() {
        String feedback="Very Good";
        joiningDetails.setFeedback(feedback);
        assertEquals(feedback,joiningDetails.getFeedback());
    }
}