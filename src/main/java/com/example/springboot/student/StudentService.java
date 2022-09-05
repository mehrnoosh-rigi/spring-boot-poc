package com.example.springboot.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    public List<Student> GetStudent(){
        return List.of(new Student(
                1L,
                "student 1",
                "student.1@gmail.com",
                LocalDate.of(2000, 01, 25),
                22
        ));
    }
}
