package com.company.dnevnik.services.impl;

import com.company.dnevnik.entities.Topic;
import com.company.dnevnik.repositories.TopicRepository;
import com.company.dnevnik.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService{
    @Autowired
    TopicRepository topicRepository;

    @Override
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @Override
    public Topic getTopicById(Long id) {
        Optional<Topic> topic = topicRepository.findById(id);
        return topic.orElse(new Topic());
    }

    @Override
    public void updateTopic(Long id, Topic topic) {

    }

    @Override
    public void saveTopic(Topic topic) {
        topicRepository.save(topic);
    }

    @Override
    public void deleteTopicById(Long id) {
        topicRepository.deleteById(id);
    }
}
