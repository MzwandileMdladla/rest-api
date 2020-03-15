package com.springboot.demo.topic;

import org.springframework.data.repository.CrudRepository;

/**
 * @author mzwandile on 2020/03/15
 * @project rest-api
 */
public interface TopicRepository extends CrudRepository<Topic, String> {
}
