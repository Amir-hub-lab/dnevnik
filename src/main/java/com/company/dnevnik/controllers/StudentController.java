package com.company.dnevnik.controllers;

import com.company.dnevnik.entities.Student;
import com.company.dnevnik.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping(value = "/list")
    public String getStudentList(Model model) {
        List<Student> studentList = studentService.getAllStudents();
        model.addAttribute("studentList", studentList);
        model.addAttribute("bool", true);
        return "studentList";
    }

    @GetMapping(value = "/{id}")
    public String studentProfile(@PathVariable("id") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "studentDetail";
    }

    @PostMapping(value = "/create")
    public String addStudent(@Valid @ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/student/list";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/student/list";
    }
}