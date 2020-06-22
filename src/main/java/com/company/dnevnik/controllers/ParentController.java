package com.company.dnevnik.controllers;

import com.company.dnevnik.entities.Parent;
import com.company.dnevnik.services.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("parent")
public class ParentController {
    @Autowired
    ParentService parentService;

    @GetMapping(value = "/list")
    public String getParentList(Model model) {
        List<Parent> parentList = parentService.getAllParents();
        model.addAttribute("parentList", parentList);
        model.addAttribute("bool", true);
        return "parentList";
    }

    @GetMapping(value = "/{id}")
    public String parentProfile(@PathVariable("id") Long id, Model model) {
        Parent parent = parentService.getParentById(id);
        model.addAttribute("parent", parent);
        return "parentDetail";
    }

    @PostMapping(value = "/create")
    public String addParent(@Valid @ModelAttribute("parent") Parent parent) {
        parentService.saveParent(parent);
        return "redirect:/parent/list";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        parentService.deleteParentById(id);
        return "redirect:/parent/list";
    }
}