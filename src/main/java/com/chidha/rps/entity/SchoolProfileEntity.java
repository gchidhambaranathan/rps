package com.chidha.rps.entity;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "SCHOOL_PROFILE")
public class SchoolProfileEntity {

    @Id
    @Column(name = "SCHOOL_ID")
    private String schoolId;

    @Column(name = "SCHOOL_REG_ID")
    private String schoolRegId;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Embedded
    @Column(name = "SCHOOL_ADDRESS")
    private SchoolAddressEntity schoolAddressEntity;

    public SchoolProfileEntity() {
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

    public SchoolAddressEntity getSchoolAddressEntity() {
        return schoolAddressEntity;
    }

    public void setSchoolAddressEntity(SchoolAddressEntity schoolAddressEntity) {
        this.schoolAddressEntity = schoolAddressEntity;
    }
}
