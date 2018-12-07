package com.example;

import net.example.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.Callable;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        Runnable bean = context.getBean(Runnable.class);
        System.out.println(bean);
        User user = context.getBean(User.class);
        System.out.println(user);
    }
}
