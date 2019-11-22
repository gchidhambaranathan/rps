package com.chidha.rps.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentFeeDetailResponse {

    private long admissionNumber;
    private String name;
    private String standard;

    private StudentDeclaredFee studentDeclaredFee;
    private StudentPaidFee studentPaidFee;
    private StudentBalanceFee studentBalanceFee;

    private long totalBalance;

    public StudentFeeDetailResponse(){

    }

    public long getAdmissionNumber() {
        return admissionNumber;
    }

    public void setAdmissionNumber(long admissionNumber) {
        this.admissionNumber = admissionNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public StudentDeclaredFee getStudentDeclaredFee() {
        return studentDeclaredFee;
    }

    public void setStudentDeclaredFee(StudentDeclaredFee studentDeclaredFee) {
        this.studentDeclaredFee = studentDeclaredFee;
    }

    public StudentPaidFee getStudentPaidFee() {
        return studentPaidFee;
    }

    public void setStudentPaidFee(StudentPaidFee studentPaidFee) {
        this.studentPaidFee = studentPaidFee;
    }

    public StudentBalanceFee getStudentBalanceFee() {
        return studentBalanceFee;
    }

    public void setStudentBalanceFee(StudentBalanceFee studentBalanceFee) {
        this.studentBalanceFee = studentBalanceFee;
    }

    public long getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(long totalBalance) {
        this.totalBalance = totalBalance;
    }
}
