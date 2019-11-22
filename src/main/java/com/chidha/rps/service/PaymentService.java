package com.chidha.rps.service;


import com.chidha.rps.data.PaymentRepository;
import com.chidha.rps.data.StudentEntityRepository;
import com.chidha.rps.entity.PaymentEntity;
import com.chidha.rps.entity.StudentEntity;
import com.chidha.rps.model.Payment;
import com.chidha.rps.model.PaymentResponse;
import com.chidha.rps.model.Student;
import com.chidha.rps.model.StudentBalanceFee;
import com.chidha.rps.model.StudentDeclaredFee;
import com.chidha.rps.model.StudentPaidFee;
import com.chidha.rps.util.ModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private StudentEntityRepository studentEntityRepository;


    @Autowired
    private ModelUtils<PaymentEntity, Payment> modelUtils;

    @Autowired
    private ModelUtils<PaymentEntity, PaymentResponse> paymentModelUtils;

    @Autowired
    private ModelUtils<StudentEntity, Student> studentModelUtils;

    @Autowired
    private StudentFeeDetailService studentFeeDetailService;



    public PaymentResponse payment(Payment payment) {
        payment.setPaymentDate(new Date().toString());
        PaymentEntity paymentEntity = modelUtils.convertToEntity(payment, PaymentEntity.class);
        paymentEntity = paymentRepository.save(paymentEntity);

        StudentEntity studentEntity = studentEntityRepository.findById(paymentEntity.getStudentId()).get();
        Student student = studentModelUtils.convertTDTO(studentEntity,Student.class);

        StudentPaidFee studentPaidFee = student.getStudentPaidFee();
        StudentBalanceFee studentBalanceFee = student.getStudentBalanceFee();
        StudentDeclaredFee studentDeclaredFee = student.getStudentDeclaredFee();

        if(payment.getTerm().equals("term1")) {
            long paidFee = studentPaidFee.getTerm1Fees();
            paidFee += payment.getAmount();
            studentPaidFee.setTerm1Fees(paidFee);
            long totalDeclaredFee = studentDeclaredFee.getTerm1Fees();
            long balanceFee = totalDeclaredFee - paidFee;
            studentBalanceFee.setTerm1Fees(balanceFee);
        }else if(payment.getTerm().equals("term2")) {
            long paidFee = studentPaidFee.getTerm2Fees();
            paidFee += payment.getAmount();
            studentPaidFee.setTerm2Fees(paidFee);
            long totalDeclaredFee = studentDeclaredFee.getTerm2Fees();
            long balanceFee = totalDeclaredFee - paidFee;
            studentBalanceFee.setTerm2Fees(balanceFee);
        }else if(payment.getTerm().equals("term3")) {
            long paidFee = studentPaidFee.getTerm3Fees();
            paidFee += payment.getAmount();
            studentPaidFee.setTerm3Fees(paidFee);
            long totalDeclaredFee = studentDeclaredFee.getTerm3Fees();
            long balanceFee = totalDeclaredFee - paidFee;
            studentBalanceFee.setTerm3Fees(balanceFee);
        }

        studentFeeDetailService.updateStudenFeeDetails(payment.getStudentId(), student);
         PaymentResponse paymentResponse =  paymentModelUtils.convertTDTO(paymentEntity, PaymentResponse.class);
         paymentResponse.setStudentName(student.getName());
         paymentResponse.setStudentStandard(student.getStandard());
         paymentResponse.setStudentSection(student.getSection());

         return paymentResponse;
    }
}
