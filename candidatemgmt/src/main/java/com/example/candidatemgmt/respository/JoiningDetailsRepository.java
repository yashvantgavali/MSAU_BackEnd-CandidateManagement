package com.example.candidatemgmt.respository;

//import com.example.candidatemgmt.bean.User;
//import com.example.candidatemgmt.bean.UserRowMapper;
import com.example.candidatemgmt.bean.*;
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
public class JoiningDetailsRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<JoiningDetails> getJoiningDetails(){
        return  jdbcTemplate.query("select * from joiningdetails",new JoiningDetailsRowMapper());
    }

    public JoiningDetails findById(Integer id){

        String sql = "SELECT * FROM joiningdetails WHERE ID = ?";
        try{
            return  (JoiningDetails) this.jdbcTemplate.queryForObject(
                    sql, new Object[] { id }, new JoiningDetailsRowMapper());
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }

    }

    public Boolean saveJoiningDetails(JoiningDetails joiningDetails){
        String query="insert into joiningdetails values(?,?,?,?,?)";
        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setInt(1,joiningDetails.getId());
                ps.setString(2,joiningDetails.getDate());
                ps.setString(3,joiningDetails.getTechnology());
                ps.setString(4,joiningDetails.getLocation());
                ps.setString(5,joiningDetails.getFeedback());



                return ps.execute();

            }
        });
    }

    public Integer updateJoiningDetails(JoiningDetails joiningDetails){
        String query="update joiningdetails set date = ? , technology = ? , location = ? , feedback= ? where id = ?";
        Object[] params = {joiningDetails.getDate(),joiningDetails.getTechnology(),joiningDetails.getLocation(),joiningDetails.getFeedback(),joiningDetails.getId()};
        int[] types = {Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER};

        return jdbcTemplate.update(query, params, types);
    }

    public Integer deleteJoiningDetailsById(Integer id){
        return jdbcTemplate.update("delete from joiningdetails where id = ?",id);
    }
    public List<Trends1> getCountPerYear()
    {
        return  jdbcTemplate.query("select date , count(id) from joiningdetails group by date",new Ternds1RowMapper());
    }
    public  List<Trends2> getCountPerLocation()
    {
        return  jdbcTemplate.query("select location , count(id) from joiningdetails group by location",new Trends2RowMapper());
    }
    public  List<Trends3> getCountPerTechnology()
    {
        return  jdbcTemplate.query("select technology , count(id) from joiningdetails group by technology",new Trends3RowMapper());
    }
}


