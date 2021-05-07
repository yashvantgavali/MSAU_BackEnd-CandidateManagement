package com.example.candidatemgmt.bean;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JoiningDetailsRowMapperTest {

    @Mock
    ResultSet rs;

    JoiningDetailsRowMapper joiningDetailsRowMapper=new JoiningDetailsRowMapper();

    @Test
    void mapRow() throws SQLException {
        int id=1;
        String date="2020";
        String technology="java";
        String location="Mumbai";
        String feedback="Very Good";

        Mockito.when(rs.getInt("id")).thenReturn(id);
        Mockito.when(rs.getString("date")).thenReturn(date);
        Mockito.when(rs.getString("technology")).thenReturn(technology);
        Mockito.when(rs.getString("location")).thenReturn(location);
        Mockito.when(rs.getString("feedback")).thenReturn(feedback);

        JoiningDetails joiningDetails= (JoiningDetails) joiningDetailsRowMapper.mapRow(rs,0);

        assertNotNull(joiningDetails);

        assertEquals(id,joiningDetails.getId());
        assertEquals(date,joiningDetails.getDate());
        assertEquals(technology,joiningDetails.getTechnology());
        assertEquals(location,joiningDetails.getLocation());
        assertEquals(feedback,joiningDetails.getFeedback());


    }
}