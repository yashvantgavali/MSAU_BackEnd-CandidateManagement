package com.example.candidatemgmt.bean;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Ternds1RowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Trends1 trends1=new Trends1();
        trends1.setDate(resultSet.getString("date"));
        trends1.setId(resultSet.getInt("count(id)"));
        return trends1;
    }
}
