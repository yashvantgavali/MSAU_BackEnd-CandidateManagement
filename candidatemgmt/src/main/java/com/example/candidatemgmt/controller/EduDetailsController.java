package com.example.candidatemgmt.controller;

import com.example.candidatemgmt.bean.EduDetails;
import com.example.candidatemgmt.bean.Trends4;
import com.example.candidatemgmt.respository.EduDetailsRespository;
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
@RequestMapping("/edudetails")
public class EduDetailsController {
    Logger logger= LoggerFactory.getLogger(EduDetailsController.class);

    @Autowired
    EduDetailsRespository eduDetailsRespository;

    @GetMapping("/test")
    public String test()
    {
        logger.trace("Testing EduDetailsController");
        return "testing";
    }

    @GetMapping()
    public List<EduDetails> getAllEdudetails()
    {
        logger.debug("Get edudetails method invoked");
        return eduDetailsRespository.getEdudetails();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getEdudetails(@PathVariable("id") Integer id) {
        logger.debug("Get edudetails by Id method invoked");
        EduDetails eduDetails = eduDetailsRespository.findById(id);
        if (eduDetails == null) {
            logger.error("Edudetails not found");
            return new ResponseEntity<String>("No edudetails found with this "+ id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<EduDetails>( eduDetails, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> createEdudetails(@RequestBody EduDetails eduDetails) throws SQLIntegrityConstraintViolationException {
        logger.debug("create Edudetails method invoked");
        if (eduDetailsRespository.findById(eduDetails.getId()) != null) {
            logger.error("Duplicate Value");
            return new ResponseEntity<String>("Duplicate Entry "+ eduDetails.getId(), HttpStatus.IM_USED);
        }
        eduDetailsRespository.saveEdudetails(eduDetails);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    public ResponseEntity<?> updateEdudetails(@RequestBody EduDetails eduDetails) {
        logger.debug("Update Edudetails Method Invoked");
        if (eduDetailsRespository.findById(eduDetails.getId()) == null) {
            logger.error("Unable to Update");
            return new ResponseEntity<String>("Unable to update as  User id " + eduDetails.getId() + " not found.",
                    HttpStatus.NOT_FOUND);
        }

        eduDetailsRespository.updateEdudetails(eduDetails);
        return new ResponseEntity<EduDetails>(eduDetails, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteEdudetails(@PathVariable("id") Integer id) {
        logger.debug("Delete Edudetails Method Invoked");
        EduDetails eduDetails =eduDetailsRespository.findById(id);
        if (eduDetails == null) {
            logger.error("Unable to Delete");
            return new ResponseEntity<String>("Unable to delete as  User id " + id + " not found.", HttpStatus.NOT_FOUND);
        }
        eduDetailsRespository.deleteEdudetailsById(id);
        return new ResponseEntity<EduDetails>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/trends4")
    public List<Trends4> getCountPerCourse()
    {
        return eduDetailsRespository.getCountPerCourse();
    }
}
