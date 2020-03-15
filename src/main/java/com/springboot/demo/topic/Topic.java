package com.springboot.demo.topic;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author mzwandile on 2020/03/15
 * @project rest-api
 */

@Data
@AllArgsConstructor
public class Topic {

    private String id;
    private String name;
    private String description;
}
