package com.company.dnevnik.controllers;

import com.company.dnevnik.entities.Mark;
import com.company.dnevnik.services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/mark")
public class MarkController {
    @Autowired
    MarkService markService;

    @GetMapping(value = "/list")
    public String getMarkList(Model model) {
        List<Mark> markList = markService.getAllMarks();
        model.addAttribute("markList", markList);
        model.addAttribute("bool", true);
        return "markList";
    }

    @GetMapping(value = "/{id}")
    public String markProfile(@PathVariable("id") Long id, Model model) {
        Mark mark = markService.getMarkById(id);
        model.addAttribute("mark", mark);
        return "markDetail";
    }

    @PostMapping(value = "/create")
    public String addMark(@Valid @ModelAttribute("mark") Mark mark) {
        markService.saveMark(mark);
        return "redirect:/mark/list";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        markService.deleteMarkById(id);
        return "redirect:/mark/list";
    }
}