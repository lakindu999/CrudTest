package com.springbootacademy.project1.entity;


import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Table(name = "Student")
@Entity
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Student_Id", length = 40)
    private int studentId;

    @Column(name = "Student_Name", length = 100, nullable = false)
    private String studentName;

    @Column(name = "Student_class", length = 10)
    private String studentClass;

    @Column(name = "Subject_Stream", length = 10)
    private String subjectStream;

    @Type(type = "json")
    @Column(name = "Subjects", columnDefinition = "json")
    private ArrayList subjects;

    @Column(name = "active_status", columnDefinition = "TINYINT default 1")
    private boolean activeStatus;

    @OneToMany(mappedBy = "student")
    private Set<Checkout> checkouts;


    public Student() {

    }

    public Student(int studentId, String studentName, String studentClass, String subjectStream, ArrayList subjects, boolean activeStatus) {
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
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", subjectStream='" + subjectStream + '\'' +
                ", subjects=" + subjects +
                ", activeStatus=" + activeStatus +
                '}';
    }
}
