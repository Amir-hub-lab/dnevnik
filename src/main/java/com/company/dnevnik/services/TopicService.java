package com.company.dnevnik.services;

import com.company.dnevnik.entities.Topic;

import java.util.List;

public interface TopicService {

    List<Topic> getAllTopics();

    Topic getTopicById(Long id);

    void updateTopic(Long id, Topic topic);

    void saveTopic(Topic topic);

    void deleteTopicById(Long id);
}
