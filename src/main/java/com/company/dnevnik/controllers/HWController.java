package com.company.dnevnik.controllers;

import com.company.dnevnik.entities.HW;
import com.company.dnevnik.services.HWService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("hw")
public class HWController {
    @Autowired
    HWService hwService;

    @GetMapping(value = "/list")
    public String getHWList(Model model) {
        List<HW> hwList = hwService.getAllHWs();
        model.addAttribute("hwList", hwList);
        model.addAttribute("bool", true);
        return "hwList";
    }

    @GetMapping(value = "/{id}")
    public String hwProfile(@PathVariable("id") Long id, Model model) {
        HW hw = hwService.getHWById(id);
        model.addAttribute("hw", hw);
        return "hwDetail";
    }

    @PostMapping(value = "/create")
    public String addHW(@Valid @ModelAttribute("hw") HW hw) {
        hwService.saveHW(hw);
        return "redirect:/hw/list";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        hwService.deleteHWById(id);
        return "redirect:/hw/list";
    }
}