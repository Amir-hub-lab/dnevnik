package com.company.dnevnik.controllers;

import com.company.dnevnik.entities.Group;
import com.company.dnevnik.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("group")
public class GroupController {
    @Autowired
    GroupService groupService;

    @GetMapping(value = "/list")
    public String getGroupList(Model model) {
        List<Group> groupList = groupService.getAllGroups();
        model.addAttribute("groupList", groupList);
        model.addAttribute("bool", true);
        return "groupList";
    }

    @GetMapping(value = "/{id}")
    public String groupProfile(@PathVariable("id") Long id, Model model) {
        Group group = groupService.getGroupById(id);
        model.addAttribute("group", group);
        return "groupDetail";
    }

    @PostMapping(value = "/create")
    public String addGroup(@Valid @ModelAttribute("group") Group group) {
        groupService.saveGroup(group);
        return "redirect:/group/list";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        groupService.deleteGroupById(id);
        return "redirect:/group/list";
    }
}