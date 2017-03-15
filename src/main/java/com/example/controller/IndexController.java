package com.example.controller;

import com.example.properties.DBConfig;
import com.example.properties.TestConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikun on 2017/3/15.
 */
@RestController
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private TestConfig testConfig;

    @Value("${server.port}")
    private String appPort;
    @Autowired
    private DBConfig dbConfig;

    @RequestMapping("/")
    public String index() {
        logger.info("{},{},{}", dbConfig.getUrl(), dbConfig.getPassword(), dbConfig.getUserName());
        return "hello spring boot:" + appPort;
    }
}
