package com.chidha.rps.service;


import com.chidha.rps.data.StudentEntityRepository;
import com.chidha.rps.entity.SchoolFeesDetailsEntity;
import com.chidha.rps.entity.StudentBalanceFeeEntity;
import com.chidha.rps.entity.StudentDeclaredFeeEntity;
import com.chidha.rps.entity.StudentEntity;
import com.chidha.rps.entity.StudentPaidFeeEntity;
import com.chidha.rps.model.SchoolFeesDetails;
import com.chidha.rps.model.SearchStudentRequest;
import com.chidha.rps.model.Student;
import com.chidha.rps.model.StudentBalanceFee;
import com.chidha.rps.model.StudentDeclaredFee;
import com.chidha.rps.model.StudentPaidFee;
import com.chidha.rps.util.ModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    private StudentEntityRepository studentRepository;

    @Autowired
    SchoolFeesDetailsService feesDetailsService;

    @Autowired
    private ModelUtils<StudentEntity, Student> modelUtils;



    public Student createUser(Student student){
        StudentEntity studentEntity = modelUtils.convertToEntity(student, StudentEntity.class);
        SchoolFeesDetails schoolFeesDetails = feesDetailsService.getSchoolFeesDetails(student.getStandard());
        StudentDeclaredFeeEntity studentDeclaredFeeEntity = new StudentDeclaredFeeEntity();

        studentDeclaredFeeEntity.setTerm1Fees(schoolFeesDetails.getTerm1Fees());
        studentDeclaredFeeEntity.setTerm2Fees(schoolFeesDetails.getTerm2Fees());
        studentDeclaredFeeEntity.setTerm3Fees(schoolFeesDetails.getTerm3Fees());
        studentEntity.setStudentDeclaredFeeEntity(studentDeclaredFeeEntity);

        StudentPaidFeeEntity studentPaidFeeEntity = new StudentPaidFeeEntity();
        studentPaidFeeEntity.setTerm1Fees(0L);
        studentPaidFeeEntity.setTerm2Fees(0L);
        studentPaidFeeEntity.setTerm3Fees(0L);
        studentEntity.setStudentPaidFeeEntity(studentPaidFeeEntity);

        StudentBalanceFeeEntity studentBalanceFeeEntity = new StudentBalanceFeeEntity();
        studentBalanceFeeEntity.setTerm1Fees(0L);
        studentBalanceFeeEntity.setTerm2Fees(0L);
        studentBalanceFeeEntity.setTerm3Fees(0L);
        studentEntity.setStudentBalanceFeeEntity(studentBalanceFeeEntity);

        studentEntity= studentRepository.save(studentEntity);
        return modelUtils.convertTDTO(studentEntity, Student.class);
    }

    public Student getStudent(long id){
       StudentEntity studentEntity =  studentRepository.findById(id).get();
       return modelUtils.convertTDTO(studentEntity, Student.class);
    }

    public Student updateStudent(long id, Student student){
        student.setAdmissionNumber(id);
        StudentEntity studentEntity = modelUtils.convertToEntity(student, StudentEntity.class);
        studentEntity= studentRepository.save(studentEntity);
        return modelUtils.convertTDTO(studentEntity, Student.class);
    }

    public void deleteStudent(long id){
        studentRepository.deleteById(id);
    }

    public Student searchStudent(SearchStudentRequest searchStudentRequest) {

        StudentEntity studentEntity = studentRepository.findStudentEntitiesByAdmissionNumberAndStandard(searchStudentRequest.getAdmissionNumner(), searchStudentRequest.getStandard()).get(0);
        return modelUtils.convertTDTO(studentEntity, Student.class);
    }

}
