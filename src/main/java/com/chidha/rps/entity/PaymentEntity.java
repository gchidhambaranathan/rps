package com.chidha.rps.entity;


import javax.persistence.*;

@Entity(name = "PAYMENT")
public class PaymentEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAYMENT_ID")
    private long id;


    @Column(name = "AMOUNT")
    private long amount;

    @Column(name = "TERM")
    private String term;


    @Column(name = "PAYMENT_DATE")
    private  String paymentDate;


    @JoinColumn(name = "STUDENT_ADMISSION_ID")
    private long studentId;

    public PaymentEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
}
