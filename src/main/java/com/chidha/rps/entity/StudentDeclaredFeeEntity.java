package com.chidha.rps.entity;

import javax.persistence.*;


@Entity(name = "STUDENT_DECLARED_FEE")
public class StudentDeclaredFeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DECLARE_FEE_ID")
    private long decFeeId;

    @Column(name = "TERM1_FEES")
    private long term1Fees;

    @Column(name = "TERM2_FEES")
    private long term2Fees;

    @Column(name = "TERM3_FEES")
    private long term3Fees;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ADMISSION_ID")
    private StudentEntity studentEntity;

    public StudentDeclaredFeeEntity() {
    }

    public long getDecFeeId() {
        return decFeeId;
    }

    public void setDecFeeId(long decFeeId) {
        this.decFeeId = decFeeId;
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

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }
}
