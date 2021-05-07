package com.example.candidatemgmt.bean;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Trends4RowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Trends4 trends4=new Trends4();

        trends4.setId(resultSet.getInt("count(id)"));
        trends4.setCourse(resultSet.getString("course"));

        return trends4;
    }
}
