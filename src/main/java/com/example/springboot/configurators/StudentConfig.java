package com.example.springboot.configurators;


import com.example.springboot.repositories.student.Student;
import com.example.springboot.repositories.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return  args -> {
            // creates only first time
            if(repository.count() == 0) {

                Student student1 = new Student("Davide", "std1@gmail.com", LocalDate.of(2001, 01, 03));
                Student student2 = new Student("Chiara", "std2@gmail.com", LocalDate.of(2003, 10, 17));

                repository.saveAll(
                        List.of(student1, student2)
                );
            }
        };
    }

}
