package com.company.dnevnik.controllers;

import com.company.dnevnik.entities.ReportCard;
import com.company.dnevnik.services.ReportCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("report_card")
public class ReportCardController {
    @Autowired
    ReportCardService reportCardService;

    @GetMapping(value = "/list")
    public String getReportCardList(Model model) {
        List<ReportCard> reportCardList = reportCardService.getAllReportCards();
        model.addAttribute("reportCardList", reportCardList);
        model.addAttribute("bool", true);
        return "reportCardList";
    }

    @GetMapping(value = "/{id}")
    public String reportCardProfile(@PathVariable("id") Long id, Model model) {
        ReportCard reportCard = reportCardService.getReportCardById(id);
        model.addAttribute("reportCard", reportCard);
        return "reportCardDetail";
    }

    @PostMapping(value = "/create")
    public String addReportCard(@Valid @ModelAttribute("reportCard") ReportCard reportCard) {
        reportCardService.saveReportCard(reportCard);
        return "redirect:/reportCard/list";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        reportCardService.deleteReportCardById(id);
        return "redirect:/reportCard/list";
    }
}