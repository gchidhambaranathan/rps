package com.chidha.rps.controller;


import com.chidha.rps.model.SearchStudentRequest;
import com.chidha.rps.model.Student;
import com.chidha.rps.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        ResponseEntity<Student> responseEntity;
        try {
            Student student1 = studentService.createUser(student);
            responseEntity = new ResponseEntity<>(student1, HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id) {
        ResponseEntity<Student> responseEntity;
        try {
            Student student = studentService.getStudent(id);
            responseEntity = new ResponseEntity<>(student, HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updaterStudent(@PathVariable long id, @RequestBody Student student){
        ResponseEntity<Student> responseEntity;
        try {
            Student student1 = studentService.updateStudent(id,student);
            responseEntity = new ResponseEntity<>(student1, HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable long id){
        ResponseEntity<Student> responseEntity;
        try {
             studentService.deleteStudent(id);
            responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


    @PostMapping
    @RequestMapping("/.search")
    public ResponseEntity<Student> searchStudent(@RequestBody SearchStudentRequest searchStudentRequest){
        ResponseEntity<Student> responseEntity ;
        try {
            Student student = studentService.searchStudent(searchStudentRequest);
            responseEntity = new ResponseEntity<>(student, HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
