package com.chidha.rps.model;

public class SearchStudentRequest {
    private long admissionNumber;
    private String standard;

    public SearchStudentRequest() {
    }

    public long getAdmissionNumber() {
        return admissionNumber;
    }

    public void setAdmissionNumber(long admissionNumber) {
        this.admissionNumber = admissionNumber;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }
}
