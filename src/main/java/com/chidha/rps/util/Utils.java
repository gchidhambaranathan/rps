package com.chidha.rps.util;

import com.chidha.rps.entity.StudentAddressEntity;
import com.chidha.rps.entity.StudentEntity;
import com.chidha.rps.model.Student;

public class Utils {


    public static StudentEntity convertAddressEntry(Student student, ModelUtils<StudentEntity, Student> modelUtils) {
        StudentEntity studentEntity = modelUtils.convertToEntity(student, StudentEntity.class);
        if(studentEntity.getStudentAddressEntity() == null) {
            StudentAddressEntity studentAddressEntity = new StudentAddressEntity();
            studentAddressEntity.setAddress(student.getStudentAddress().getAddress());
            studentAddressEntity.setPincode(student.getStudentAddress().getPincode());
            studentEntity.setStudentAddressEntity(studentAddressEntity);
        }else {
            studentEntity.getStudentAddressEntity().setAddress(student.getStudentAddress().getAddress());
            studentEntity.getStudentAddressEntity().setPincode(student.getStudentAddress().getPincode());
        }
        return studentEntity;
    }
}
