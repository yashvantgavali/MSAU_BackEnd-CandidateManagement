package com.example.candidatemgmt.bean;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        User user=new User();
        user.setId(resultSet.getInt("id"));
        user.setFirstname(resultSet.getString("firstname"));
        user.setLastname(resultSet.getString("lastname"));
        user.setPhoneno(resultSet.getString("phoneno"));
        user.setEmail(resultSet.getString("email"));
        user.setBirthdate(resultSet.getString("birthdate"));
        user.setCity(resultSet.getString("city"));
        user.setCountry(resultSet.getString("country"));

        return user;
    }
}
