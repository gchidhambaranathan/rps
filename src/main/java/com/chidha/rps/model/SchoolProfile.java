package com.chidha.rps.model;


public class SchoolProfile {

    private String schoolId;
    private String schoolRegId;
    private String email;
    private String phoneNumber;
    private SchoolAddress schoolAddress;

    public SchoolProfile() {
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolRegId() {
        return schoolRegId;
    }

    public void setSchoolRegId(String schoolRegId) {
        this.schoolRegId = schoolRegId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public SchoolAddress getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(SchoolAddress schoolAddress) {
        this.schoolAddress = schoolAddress;
    }
}
