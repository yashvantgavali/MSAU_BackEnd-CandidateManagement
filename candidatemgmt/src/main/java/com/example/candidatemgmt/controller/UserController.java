package com.example.candidatemgmt.controller;

import com.example.candidatemgmt.bean.User;
import com.example.candidatemgmt.respository.UserRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/user")
public class UserController {

    Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRespository userRespository;

    @GetMapping("/test")
    public String test()
    {
        logger.trace("testing method invoked");
        return "testing";
    }

    @GetMapping()
    public List<User> getAllUsers()
    {
      logger.debug("GetAll user method incoked from UserController");
        return userRespository.getUser();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Integer id) {
        logger.debug("GetAll user method incoked from UserController");
        User user = userRespository.findById(id);
        if (user == null) {
            logger.error("User Not Found");
            return new ResponseEntity<String>("No User found with this "+ id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) throws SQLIntegrityConstraintViolationException {
        logger.debug("Create user method incoked from UserController");
        if (userRespository.findById(user.getId()) != null) {
            logger.error("Duplicate Entry");
            return new ResponseEntity<String>("Duplicate Entry "+ user.getId(), HttpStatus.IM_USED);
        }
        userRespository.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        logger.debug("Update user method incoked from UserController");
        if (userRespository.findById(user.getId()) == null) {
            logger.error("User not found");
            return new ResponseEntity<String>("Unable to update as  User id " + user.getId() + " not found.",
                    HttpStatus.NOT_FOUND);
        }

        userRespository.updateUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
        logger.debug("Delete user method incoked from UserController");
        User user =userRespository.findById(id);
        if (user == null) {
            logger.error("User not found");
            return new ResponseEntity<String>("Unable to delete as  User id " + id + " not found.", HttpStatus.NOT_FOUND);
        }
        userRespository.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
}
