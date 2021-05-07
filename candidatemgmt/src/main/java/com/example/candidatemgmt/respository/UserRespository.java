package com.example.candidatemgmt.respository;

import com.example.candidatemgmt.bean.User;
import com.example.candidatemgmt.bean.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;


@Repository
public class UserRespository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getUser(){
        return  jdbcTemplate.query("select * from user",new UserRowMapper());
    }

    public User findById(Integer id){

        String sql = "SELECT * FROM user WHERE ID = ?";
        try{
            return  (User) this.jdbcTemplate.queryForObject(
                    sql, new Object[] { id }, new UserRowMapper());
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }

    }

    public Boolean saveUser(User user){
        String query="insert into user values(?,?,?,?,?,?,?,?)";
        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setInt(1,user.getId());
                ps.setString(2,user.getFirstname());
                ps.setString(3,user.getLastname());
                ps.setString(4,user.getPhoneno());
                ps.setString(5,user.getEmail());
                ps.setString(6,user.getBirthdate());
                ps.setString(7,user.getCity());
                ps.setString(8,user.getCountry());


                return ps.execute();


            }
        });
    }

    public Integer updateUser(User user){
        String query="update user set firstname = ? , lastname = ? , phoneno = ? , email = ? , birthdate = ?,city = ? , country = ? where id = ?";
        Object[] params = {user.getFirstname(), user.getLastname(),user.getPhoneno(),user.getEmail(),user.getBirthdate(),user.getCity(),user.getCountry(), user.getId()};
        int[] types = {Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER};

        return jdbcTemplate.update(query, params, types);
    }

    public Integer deleteUserById(Integer id){
        return jdbcTemplate.update("delete from user where id = ?",id);
    }
}

