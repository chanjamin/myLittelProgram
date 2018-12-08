package com.example.extendspringboot;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationContextInitializer implements ApplicationContextInitializer {
    public void initialize(ConfigurableApplicationContext applicationContext) {
        applicationContext.getBeanFactory().createBean(Runnable.class,AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE,false);
        System.out.println(applicationContext.getBeanDefinitionCount());
    }
}
