package com.example.extendspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 不支持refresh
 */
@SpringBootApplication
public class ExtendSpringbootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ExtendSpringbootApplication.class, args);
        context.stop();
    }
}
