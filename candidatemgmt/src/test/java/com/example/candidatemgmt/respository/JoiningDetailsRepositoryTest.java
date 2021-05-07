package com.example.candidatemgmt.respository;

import com.example.candidatemgmt.bean.JoiningDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JoiningDetailsRepositoryTest {

    @Autowired
    JoiningDetailsRepository joiningDetailsRepository;

    @Test
    void getJoiningDetails() {
        int expected=joiningDetailsRepository.getJoiningDetails().size();
        List<JoiningDetails> list=joiningDetailsRepository.getJoiningDetails();
        assertEquals(expected,joiningDetailsRepository.getJoiningDetails().size());
    }

    @Test
    void findById() {
        int id=2;
        assertEquals(id,joiningDetailsRepository.findById(id).getId());
    }

    @Test
    void saveJoiningDetails() {
        int id=100;
        String location="Mumbai";
        JoiningDetails joiningDetails=new JoiningDetails();

        joiningDetails.setId(id);
        joiningDetails.setLocation(location);
        JoiningDetails savedJoiningdetails=new JoiningDetails();

        joiningDetailsRepository.saveJoiningDetails(joiningDetails);

            savedJoiningdetails = joiningDetailsRepository.findById(id);
            assertEquals(id, savedJoiningdetails.getId());
            assertEquals(location, savedJoiningdetails.getLocation());




    }

    @Test
    void updateJoiningDetails() {
        JoiningDetails joiningDetails=joiningDetailsRepository.getJoiningDetails().get(0);
        int id=joiningDetails.getId();
        String location="Updated Location";

        joiningDetails.setLocation(location);

        joiningDetailsRepository.updateJoiningDetails(joiningDetails);

        JoiningDetails updatedJoiningDetails=joiningDetailsRepository.findById(id);

        assertEquals(id,updatedJoiningDetails.getId());
        assertEquals(location,updatedJoiningDetails.getLocation());

    }

    @Test
    void deleteJoiningDetailsById() {
        JoiningDetails joiningDetails=joiningDetailsRepository.getJoiningDetails().get(0);
        int id=joiningDetails.getId();
        assertNotNull(joiningDetailsRepository.deleteJoiningDetailsById(id));

    }

    @Test
    void getCountPerYear() {
        assertNotNull(joiningDetailsRepository.getCountPerYear());

    }
}