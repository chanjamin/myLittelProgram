package com.example.applicationevent;

import org.springframework.context.ApplicationListener;

public class MyAppListener implements ApplicationListener<MyAppEvent> {
    public void onApplicationEvent(MyAppEvent event) {
        System.out.println("MyAppListener1 "+" receive "+event.getSource());
    }
}
