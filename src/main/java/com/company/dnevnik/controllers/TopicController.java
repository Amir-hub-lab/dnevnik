package com.company.dnevnik.controllers;

import com.company.dnevnik.entities.Topic;
import com.company.dnevnik.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("topic")
public class TopicController {
    @Autowired
    TopicService topicService;

    @GetMapping(value = "/list")
    public String getTopicList(Model model) {
        List<Topic> topicList = topicService.getAllTopics();
        model.addAttribute("topicList", topicList);
        model.addAttribute("bool", true);
        return "topicList";
    }

    @GetMapping(value = "/{id}")
    public String topicProfile(@PathVariable("id") Long id, Model model) {
        Topic topic = topicService.getTopicById(id);
        model.addAttribute("topic", topic);
        return "topicDetail";
    }

    @PostMapping(value = "/create")
    public String addTopic(@Valid @ModelAttribute("topic") Topic topic) {
        topicService.saveTopic(topic);
        return "redirect:/topic/list";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        topicService.deleteTopicById(id);
        return "redirect:/topic/list";
    }
}