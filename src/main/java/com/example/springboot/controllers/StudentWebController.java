package com.example.springboot.controllers;

import com.example.springboot.models.StudentFormData;
import com.example.springboot.repositories.student.Student;
import com.example.springboot.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityResult;
import java.util.List;

@Controller
@RequestMapping(path = "students")
public class StudentWebController {

    private final IStudentService studentService;

    @Autowired
    public StudentWebController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public String getStudents(
            Model model
    )
    {
        model.addAttribute("students", studentService.getStudents());
        return "student/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("formData", new StudentFormData());
        return "student/create";
    }

    @PostMapping("/create")
    public String doCreate(
            /*@Valid*/
            @ModelAttribute("formData") StudentFormData formData,
            BindingResult bindingResult,
            Model model
    )
    {
        if (bindingResult.hasErrors()) {
            return "student/create";
        }
        studentService.addNewStudent(formData.toStudent());
        return "redirect:/students";
    }


    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") Long id,
            Model model)
    {

        Student st = studentService.findStudent(id);
        model.addAttribute("formData", new StudentFormData(st));
        model.addAttribute("id", id);
        return "student/edit";
    }

    @PostMapping("/edit/{id}")
    public String doEdit(
            @PathVariable("id") Long id,
            /*@Valid*/
            @ModelAttribute("formData") StudentFormData formData,
            BindingResult bindingResult,
            Model model
    )
    {
        if (bindingResult.hasErrors()) {
            return "student/edit/" + id;
        }

        Student st = formData.toStudent();
        st.setId(id);

        studentService.updateStudent(st);
        return "redirect:/students";
    }
}
