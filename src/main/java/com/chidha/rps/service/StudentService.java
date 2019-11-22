package com.chidha.rps.service;


import com.chidha.rps.data.StudentEntityRepository;
import com.chidha.rps.entity.StudentAddressEntity;
import com.chidha.rps.entity.StudentBalanceFeeEntity;
import com.chidha.rps.entity.StudentDeclaredFeeEntity;
import com.chidha.rps.entity.StudentEntity;
import com.chidha.rps.entity.StudentPaidFeeEntity;
import com.chidha.rps.model.SchoolFeesDetails;
import com.chidha.rps.model.SearchStudentRequest;
import com.chidha.rps.model.SearchStudentResponse;
import com.chidha.rps.model.Student;
import com.chidha.rps.model.StudentRespone;
import com.chidha.rps.util.ModelUtils;
import com.chidha.rps.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {


    @Autowired
    private StudentEntityRepository studentRepository;

    @Autowired
    SchoolFeesDetailsService feesDetailsService;

    @Autowired
    private ModelUtils<StudentEntity, Student> modelUtils;

    @Autowired
    private ModelUtils<StudentEntity, StudentRespone> responeModelUtils;



    public StudentRespone createUser(Student student){
        StudentEntity studentEntity = modelUtils.convertToEntity(student, StudentEntity.class);

        StudentAddressEntity studentAddressEntity = new StudentAddressEntity();
        studentAddressEntity.setAddress(student.getStudentAddress().getAddress());
        studentAddressEntity.setPincode(student.getStudentAddress().getPincode());

        studentEntity.setStudentAddressEntity(studentAddressEntity);

        SchoolFeesDetails schoolFeesDetails = feesDetailsService.getSchoolFeesDetails(student.getStandard());
        StudentDeclaredFeeEntity studentDeclaredFeeEntity = new StudentDeclaredFeeEntity();

        studentDeclaredFeeEntity.setTerm1Fees(schoolFeesDetails.getTerm1Fees());
        studentDeclaredFeeEntity.setTerm2Fees(schoolFeesDetails.getTerm2Fees());
        studentDeclaredFeeEntity.setTerm3Fees(schoolFeesDetails.getTerm3Fees());
        studentDeclaredFeeEntity.setStudentEntity(studentEntity);
        studentEntity.setStudentDeclaredFeeEntity(studentDeclaredFeeEntity);


        StudentPaidFeeEntity studentPaidFeeEntity = new StudentPaidFeeEntity();
        studentPaidFeeEntity.setTerm1Fees(0L);
        studentPaidFeeEntity.setTerm2Fees(0L);
        studentPaidFeeEntity.setTerm3Fees(0L);
        studentPaidFeeEntity.setStudentEntity(studentEntity);
        studentEntity.setStudentPaidFeeEntity(studentPaidFeeEntity);

        StudentBalanceFeeEntity studentBalanceFeeEntity = new StudentBalanceFeeEntity();
        studentBalanceFeeEntity.setTerm1Fees(schoolFeesDetails.getTerm1Fees());
        studentBalanceFeeEntity.setTerm2Fees(schoolFeesDetails.getTerm2Fees());
        studentBalanceFeeEntity.setTerm3Fees(schoolFeesDetails.getTerm3Fees());
        studentBalanceFeeEntity.setStudentEntity(studentEntity);
        studentEntity.setStudentBalanceFeeEntity(studentBalanceFeeEntity);

        studentEntity= studentRepository.save(studentEntity);
        return responeModelUtils.convertTDTO(studentEntity, StudentRespone.class);
    }

    public StudentRespone getStudent(long id){
       StudentEntity studentEntity =  studentRepository.findById(id).get();
        return responeModelUtils.convertTDTO(studentEntity, StudentRespone.class);
    }

    public StudentRespone updateStudent(long id, Student student){
        student.setAdmissionNumber(id);

        StudentEntity studentEntity = Utils.convertAddressEntry(student, modelUtils);

        studentEntity= studentRepository.save(studentEntity);
        return responeModelUtils.convertTDTO(studentEntity, StudentRespone.class);
    }



    public void deleteStudent(long id){
        studentRepository.deleteById(id);
    }

    public SearchStudentResponse searchStudent(SearchStudentRequest searchStudentRequest) {
        SearchStudentResponse searchStudentResponse = new SearchStudentResponse();
        List<StudentRespone> studentRespones = new ArrayList<>();
        List<StudentEntity> studentEntities = null;
        if(searchStudentRequest.getAdmissionNumber() != 0 && searchStudentRequest.getStandard() != null) {
            studentEntities = studentRepository.findStudentEntitiesByAdmissionNumberAndStandard(searchStudentRequest.getAdmissionNumber(), searchStudentRequest.getStandard());
        }else if(searchStudentRequest.getAdmissionNumber() == 0 && searchStudentRequest.getStandard() != null){
            studentEntities = studentRepository.findStudentEntitiesByStandard(searchStudentRequest.getStandard());
        }
        if(studentEntities != null) {
            studentEntities.stream().forEach( studentEntity -> studentRespones.add(responeModelUtils.convertTDTO(studentEntity, StudentRespone.class)));
        }
        searchStudentResponse.setStudentResponeList(studentRespones);
        return searchStudentResponse;
    }

    public List<StudentRespone> getAllStudents(){
        List<StudentRespone> students = new ArrayList<>();
        studentRepository.findAll().iterator().forEachRemaining(studentEntity -> students.add(responeModelUtils.convertTDTO(studentEntity, StudentRespone.class)));
        return students;
    }

}
