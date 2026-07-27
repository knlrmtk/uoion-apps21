package com.uoion.controller;

import com.uoion.entity.Student;
import com.uoion.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("student", new Student());
        return "index";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(Student student) {
        repository.save(student);
        return "redirect:/";
    }

    @GetMapping("/students")
    public String viewStudents(Model model) {
        model.addAttribute("students", repository.findAll());
        return "students";
    }
}
