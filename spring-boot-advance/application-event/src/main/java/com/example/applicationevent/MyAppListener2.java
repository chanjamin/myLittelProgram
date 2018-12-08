package com.example.applicationevent;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyAppListener2  {

    @EventListener
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("MyAppListener2 "+" receive "+event.getSource());
    }
}
