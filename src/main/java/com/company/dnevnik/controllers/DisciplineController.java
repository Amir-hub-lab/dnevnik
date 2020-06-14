package com.company.dnevnik.controllers;

import com.company.dnevnik.entities.Discipline;
import com.company.dnevnik.services.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/discipline")
public class DisciplineController {
    @Autowired
    DisciplineService disciplineService;

    @GetMapping(value = "/list")
    public String getDisciplineList(Model model) {
        List<Discipline> disciplineList = disciplineService.getAllDisciplines();
        model.addAttribute("disciplineList", disciplineList);
        model.addAttribute("bool", true);
        return "disciplineList";
    }

    @GetMapping(value = "/{id}")
    public String disciplineProfile(@PathVariable("id") Long id, Model model) {
        Discipline discipline = disciplineService.getDisciplineById(id);
        model.addAttribute("discipline", discipline);
        return "disciplineDetail";
    }

    @PostMapping(value = "/create")
    public String addDiscipline(@Valid @ModelAttribute("discipline") Discipline discipline) {
        disciplineService.saveDiscipline(discipline);
        return "redirect:/discipline/list";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        disciplineService.deleteDisciplineById(id);
        return "redirect:/discipline/list";
    }
}