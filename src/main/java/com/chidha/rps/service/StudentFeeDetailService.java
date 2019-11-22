package com.chidha.rps.service;


import com.chidha.rps.data.StudentEntityRepository;
import com.chidha.rps.entity.StudentAddressEntity;
import com.chidha.rps.entity.StudentEntity;
import com.chidha.rps.model.Student;
import com.chidha.rps.model.StudentBalanceFee;
import com.chidha.rps.model.StudentDeclaredFee;
import com.chidha.rps.model.StudentFeeDetailResponse;
import com.chidha.rps.model.StudentPaidFee;
import com.chidha.rps.util.ModelUtils;
import com.chidha.rps.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentFeeDetailService {

    @Autowired
    private StudentEntityRepository studentEntityRepository;


    @Autowired
    private ModelUtils<StudentEntity, Student> modelUtils;



    public StudentFeeDetailResponse getStudentFeeDetailResponse(long admissionId) {
        StudentEntity student =  studentEntityRepository.findById(admissionId).get();


        StudentFeeDetailResponse studentFeeDetailResponse = new StudentFeeDetailResponse();
        studentFeeDetailResponse.setAdmissionNumber(student.getAdmissionNumber());
        studentFeeDetailResponse.setName(student.getName());
        studentFeeDetailResponse.setStandard(student.getStandard());

        StudentDeclaredFee studentDeclaredFee = new StudentDeclaredFee();
        studentDeclaredFee.setTerm1Fees(student.getStudentDeclaredFeeEntity().getTerm1Fees());
        studentDeclaredFee.setTerm2Fees(student.getStudentDeclaredFeeEntity().getTerm2Fees());
        studentDeclaredFee.setTerm3Fees(student.getStudentDeclaredFeeEntity().getTerm3Fees());


        StudentPaidFee studentPaidFee = new StudentPaidFee();
        studentPaidFee.setTerm1Fees(student.getStudentPaidFeeEntity().getTerm1Fees());
        studentPaidFee.setTerm2Fees(student.getStudentPaidFeeEntity().getTerm2Fees());
        studentPaidFee.setTerm3Fees(student.getStudentPaidFeeEntity().getTerm3Fees());

        StudentBalanceFee studentBalanceFee = new StudentBalanceFee();
        studentBalanceFee.setTerm1Fees(student.getStudentBalanceFeeEntity().getTerm1Fees());
        studentBalanceFee.setTerm2Fees(student.getStudentBalanceFeeEntity().getTerm2Fees());
        studentBalanceFee.setTerm3Fees(student.getStudentBalanceFeeEntity().getTerm3Fees());


        studentFeeDetailResponse.setStudentDeclaredFee(studentDeclaredFee);
        studentFeeDetailResponse.setStudentPaidFee(studentPaidFee);
        studentFeeDetailResponse.setStudentBalanceFee(studentBalanceFee);


        studentFeeDetailResponse.setTotalBalance(studentBalanceFee.getTerm1Fees() + studentBalanceFee.getTerm2Fees() + studentBalanceFee.getTerm3Fees());
        return studentFeeDetailResponse;
    }

    public void updateStudenFeeDetails(long admissionId, Student student) {
        StudentEntity studentEntity = studentEntityRepository.findById(admissionId).get();
        studentEntity.setAdmissionNumber(admissionId);

        studentEntity.getStudentDeclaredFeeEntity().setTerm1Fees(student.getStudentDeclaredFee().getTerm1Fees());
        studentEntity.getStudentDeclaredFeeEntity().setTerm2Fees(student.getStudentDeclaredFee().getTerm2Fees());
        studentEntity.getStudentDeclaredFeeEntity().setTerm3Fees(student.getStudentDeclaredFee().getTerm3Fees());

        studentEntity.getStudentPaidFeeEntity().setTerm1Fees(student.getStudentPaidFee().getTerm1Fees());
        studentEntity.getStudentPaidFeeEntity().setTerm2Fees(student.getStudentPaidFee().getTerm2Fees());
        studentEntity.getStudentPaidFeeEntity().setTerm3Fees(student.getStudentPaidFee().getTerm3Fees());

        studentEntity.getStudentBalanceFeeEntity().setTerm1Fees(student.getStudentBalanceFee().getTerm1Fees());
        studentEntity.getStudentBalanceFeeEntity().setTerm2Fees(student.getStudentBalanceFee().getTerm2Fees());
        studentEntity.getStudentBalanceFeeEntity().setTerm3Fees(student.getStudentBalanceFee().getTerm3Fees());


        studentEntityRepository.save(studentEntity);
    }

}
