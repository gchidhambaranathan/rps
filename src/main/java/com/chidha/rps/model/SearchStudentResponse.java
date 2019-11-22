package com.chidha.rps.model;

import java.util.ArrayList;
import java.util.List;

public class SearchStudentResponse {

    List<StudentRespone> studentResponeList = new ArrayList<>();

    public List<StudentRespone> getStudentResponeList() {
        return studentResponeList;
    }

    public void setStudentResponeList(List<StudentRespone> studentResponeList) {
        this.studentResponeList = studentResponeList;
    }
}
