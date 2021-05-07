package com.example.candidatemgmt.bean;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JoiningDetailsRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        JoiningDetails joiningDetails=new JoiningDetails();

        joiningDetails.setId(resultSet.getInt("id"));
        joiningDetails.setDate(resultSet.getString("date"));
        joiningDetails.setTechnology(resultSet.getString("technology"));
        joiningDetails.setLocation(resultSet.getString("location"));
        joiningDetails.setFeedback(resultSet.getString("feedback"));

        return joiningDetails;
    }
}
