package com.chidha.rps.controller;


import com.chidha.rps.model.SchoolProfile;
import com.chidha.rps.service.SchoolProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schoolprofile")
@CrossOrigin(origins = "*")
public class SchoolProfileController {
    private Logger logger = LoggerFactory.getLogger(SchoolProfileController.class);

    @Autowired
    private SchoolProfileService schoolProfileService;

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<SchoolProfile> updateSchoolInfo(@RequestBody SchoolProfile schoolProfile, @PathVariable String id){
        ResponseEntity<SchoolProfile> responseEntity;
        try {
            SchoolProfile schoolProfile1 = schoolProfileService.updateSchoolInfo(schoolProfile, id);
            responseEntity =  new ResponseEntity<>(schoolProfile1, HttpStatus.OK);
        }catch (Exception e){
            logger.error("Error updating schools ",e);
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<SchoolProfile> getSchoolInfo(@PathVariable String id) {
        ResponseEntity<SchoolProfile> responseEntity;
        try {
            SchoolProfile schoolProfile1 = schoolProfileService.getSchoolInfo(id);
            responseEntity =  new ResponseEntity<>(schoolProfile1, HttpStatus.OK);
        }catch (Exception e){
            logger.error("Error get schools ",e);
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
