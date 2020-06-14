package com.company.dnevnik.controllers;

import com.company.dnevnik.entities.Teacher;
import com.company.dnevnik.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @GetMapping(value = "/list")
    public String getTeacherList(Model model) {
        List<Teacher> teacherList = teacherService.getAllTeachers();
        model.addAttribute("teacherList", teacherList);
        model.addAttribute("bool", true);
        return "teacherList";
    }

    @GetMapping(value = "/{id}")
    public String teacherProfile(@PathVariable("id") Long id, Model model) {
        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("teacher", teacher);
        return "teacherDetail";
    }

    @PostMapping(value = "/create")
    public String addTeacher(@Valid @ModelAttribute("teacher") Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "redirect:/teacher/list";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        teacherService.deleteTeacherById(id);
        return "redirect:/teacher/list";
    }
}