package com.chidha.rps.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentBalanceFee {
    private long id;
    private long term1Fees;
    private long term2Fees;
    private long term3Fees;

    private Student student;

    public StudentBalanceFee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTerm1Fees() {
        return term1Fees;
    }

    public void setTerm1Fees(long term1Fees) {
        this.term1Fees = term1Fees;
    }

    public long getTerm2Fees() {
        return term2Fees;
    }

    public void setTerm2Fees(long term2Fees) {
        this.term2Fees = term2Fees;
    }

    public long getTerm3Fees() {
        return term3Fees;
    }

    public void setTerm3Fees(long term3Fees) {
        this.term3Fees = term3Fees;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
