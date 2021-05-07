package com.example.candidatemgmt.bean;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Trends2RowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Trends2 trends2=new Trends2();
        trends2.setLocation(resultSet.getString("location"));
        trends2.setId(resultSet.getInt("count(id)"));

        return  trends2;
    }
}
