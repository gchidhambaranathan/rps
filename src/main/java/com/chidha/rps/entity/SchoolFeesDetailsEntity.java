package com.chidha.rps.entity;


import javax.persistence.*;

@Entity(name = "SCHOOL_FEES")
public class SchoolFeesDetailsEntity {

    @Id
    @Column(name = "SECTION")
    private String section;

    @Column(name = "TERM1_FEEES")
    private long term1Fees;

    @Column(name = "TERM2_FEEES")
    private long term2Fees;

    @Column(name = "TERM3_FEEES")
    private long term3Fees;

    public SchoolFeesDetailsEntity() {
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
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
}
