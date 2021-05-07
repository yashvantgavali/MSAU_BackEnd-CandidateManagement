package com.example.candidatemgmt.bean;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class Ternds1RowMapperTest {

    @Mock
    ResultSet rs;

    Ternds1RowMapper ternds1RowMapper=new Ternds1RowMapper();

    @Test
    void mapRow() throws SQLException {
        String date="2021" ;
        int id=1;

        Mockito.when(rs.getInt("count(id)")).thenReturn(id);
        Mockito.when(rs.getString("date")).thenReturn(date);

        Trends1 trends1= (Trends1) ternds1RowMapper.mapRow(rs,0);

        assertNotNull(trends1);


        assertEquals(date,trends1.getDate());
        assertEquals(id,trends1.getId());

    }
}