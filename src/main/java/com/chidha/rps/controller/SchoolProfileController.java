package com.chidha.rps.controller;


import com.chidha.rps.model.SchoolProfile;
import com.chidha.rps.service.SchoolProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schoolprofile")
public class SchoolProfileController {

    @Autowired
    private SchoolProfileService schoolProfileService;

    @PutMapping("/{id}")
    public ResponseEntity<SchoolProfile> updateSchoolInfo(@RequestBody SchoolProfile schoolProfile, @PathVariable String id){
        ResponseEntity<SchoolProfile> responseEntity;
        try {
            SchoolProfile schoolProfile1 = schoolProfileService.updateSchoolInfo(schoolProfile, id);
            responseEntity =  new ResponseEntity<>(schoolProfile1, HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


    @GetMapping("/{id}")
    public ResponseEntity<SchoolProfile> getSchoolInfo(@PathVariable String id) {
        ResponseEntity<SchoolProfile> responseEntity;
        try {
            SchoolProfile schoolProfile1 = schoolProfileService.getSchoolInfo(id);
            responseEntity =  new ResponseEntity<>(schoolProfile1, HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
