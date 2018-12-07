package com.example.applicationevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ApplicationEventApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication( ApplicationEventApplication.class);
        MyAppListener listener = new MyAppListener();
        springApplication.addListeners(listener);
        ConfigurableApplicationContext context = springApplication.run(args);
        context.publishEvent(new MyAppEvent("事件"));
        context.close();
    }
}
