package com.example.candidatemgmt.bean;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRowMapperTest {

   @Mock
    ResultSet rs;

   UserRowMapper userRowMapper=new UserRowMapper();
    @Test
    void mapRow() throws SQLException {
        int id=1;
        String firstname="yash";
        String lasatname="gavali";
        String email="yash@gmail.com";
        String phoneno="9156";
        String birthdate="17/10/1999";
        String city="pune";
        String country="INDIA";

        Mockito.when(rs.getInt("id")).thenReturn(id);
        Mockito.when(rs.getString("firstname")).thenReturn(firstname);
        Mockito.when(rs.getString("lastname")).thenReturn(lasatname);
        Mockito.when(rs.getString("phoneno")).thenReturn(phoneno);
        Mockito.when(rs.getString("email")).thenReturn(email);
        Mockito.when(rs.getString("birthdate")).thenReturn(birthdate);
        Mockito.when(rs.getString("city")).thenReturn(city);
        Mockito.when(rs.getString("country")).thenReturn(country);

        User user= (User) userRowMapper.mapRow(rs,0);

        assertNotNull(user);

        assertEquals(id,user.getId());
        assertEquals(firstname,user.getFirstname());
        assertEquals(lasatname,user.getLastname());
        assertEquals(phoneno,user.getPhoneno());
        assertEquals(email,user.getEmail());
        assertEquals(birthdate,user.getBirthdate());
        assertEquals(city,user.getCity());
        assertEquals(country,user.getCountry());






    }
}