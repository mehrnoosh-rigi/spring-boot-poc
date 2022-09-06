package com.example.springboot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public static void addNewStudent(Student student) {
        System.out.println(student);
    }

    public List<Student> GetStudent(){
        return studentRepository.findAll();
//                List.of(new Student(
//                1L,
//                "student 1",
//                "student.1@gmail.com",
//                LocalDate.of(2000, 01, 25),
//                22
//        ));
    }
}
