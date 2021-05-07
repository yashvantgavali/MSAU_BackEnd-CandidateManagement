package com.example.candidatemgmt.respository;

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
public class EduDetailsRespository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<EduDetails> getEdudetails(){
        return  jdbcTemplate.query("select * from edudetails",new EduDetailsRowMapper());
    }

    public EduDetails findById(Integer id){

        String sql = "SELECT * FROM edudetails WHERE ID = ?";
        try{
            return  (EduDetails) this.jdbcTemplate.queryForObject(
                    sql, new Object[] { id }, new EduDetailsRowMapper());
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }

    }

    public Boolean saveEdudetails(EduDetails eduDetails){
        String query="insert into edudetails values(?,?,?,?,?)";
        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setInt(1,eduDetails.getId());
                ps.setString(2,eduDetails.getClgname());
                ps.setString(3,eduDetails.getUniversityname());
                ps.setString(4,eduDetails.getCourse());
                ps.setString(5,eduDetails.getAddress());



                return ps.execute();

            }
        });
    }

    public Integer updateEdudetails(EduDetails eduDetails){
        String query="update edudetails set clgname = ? , universityname = ? , course = ? , address = ? where id = ?";
        Object[] params = {eduDetails.getClgname(),eduDetails.getUniversityname(),eduDetails.getCourse(),eduDetails.getAddress(),eduDetails.getId()};
        int[] types = {Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER};

        return jdbcTemplate.update(query, params, types);
    }

    public Integer deleteEdudetailsById(Integer id){
        return jdbcTemplate.update("delete from edudetails where id = ?",id);
    }

    public List<Trends4> getCountPerCourse()
    {
        return  jdbcTemplate.query("select course , count(id) from edudetails group by course",new Trends4RowMapper());
    }
}

