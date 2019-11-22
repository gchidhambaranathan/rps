package com.chidha.rps.controller;


import com.chidha.rps.model.SearchStudentRequest;
import com.chidha.rps.model.SearchStudentResponse;
import com.chidha.rps.model.Student;
import com.chidha.rps.model.StudentRespone;
import com.chidha.rps.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
@CrossOrigin(origins = {"http://localhost:4200"})
public class StudentController {

    private Logger logger = LoggerFactory.getLogger(SchoolFeesDetailsController.class);

    @Autowired
    private StudentService studentService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<StudentRespone> createStudent(@RequestBody Student student){
        ResponseEntity<StudentRespone> responseEntity;
        try {
            StudentRespone studentRespone = studentService.createUser(student);
            responseEntity = new ResponseEntity<>(studentRespone, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error creating student",e);
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<StudentRespone> getStudent(@PathVariable long id) {
        ResponseEntity<StudentRespone> responseEntity;
        try {
            StudentRespone student = studentService.getStudent(id);
            responseEntity = new ResponseEntity<>(student, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error get student",e);
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<StudentRespone> updaterStudent(@PathVariable long id, @RequestBody Student student){
        ResponseEntity<StudentRespone> responseEntity;
        try {
            StudentRespone student1 = studentService.updateStudent(id,student);
            responseEntity = new ResponseEntity<>(student1, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error update student",e);
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity deleteStudent(@PathVariable long id){
        ResponseEntity<Student> responseEntity;
        try {
             studentService.deleteStudent(id);
            responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.error("Error delete student",e);
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


    @PostMapping
    @RequestMapping("/.search")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<SearchStudentResponse> searchStudent(@RequestBody SearchStudentRequest searchStudentRequest){
        ResponseEntity<SearchStudentResponse> responseEntity ;
        try {
            SearchStudentResponse students = studentService.searchStudent(searchStudentRequest);
            responseEntity = new ResponseEntity<>(students, HttpStatus.OK);
        }catch (Exception e){
            logger.error("Error search student",e);
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<List<StudentRespone>> getAllStudents() {
        ResponseEntity<List<StudentRespone>> responseEntity;
        try {
            List<StudentRespone> students = studentService.getAllStudents();
            responseEntity = new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error get all student",e);
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
