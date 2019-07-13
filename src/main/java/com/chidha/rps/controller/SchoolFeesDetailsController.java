package com.chidha.rps.controller;


import com.chidha.rps.model.SchoolFeesDetails;
import com.chidha.rps.service.SchoolFeesDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schooldetails")
public class SchoolFeesDetailsController {

    @Autowired
    private SchoolFeesDetailsService schoolFeesDetailsService;

    @PostMapping
    public ResponseEntity<SchoolFeesDetails> createSchoolFeesDetails(@RequestBody  SchoolFeesDetails schoolFeesDetails) {
        ResponseEntity<SchoolFeesDetails> responseEntity;

        try {
            SchoolFeesDetails schoolFeesDetails1 = schoolFeesDetailsService.createSchoolFees(schoolFeesDetails);
            responseEntity = new ResponseEntity<>(schoolFeesDetails1, HttpStatus.CREATED);
        }catch (Exception e){
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping("/{id}")
    public ResponseEntity<SchoolFeesDetails> updateSchoolFeesDetails(@RequestBody SchoolFeesDetails schoolFeesDetails, @PathVariable  String id){
        ResponseEntity<SchoolFeesDetails> responseEntity;

        try {
            SchoolFeesDetails schoolFeesDetails1 = schoolFeesDetailsService.updateSchoolDetails(schoolFeesDetails, id);
            responseEntity = new ResponseEntity<>(schoolFeesDetails1, HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolFeesDetails> getSchoolFeesDetails(String id){
        ResponseEntity<SchoolFeesDetails> responseEntity;

        try {
            SchoolFeesDetails schoolFeesDetails1 = schoolFeesDetailsService.getSchoolFeesDetails(id);
            responseEntity = new ResponseEntity<>(schoolFeesDetails1, HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}
