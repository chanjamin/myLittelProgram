package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/***
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("-------------------------------------------BeanFactoryPostProcessor-----------------------------------");
//        Method[] methods = beanFactory.getClass().getMethods();
//        Arrays.asList(methods).forEach(System.out::println);
//        System.out.println("-------------------------------------------BeanFactoryPostProcessor-----------------------------------");
    }
}
