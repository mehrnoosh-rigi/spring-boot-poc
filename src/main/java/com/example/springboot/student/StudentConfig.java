package com.example.springboot.student;
import java.time.LocalDate;
import java.util.List;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student s1 =  new Student(
                "student 1",
                "student.1@gmail.com",
                LocalDate.of(2000, 01, 25),
                22
        );
            Student s2 =  new Student(
                    "student 2",
                    "student.2@gmail.com",
                    LocalDate.of(2000, 01, 25),
                    22
            );
            studentRepository.saveAll(List.of(s1, s2));
        };
    }
}
