package com.chidha.rps.controller;


import com.chidha.rps.model.StudentFeeDetailResponse;
import com.chidha.rps.service.StudentFeeDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studentfeedtails")
@CrossOrigin(origins = {"http://localhost:4200"})
public class StudentFeeDetailsController {
    private Logger logger = LoggerFactory.getLogger(SchoolFeesDetailsController.class);

    @Autowired
    private StudentFeeDetailService studentFeeDetailService;


    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<StudentFeeDetailResponse> getStudentFeesDetails(@PathVariable  long id) {
        ResponseEntity<StudentFeeDetailResponse> responseEntity = null;

        try {
            StudentFeeDetailResponse studentFeeDetailResponse = studentFeeDetailService.getStudentFeeDetailResponse(id);
            responseEntity = new ResponseEntity<>(studentFeeDetailResponse, HttpStatus.OK);
        }catch (Exception e){
            logger.error("Error getting student fee details ",e);
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }
}
