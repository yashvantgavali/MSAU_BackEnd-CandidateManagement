package com.example.candidatemgmt.controller;

//import com.example.candidatemgmt.bean.User;
import com.example.candidatemgmt.bean.JoiningDetails;
import com.example.candidatemgmt.bean.Trends1;
import com.example.candidatemgmt.bean.Trends2;
import com.example.candidatemgmt.bean.Trends3;
import com.example.candidatemgmt.respository.JoiningDetailsRepository;
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
@RequestMapping("/joining")
public class JoiningDetailsController {

    Logger logger= LoggerFactory.getLogger(JoiningDetailsController.class);

    @Autowired
    JoiningDetailsRepository joiningDetailsRepository;

    @GetMapping("/test")
    public String test()
    {
        logger.trace("Test method Invoked");
        return "testing";
    }

    @GetMapping()
    public List<JoiningDetails> getAllJoiningDetails()
    {
        logger.debug("Get Joining Details method invoked from JoiningDetailsController");
        return joiningDetailsRepository.getJoiningDetails();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getJoiningDetails(@PathVariable("id") Integer id) {
        logger.debug("Get Joining Details by Id method invoked from JoiningDetailsController");
        JoiningDetails joiningDetails = joiningDetailsRepository.findById(id);
        if (joiningDetails == null) {
            logger.error("Joining Details Not Found");
            return new ResponseEntity<String>("No Joining details found with this "+ id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<JoiningDetails>(joiningDetails, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> createJoiningDetails(@RequestBody JoiningDetails joiningDetails) throws SQLIntegrityConstraintViolationException {
        logger.debug("Create Joining Details method invoked from JoiningDetailsController");
        if (joiningDetailsRepository.findById(joiningDetails.getId()) != null) {
            logger.error("Joining Details Not Found");
            return new ResponseEntity<String>("Duplicate Entry "+ joiningDetails.getId(), HttpStatus.IM_USED);
        }
        joiningDetailsRepository.saveJoiningDetails(joiningDetails);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    public ResponseEntity<?> updateJoiningDetails(@RequestBody JoiningDetails joiningDetails) {
        logger.debug("Update Joining Details method invoked from JoiningDetailsController");
        if (joiningDetailsRepository.findById(joiningDetails.getId()) == null) {
            logger.error("Joining Details Not Found");
            return new ResponseEntity<String>("Unable to update as  Joining id " + joiningDetails.getId() + " not found.",
                    HttpStatus.NOT_FOUND);
        }

        joiningDetailsRepository.updateJoiningDetails(joiningDetails);
        return new ResponseEntity<JoiningDetails>(joiningDetails, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteJoiningDetails(@PathVariable("id") Integer id) {
        logger.debug("Delete Joining Details method invoked from JoiningDetailsController");
        JoiningDetails joiningDetails =joiningDetailsRepository.findById(id);
        if (joiningDetails == null) {
            logger.error("Joining Details Not Found");
            return new ResponseEntity<String>("Unable to delete as  Joining Details id " + id + " not found.", HttpStatus.NOT_FOUND);
        }
        joiningDetailsRepository.deleteJoiningDetailsById(id);
        return new ResponseEntity<JoiningDetails>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/trends1")
    public List<Trends1> getCountPerYear()
    {
        logger.debug(" getCountPerYear method invoked from JoiningDetailsController");
        return joiningDetailsRepository.getCountPerYear();
    }

    @GetMapping("/trends2")
    public List<Trends2> getCountPerLocation()
    {
        logger.debug(" getCountPerLocation method invoked from JoiningDetailsController");
        return joiningDetailsRepository.getCountPerLocation();
    }

    @GetMapping("/trends3")
    public  List<Trends3> getCountPerTechnology()
    {
        logger.debug(" getCountPerTechnology method invoked from JoiningDetailsController");
        return joiningDetailsRepository.getCountPerTechnology();
    }
}
