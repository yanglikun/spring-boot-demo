package com.example.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("dbConfig")
@PropertySource(value = "classpath:test.properties",ignoreResourceNotFound = true)
public class DBConfig {

    @Value("${test.url}")
    private String url;

    @Value("${test.userName}")
    private String userName;

    @Value("${test.password}")
    private String password;

    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
