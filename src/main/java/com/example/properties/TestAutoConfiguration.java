package com.example.properties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yanglikun on 2017/3/15.
 */
@Configuration
@EnableConfigurationProperties(TestConfig.class)
public class TestAutoConfiguration {
}
