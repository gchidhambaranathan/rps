package com.chidha.rps.service;


import com.chidha.rps.data.PaymentRepository;
import com.chidha.rps.entity.PaymentEntity;
import com.chidha.rps.model.Payment;
import com.chidha.rps.model.Student;
import com.chidha.rps.model.StudentBalanceFee;
import com.chidha.rps.model.StudentDeclaredFee;
import com.chidha.rps.model.StudentPaidFee;
import com.chidha.rps.util.ModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private StudentService studentService;


    @Autowired
    private ModelUtils<PaymentEntity, Payment> modelUtils;



    public Payment payment(Payment payment) {
        PaymentEntity paymentEntity = modelUtils.convertToEntity(payment, PaymentEntity.class);
        paymentEntity = paymentRepository.save(paymentEntity);

        Student student = studentService.getStudent(paymentEntity.getStudentId());

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

         return  modelUtils.convertTDTO(paymentEntity, Payment.class);
    }
}
