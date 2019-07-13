package com.chidha.rps.model;




public class Student {

    private long admissionNumber;
    private String name;
    private String fatherName;
    private String motherName;
    private String guardianName;
    private String contactNumber;
    private StudentAddress studentAddress;
    private String admissionYear;
    private String dateOfBirth;
    private String standard;
    private String section;
    private StudentDeclaredFee studentDeclaredFee;
    private StudentPaidFee studentPaidFee;
    private StudentBalanceFee studentBalanceFee;

    public Student() {
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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public StudentAddress getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(StudentAddress studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(String admissionYear) {
        this.admissionYear = admissionYear;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
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
}
