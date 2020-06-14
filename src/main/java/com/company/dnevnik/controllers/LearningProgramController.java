package com.company.dnevnik.controllers;

import com.company.dnevnik.entities.LearningProgram;
import com.company.dnevnik.services.LearningProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/learningProgram")
public class LearningProgramController {
    @Autowired
    LearningProgramService learningProgramService;

    @GetMapping(value = "/list")
    public String getLearningProgramList(Model model) {
        List<LearningProgram> learningProgramList = learningProgramService.getAllLearningPrograms();
        model.addAttribute("learningProgramList", learningProgramList);
        model.addAttribute("bool", true);
        return "learningProgramList";
    }

    @GetMapping(value = "/{id}")
    public String learningProgramProfile(@PathVariable("id") Long id, Model model) {
        LearningProgram learningProgram = learningProgramService.getLearningProgramById(id);
        model.addAttribute("learningProgram", learningProgram);
        return "learningProgramDetail";
    }

    @PostMapping(value = "/create")
    public String addLearningProgram(@Valid @ModelAttribute("learningProgram") LearningProgram learningProgram) {
        learningProgramService.saveLearningProgram(learningProgram);
        return "redirect:/learningProgram/list";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        learningProgramService.deleteLearningProgramById(id);
        return "redirect:/learningProgram/list";
    }
}