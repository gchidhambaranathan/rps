package com.chidha.rps.entity;


import com.chidha.rps.enums.String;

import javax.persistence.*;

@Entity(name = "STUDENT")
public class StudentEntity {

    @Id
    @Column(name = "ADMISSION_NUMBER")
    private long admissionNumber;


    @Column(name = "NAME")
    private java.lang.String name;

    @Column(name = "FATHER_NAME")
    private java.lang.String fatherName;

    @Column(name = "MOTHER_NAME")
    private java.lang.String motherName;

    @Column(name = "GUARDIAN_NAME")
    private java.lang.String guardianName;

    @Column(name = "CONTACT_NUMBER")
    private java.lang.String contactNumber;

    @Column(name = "ADDRESS")
    @Embedded
    private StudentAddressEntity studentAddressEntity;

    @Column(name = "ADMISSION_YEAR")
    private java.lang.String admissionYear;

    @Column(name = "DOB")
    private java.lang.String dateOfBirth;


    @Column(name = "STANDARD")
    private String standard;


    @Column(name = "SECTION")
    private java.lang.String section;


    @OneToOne(mappedBy = "studentEntity", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private StudentDeclaredFeeEntity studentDeclaredFeeEntity;


    @OneToOne(mappedBy = "studentEntity", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private StudentPaidFeeEntity studentPaidFeeEntity;

    @OneToOne(mappedBy = "studentEntity", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private StudentBalanceFeeEntity studentBalanceFeeEntity;




    public StudentEntity() {
    }

    public long getAdmissionNumber() {
        return admissionNumber;
    }

    public void setAdmissionNumber(long admissionNumber) {
        this.admissionNumber = admissionNumber;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getFatherName() {
        return fatherName;
    }

    public void setFatherName(java.lang.String fatherName) {
        this.fatherName = fatherName;
    }

    public java.lang.String getMotherName() {
        return motherName;
    }

    public void setMotherName(java.lang.String motherName) {
        this.motherName = motherName;
    }

    public java.lang.String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(java.lang.String guardianName) {
        this.guardianName = guardianName;
    }

    public java.lang.String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(java.lang.String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public StudentAddressEntity getStudentAddressEntity() {
        return studentAddressEntity;
    }

    public void setStudentAddressEntity(StudentAddressEntity studentAddressEntity) {
        this.studentAddressEntity = studentAddressEntity;
    }

    public java.lang.String getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(java.lang.String admissionYear) {
        this.admissionYear = admissionYear;
    }

    public java.lang.String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(java.lang.String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public java.lang.String getSection() {
        return section;
    }

    public void setSection(java.lang.String section) {
        this.section = section;
    }

    public StudentDeclaredFeeEntity getStudentDeclaredFeeEntity() {
        return studentDeclaredFeeEntity;
    }

    public void setStudentDeclaredFeeEntity(StudentDeclaredFeeEntity studentDeclaredFeeEntity) {
        this.studentDeclaredFeeEntity = studentDeclaredFeeEntity;
    }

    public StudentPaidFeeEntity getStudentPaidFeeEntity() {
        return studentPaidFeeEntity;
    }

    public void setStudentPaidFeeEntity(StudentPaidFeeEntity studentPaidFeeEntity) {
        this.studentPaidFeeEntity = studentPaidFeeEntity;
    }

    public StudentBalanceFeeEntity getStudentBalanceFeeEntity() {
        return studentBalanceFeeEntity;
    }

    public void setStudentBalanceFeeEntity(StudentBalanceFeeEntity studentBalanceFeeEntity) {
        this.studentBalanceFeeEntity = studentBalanceFeeEntity;
    }
}
