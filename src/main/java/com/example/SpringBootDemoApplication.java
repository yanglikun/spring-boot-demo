package com.example;

import com.example.spring.ImportProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = {ThymeleafAutoConfiguration.class})
@ImportResource({"classpath:config/spring*.xml", "classpath:spring*.xml"})
@ImportProperties(locations = {"classpath:spring-autoload-*.properties"})
public class SpringBootDemoApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootDemoApplication.class);
    }

}
