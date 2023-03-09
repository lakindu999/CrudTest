package com.springbootacademy.project1.DTO;

import java.util.ArrayList;

public class StudentDTO {

    private int studentId;
    private String studentName;
    private String studentClass;
    private String subjectStream;
    private ArrayList subjects;
    private boolean activeStatus;

    public StudentDTO() {
    }

    public StudentDTO(int studentId, String studentName, String studentClass, String subjectStream, ArrayList subjects, boolean activeStatus) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.subjectStream = subjectStream;
        this.subjects = subjects;
        this.activeStatus = activeStatus;
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

    public String getSubjectStream() {
        return subjectStream;
    }

    public void setSubjectStream(String subjectStream) {
        this.subjectStream = subjectStream;
    }

    public ArrayList getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList subjects) {
        this.subjects = subjects;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", subjectStream='" + subjectStream + '\'' +
                ", subjects=" + subjects +
                ", activeStatus=" + activeStatus +
                '}';
    }
}



