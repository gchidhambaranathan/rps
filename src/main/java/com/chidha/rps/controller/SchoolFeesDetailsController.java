package com.chidha.rps.controller;


import com.chidha.rps.model.SchoolFeesDetails;
import com.chidha.rps.service.SchoolFeesDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/schooldetails")
@CrossOrigin(origins = {"http://localhost:4200"})
public class SchoolFeesDetailsController {

    private Logger logger = LoggerFactory.getLogger(SchoolFeesDetailsController.class);

    @Autowired
    private SchoolFeesDetailsService schoolFeesDetailsService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<SchoolFeesDetails> createSchoolFeesDetails(@RequestBody  SchoolFeesDetails schoolFeesDetails) {
        ResponseEntity<SchoolFeesDetails> responseEntity;

        try {
            SchoolFeesDetails schoolFeesDetails1 = schoolFeesDetailsService.createSchoolFees(schoolFeesDetails);
            responseEntity = new ResponseEntity<>(schoolFeesDetails1, HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("Error creating schools ",e);
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<SchoolFeesDetails> updateSchoolFeesDetails(@RequestBody SchoolFeesDetails schoolFeesDetails, @PathVariable  String id){
        ResponseEntity<SchoolFeesDetails> responseEntity;

        try {
            SchoolFeesDetails schoolFeesDetails1 = schoolFeesDetailsService.updateSchoolDetails(schoolFeesDetails, id);
            responseEntity = new ResponseEntity<>(schoolFeesDetails1, HttpStatus.OK);
        }catch (Exception e){
            logger.error("Error updating schools ",e);
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<SchoolFeesDetails> getSchoolFeesDetails(@PathVariable String id){
        ResponseEntity<SchoolFeesDetails> responseEntity;

        try {
            SchoolFeesDetails schoolFeesDetails1 = schoolFeesDetailsService.getSchoolFeesDetails(id);
            responseEntity = new ResponseEntity<>(schoolFeesDetails1, HttpStatus.OK);
        }catch (Exception e){
            logger.error("Error getting schools ",e);
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping()
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<List<SchoolFeesDetails>> getSchoolFeesDetails(){
        ResponseEntity<List<SchoolFeesDetails>> responseEntity;

        try {
            List<SchoolFeesDetails> schoolFeesDetails1 = schoolFeesDetailsService.getAllSchoolFeeDetails();
            responseEntity = new ResponseEntity<>(schoolFeesDetails1, HttpStatus.OK);
        }catch (Exception e){
            logger.error("Error getting schools ",e);
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}
