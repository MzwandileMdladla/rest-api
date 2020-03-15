package com.springboot.demo.topic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mzwandile on 2020/03/15
 * @project rest-api
 */

@Slf4j
@Service
public class TopicService {
    List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("Java", "Core Java", "Java Standard Edition"),
            new Topic("JavaScript", "JavaScript", "JavaScript (JS)"),
            new Topic("Spring", "Spring Framework", "Spring Boot")
    ));

    public List<Topic> getTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        return topics.stream().filter(t -> t.getId().equalsIgnoreCase(id)).findFirst().get();
    }

    public Topic addTopic(Topic topic) {
        log.info("Adding topic: [{}] ",topic);
        topics.add(topic);
        log.info("Added topic: [{}] ",topic);
        return topic;
    }

    public void deleteTopic(String id) {
        log.info("Deleting topic: [{}] ",id);
        topics.remove(getTopic(id));
        log.info("Deleted topic: [{}] ",id);
    }

    public void updateTopic(String id, Topic topic) {
        log.info("Updating topic: [{}]", id);
        for (int i=0; i<topics.size(); i++) {
            Topic t = topics.get(i);
            if (t.getId().equalsIgnoreCase(id)) {
                topics.set(i, topic);
                log.info("Updated topic: [{}]" , id);
                return;
            }
        }
    }
}
