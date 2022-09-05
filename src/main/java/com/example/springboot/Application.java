package com.example.springboot;

import com.example.springboot.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping
	public List<Student> Hello(){
		return List.of(new Student(
				1L,
				"student 1",
				"student.1@gmail.com",
				LocalDate.of(2000, 01, 25),
				22
		));
	}
}
