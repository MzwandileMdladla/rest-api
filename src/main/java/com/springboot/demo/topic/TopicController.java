package com.springboot.demo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author mzwandile on 2020/03/15
 * @project rest-api
 */

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public List<Topic> getTopics() {
        return topicService.getTopics();
    }

    @GetMapping("/topics/{id}")
    public Optional<Topic> getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    @PostMapping("/topics")
    public Topic addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
        return topic;
    }

    @DeleteMapping("/topics/{id}")
    public Optional<Topic> deleteTopic(@PathVariable String id) {
        Optional<Topic> deletedTopic = topicService.getTopic(id);
        topicService.deleteTopic(id);
        return deletedTopic;
    }

    @PutMapping("/topics/{id}")
    public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
        topicService.updateTopic(id, topic);
    }
}
