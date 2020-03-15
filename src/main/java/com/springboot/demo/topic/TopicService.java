package com.springboot.demo.topic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author mzwandile on 2020/03/15
 * @project rest-api
 */

@Slf4j
@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopic(String id) {
        return topicRepository.findById(id);
    }

    public Topic addTopic(Topic topic) {
        log.info("Adding topic: [{}] ",topic);
        topicRepository.save(topic);
        log.info("Added topic: [{}] ",topic);
        return topic;
    }

    public void deleteTopic(String id) {
        log.info("Deleting topic: [{}] ",id);
        topicRepository.deleteById(id);
        log.info("Deleted topic: [{}] ",id);
    }

    public void updateTopic(String id, Topic topic) {
        log.info("Updating topic: [{}]", id);
        topicRepository.save(topic);
        log.info("Updated topic: [{}]" , id);
    }
}
