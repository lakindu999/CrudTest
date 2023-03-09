package com.springbootacademy.project1.DTO.request;

import java.util.ArrayList;

public class StudentUpdateDTO {

    private int studentId;
    private String studentName;
    private String studentClass;
    private boolean activeStatus;

    public StudentUpdateDTO() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return "StudentUpdateDTO{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", activeStatus=" + activeStatus +
                '}';
    }
}
