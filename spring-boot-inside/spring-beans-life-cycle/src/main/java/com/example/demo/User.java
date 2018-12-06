package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    @Value("123")
    private String name;
    @Value("456")
    private String  sex;

    public User() {
        System.out.println("--------------User----------------Constructed----------------");
    }

    public void init(){
        System.out.println("--------------User-----------------init--------------------------");
    }

    public void setSex(String sex) {
        System.out.println("setSex");
        this.sex = sex;
    }

    public void setName(String name) {
        System.out.println("setName");
        this.name = name;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Beans destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("---------------------------User--------------afterPropertiesSet-----------------------");
    }
}
