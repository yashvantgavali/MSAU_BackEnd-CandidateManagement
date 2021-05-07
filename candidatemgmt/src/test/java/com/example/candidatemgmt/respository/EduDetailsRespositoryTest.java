package com.example.candidatemgmt.respository;

import com.example.candidatemgmt.bean.EduDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EduDetailsRespositoryTest {

    @Autowired
    EduDetailsRespository eduDetailsRespository;

    @Test
    void getEdudetails() {
        int excepted= eduDetailsRespository.getEdudetails().size();
        assertEquals(excepted,eduDetailsRespository.getEdudetails().size());
    }

    @Test
    void findById() {
        int id=eduDetailsRespository.getEdudetails().get(0).getId();
        assertEquals(id,eduDetailsRespository.findById(id).getId());
    }

    @Test
    void saveEdudetails() {
        int id=100;
        String clgname="A.k Jr";

        EduDetails eduDetails=new EduDetails();
        eduDetails.setId(id);
        eduDetails.setClgname(clgname);

        eduDetailsRespository.saveEdudetails(eduDetails);

        EduDetails savedEdudetails=eduDetailsRespository.findById(id);

        assertEquals(id,savedEdudetails.getId());
        assertEquals(clgname,savedEdudetails.getClgname());
    }

    @Test
    void updateEdudetails() {
        EduDetails eduDetails=eduDetailsRespository.getEdudetails().get(0);
        int id=eduDetails.getId();
        String clgname=eduDetails.getClgname();

        assertEquals(id,eduDetailsRespository.findById(id).getId());
        assertEquals(clgname,eduDetailsRespository.findById(id).getClgname());
    }

    @Test
    void deleteEdudetailsById() {
        EduDetails eduDetails=eduDetailsRespository.getEdudetails().get(0);
        int id=eduDetails.getId();
        assertNotNull(eduDetailsRespository.deleteEdudetailsById(id));

    }
}