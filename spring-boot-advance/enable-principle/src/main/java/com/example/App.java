package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableLog(valueToLog = "loglogloglogloglog")
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
//        Book bean = context.getBean(Book.class);
        User bean = context.getBean(User.class);
        System.out.println(bean);
    }
}
