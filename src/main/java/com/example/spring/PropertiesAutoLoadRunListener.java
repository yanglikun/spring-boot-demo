package com.example.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yanglikun on 2017/3/19.
 */
public class PropertiesAutoLoadRunListener implements SpringApplicationRunListener, Ordered {

    private final SpringApplication application;

    private final String[] args;

    public PropertiesAutoLoadRunListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
    }

    @Override
    public void starting() {

    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        try {
            if (!(context instanceof ResourcePatternResolver)) {
                return;
            }
            Class<?> mainApplicationClass = application.getMainApplicationClass();
            if (mainApplicationClass == null) {
                return;
            }
            ImportProperties importProperties = mainApplicationClass.getAnnotation(ImportProperties.class);
            if (importProperties == null) {
                return;
            }
            Set<String> locations = new HashSet<String>(Arrays.asList(importProperties.locations()));
            if (locations.isEmpty()) {
                return;
            }

            List<Resource> resources = locations.stream().flatMap(new Function<String, Stream<Resource>>() {
                public Stream<Resource> apply(String location) {
                    try {
                        return Stream.of(context.getResources(location));
                    } catch (IOException e) {
                        throw new RuntimeException("加载resources异常:" + location);
                    }
                }
            }).collect(Collectors.toList());

            for (Resource resource : resources) {
                String filename = resource.getFilename();
                Properties properties = PropertiesLoaderUtils.loadProperties(resource);
                if (!properties.isEmpty()) {
                    context.getEnvironment().getPropertySources().addLast(new PropertiesPropertySource(filename, properties));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void finished(ConfigurableApplicationContext context, Throwable exception) {

    }

    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE;
    }
}
