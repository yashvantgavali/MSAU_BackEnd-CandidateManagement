package com.example.candidatemgmt.bean;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Trends3RowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Trends3 trends3=new Trends3();

        trends3.setTechnology(resultSet.getString("technology"));
        trends3.setId(resultSet.getInt("count(id)"));

        return trends3;

    }
}
