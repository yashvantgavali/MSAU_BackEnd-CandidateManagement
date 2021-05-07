package com.example.candidatemgmt.respository;

import com.example.candidatemgmt.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRespositoryTest {

    @Autowired
    UserRespository userRespository;

    @Test
    void getUser() {
        int expected=userRespository.getUser().size();
        assertEquals(expected,userRespository.getUser().size());
    }

    @Test
    void findById() {
        int id=2;
        assertEquals(id,userRespository.findById(id).getId());
    }

    @Test
    void saveUser() {
        int id=100;
        String firstname="Yash";
        String lastname="Gavali";
        String email="yash@gmail.com";
        String phoneno="9561685514";

        User user=new User();
        user.setId(id);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setPhoneno(phoneno);

       Boolean response= userRespository.saveUser(user);

       User savedUser=userRespository.findById(id);

       assertEquals(id,savedUser.getId());
       assertEquals(firstname,savedUser.getFirstname());
       assertEquals(lastname,savedUser.getLastname());
       assertEquals(email,savedUser.getEmail());
       assertEquals(phoneno,savedUser.getPhoneno());
    }

    @Test
    void updateUser() {
        User user=userRespository.getUser().get(0);
        int id=user.getId();
        String firstname="Updatedvalue";
        user.setFirstname(firstname);
        userRespository.updateUser(user);
        assertEquals(id,userRespository.findById(id).getId());
        assertEquals(firstname,userRespository.findById(id).getFirstname());
    }

    @Test
    void deleteUserById() {
        int id=100;
        assertNotNull(userRespository.deleteUserById(id));
    }
}