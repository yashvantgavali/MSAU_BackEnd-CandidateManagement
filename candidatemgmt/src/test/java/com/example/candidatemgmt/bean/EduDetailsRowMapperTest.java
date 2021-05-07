package com.example.candidatemgmt.bean;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EduDetailsRowMapperTest {

    @Mock
    ResultSet rs;
    EduDetailsRowMapper eduDetailsRowMapper=new EduDetailsRowMapper();
    @Test
    void mapRow() throws SQLException {
        int id=1;
        String clgname="A.K Jr College";
        String universityname="Pune University";
        String course="BE";
        String address="Pune";

        Mockito.when(rs.getInt("id")).thenReturn(id);
        Mockito.when(rs.getString("clgname")).thenReturn(clgname);
        Mockito.when(rs.getString("universityname")).thenReturn(universityname);
        Mockito.when(rs.getString("course")).thenReturn(course);
        Mockito.when(rs.getString("address")).thenReturn(address);

        EduDetails eduDetails= (EduDetails) eduDetailsRowMapper.mapRow(rs,0);

        assertNotNull(eduDetails);

        assertEquals(id,eduDetails.getId());
        assertEquals(clgname,eduDetails.getClgname());
        assertEquals(universityname,eduDetails.getUniversityname());
        assertEquals(course,eduDetails.getCourse());
        assertEquals(address,eduDetails.getAddress());



    }
}