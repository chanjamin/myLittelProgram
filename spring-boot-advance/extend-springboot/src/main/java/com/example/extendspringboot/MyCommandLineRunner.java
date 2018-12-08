package com.example.extendspringboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(0)
@Component
public class MyCommandLineRunner implements CommandLineRunner {
    public void run(String... args) throws Exception {
        System.out.println(getClass());
    }
}
