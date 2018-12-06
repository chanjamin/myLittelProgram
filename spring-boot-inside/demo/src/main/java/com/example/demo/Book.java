package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

//@Component()
public class Book {
    ApplicationContext context;

    public Book(ApplicationContext context) {
        this.context = context;
    }

    public ApplicationContext getContext() {
        return context;
    }
}
