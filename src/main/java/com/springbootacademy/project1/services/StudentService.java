package com.springbootacademy.project1.services;

import com.springbootacademy.project1.DTO.StudentDTO;
import com.springbootacademy.project1.DTO.request.StudentUpdateDTO;

import java.util.List;

public interface StudentService {

    public String saveStudent(StudentDTO studentDTO);


    void updateStudent(StudentUpdateDTO studentUpdateDTO);

    StudentDTO getStudentById(int studentId);

    List<StudentDTO> getAllStudents();

    String deleteStudent(int studentId);
}
