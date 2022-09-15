package com.example.springboot.services.impl;

import com.example.springboot.repositories.student.Student;
import com.example.springboot.repositories.student.StudentRepository;
import com.example.springboot.services.IStudentService;
import com.example.springboot.utils.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents()
    {
        return studentRepository.findAll();
    }

    @Override
    public void addNewStudent(Student student) {
        Optional<Student> studentByMail = studentRepository.findStudentByEmail(student.getEmail());

        if(studentByMail.isPresent()){
            throw new IllegalStateException("This eMail is already taken");
        }

        studentRepository.save(student);
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        Optional<Student> studentById = studentRepository.findById(student.getId());

        if(studentById.isEmpty()){
            throw new IllegalStateException("Id not provided");
        }

        Student updateStudent = studentById.get();

        if(StringHelper.isValorized(student.getName()))
            updateStudent.setName(student.getName());

        if(StringHelper.isValorized(student.getEmail()))
            updateStudent.setEmail(student.getEmail());

        if(student.getDob() != null)
            updateStudent.setDob(student.getDob());

        studentRepository.save(updateStudent);
    }

    @Override
    @Transactional
    public void updateStudent(Long id, String name, String email) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User not founded"));

        if(StringHelper.isValorized(name))
            student.setName(name);

        if(StringHelper.isValorized(email))
            student.setEmail(email);

        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {

        Optional<Student> studentById = studentRepository.findById(id);

        if(studentById.isEmpty()){
            throw new IllegalStateException("User not founded");
        }

        studentRepository.deleteById(id);
    }

    @Override
    public Student findStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->new IllegalStateException("User not founded"));
    }
}
