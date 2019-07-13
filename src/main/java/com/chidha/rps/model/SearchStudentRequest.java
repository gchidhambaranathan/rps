package com.chidha.rps.model;

public class SearchStudentRequest {
    private long admissionNumner;
    private String standard;

    public SearchStudentRequest() {
    }

    public long getAdmissionNumner() {
        return admissionNumner;
    }

    public void setAdmissionNumner(long admissionNumner) {
        this.admissionNumner = admissionNumner;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }
}
