package com.example.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by yanglikun on 2017/3/15.
 */
@ConfigurationProperties(prefix = "ylk")
public class TestConfig {

    private String name;

    public TestConfig() {
        System.out.println("初始化 TestConfig");
    }

    public String getName() {
        System.out.println("getName..");
        return name;
    }

    public void setName(String name) {
        System.out.println("setName:" + name);
        this.name = name;
    }
}
