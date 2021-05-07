package com.example.candidatemgmt.bean;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class Trends1Test {

    Trends1 trends1=new Trends1();

    @Test
    void getDate() {
        String date="2021";
        trends1.setDate(date);
        assertEquals(date,trends1.getDate());
    }

    @Test
    void setDate() {
        String date="2021";
        trends1.setDate(date);
        assertEquals(date,trends1.getDate());
    }

    @Test
    void getId() {
        int id=1;
        trends1.setId(id);
        assertEquals(id,trends1.getId());
    }

    @Test
    void setId() {
        int id=1;
        trends1.setId(id);
        assertEquals(id,trends1.getId());
    }
}