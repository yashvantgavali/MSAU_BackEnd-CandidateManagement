package com.example.candidatemgmt.bean;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EduDetailsTest {

    EduDetails eduDetails=new EduDetails();

    @Test
    void getId() {
        int id=1;
        eduDetails.setId(id);
        assertEquals(id,eduDetails.getId());
    }

    @Test
    void setId() {
        int id=1;
        eduDetails.setId(id);
        assertEquals(id,eduDetails.getId());
    }

    @Test
    void getClgname() {
        String clgname="A.K Jr college";
        eduDetails.setClgname(clgname);
        assertEquals(clgname,eduDetails.getClgname());
    }

    @Test
    void setClgname() {
        String clgname="A.K Jr college";
        eduDetails.setClgname(clgname);
        assertEquals(clgname,eduDetails.getClgname());
    }

    @Test
    void getUniversityname() {
        String universityname="Pune University";
        eduDetails.setUniversityname(universityname);
        assertEquals(universityname,eduDetails.getUniversityname());
    }

    @Test
    void setUniversityname() {
        String universityname="Pune University";
        eduDetails.setUniversityname(universityname);
        assertEquals(universityname,eduDetails.getUniversityname());
    }

    @Test
    void getCourse() {
        String course="BE";
        eduDetails.setCourse(course);
        assertEquals(course,eduDetails.getCourse());
    }

    @Test
    void setCourse() {
        String course="BE";
        eduDetails.setCourse(course);
        assertEquals(course,eduDetails.getCourse());
    }

    @Test
    void getAddress() {
        String address="Mumbai";
        eduDetails.setAddress(address);
        assertEquals(address,eduDetails.getAddress());
    }

    @Test
    void setAddress() {
        String address="Mumbai";
        eduDetails.setAddress(address);
        assertEquals(address,eduDetails.getAddress());
    }
}