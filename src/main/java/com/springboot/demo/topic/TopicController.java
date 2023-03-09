package com.springboot.demo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author mzwandile on 2020/03/15
 * @project rest-api
 */

@RestController
@RequestMapping("api/v1/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping
    public List<Topic> getTopics() {
        return topicService.getTopics();
    }

    @GetMapping("{id}")
    public Optional<Topic> getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    @PostMapping
    public Topic addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
        return topic;
    }

    @DeleteMapping("{id}")
    public Optional<Topic> deleteTopic(@PathVariable String id) {
        Optional<Topic> deletedTopic = topicService.getTopic(id);
        topicService.deleteTopic(id);
        return deletedTopic;
    }

    @PutMapping("{id}")
    public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
        topicService.updateTopic(id, topic);
    }
}
