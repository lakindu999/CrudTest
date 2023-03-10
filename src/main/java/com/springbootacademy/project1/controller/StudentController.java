package com.springbootacademy.project1.controller;

import com.springbootacademy.project1.DTO.StudentDTO;
import com.springbootacademy.project1.DTO.request.StudentUpdateDTO;
import com.springbootacademy.project1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")

public class StudentController {

    @Autowired
    private StudentService studentService;

    //Save Student
    @PostMapping("/save")
    public String saveStudent(@RequestBody StudentDTO studentDTO){
        studentService.saveStudent(studentDTO);
        return "Student Saved";
    }

    //Update Student
    @PutMapping("/update")
    public String updateStudent(@RequestBody StudentUpdateDTO studentUpdateDTO){
        studentService.updateStudent(studentUpdateDTO);
        return "Student Updated Successfully";

    }

    //Get Student Details bt ID
    @GetMapping(path = "/get-student-by-id", params = "id")
    public StudentDTO getStudentById(@RequestParam(value = "id") int studentId){
        return studentService.getStudentById(studentId);

    }

    //Get all Customers
    @GetMapping(path = "/get-all-students")
    public List<StudentDTO> getAllStudents(){
        List<StudentDTO> allStudents = studentService.getAllStudents();
        return allStudents;
    }

    //Delete Student
    @DeleteMapping(path = "/delete-by-id/{id}")
    public String deleteStudent(@PathVariable(value = "id") int studentId){
        String deleted = studentService.deleteStudent(studentId);
        return "Student Deleted";
    }



}
