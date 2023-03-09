package com.springbootacademy.project1.services.impl;

import com.springbootacademy.project1.DTO.StudentDTO;
import com.springbootacademy.project1.DTO.request.StudentUpdateDTO;
import com.springbootacademy.project1.entity.Student;
import com.springbootacademy.project1.repo.StudentRepo;
import com.springbootacademy.project1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceIMPL implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    //save student
    @Override
    public String saveStudent(StudentDTO studentDTO) {
        Student student = new Student(

                studentDTO.getStudentId(),
                studentDTO.getStudentName(),
                studentDTO.getStudentClass(),
                studentDTO.getSubjectStream(),
                studentDTO.getSubjects(),
                studentDTO.isActiveStatus()
        );

        studentRepo.save(student);

        return "Student Saved";
    }

    //update student
    @Override
    public void updateStudent(StudentUpdateDTO studentUpdateDTO) {
        if (studentRepo.existsById(studentUpdateDTO.getStudentId())){
            Student student = studentRepo.getReferenceById(studentUpdateDTO.getStudentId());

            student.setStudentName(studentUpdateDTO.getStudentName());
            student.setStudentClass(studentUpdateDTO.getStudentClass());

            studentRepo.save(student);

        }

        else {
            throw new RuntimeException("No Student Exist");
        }

    }

    // search student by ID
    @Override
    public StudentDTO getStudentById(int studentId) {
        if (studentRepo.existsById(studentId)){
            Student student = studentRepo.getReferenceById(studentId);

            StudentDTO studentDTO = new StudentDTO(
                    student.getStudentId(),
                    student.getStudentName(),
                    student.getStudentClass(),
                    student.getSubjectStream(),
                    student.getSubjects(),
                    student.isActiveStatus()
            );

            return studentDTO;
        }
        else{
            throw new RuntimeException("No Student Exist");
        }


    }

}

