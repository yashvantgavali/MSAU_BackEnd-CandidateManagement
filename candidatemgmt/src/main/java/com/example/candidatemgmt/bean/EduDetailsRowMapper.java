package com.example.candidatemgmt.bean;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EduDetailsRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        EduDetails eduDetails=new EduDetails();

        eduDetails.setId(resultSet.getInt("id"));
        eduDetails.setClgname(resultSet.getString("clgname"));
        eduDetails.setUniversityname(resultSet.getString("universityname"));
        eduDetails.setCourse(resultSet.getString("course"));
        eduDetails.setAddress(resultSet.getString("address"));

        return eduDetails;
    }
}
