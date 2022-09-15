package com.example.springboot.models;

import com.example.springboot.repositories.student.Student;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class StudentFormData {
    //@NotNull
    //@Size(min = 1, max = 400)

    private String name;
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    public Student toStudent() {
        return new Student(name, email, dob);
    }

    public StudentFormData() {

    }

    public StudentFormData(Student st) {
        name = st.getName();
        email = st.getEmail();
        dob = st.getDob();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
