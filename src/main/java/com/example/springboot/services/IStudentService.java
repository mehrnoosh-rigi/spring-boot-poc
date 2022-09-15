package com.example.springboot.services;

import com.example.springboot.repositories.student.Student;

import java.util.List;


public interface IStudentService {

    List<Student> getStudents();

    void addNewStudent(Student student);

    void updateStudent(Student student);
    void updateStudent(Long id, String name, String email);

    void deleteStudent(Long id);


    Student findStudent(Long id);
}
