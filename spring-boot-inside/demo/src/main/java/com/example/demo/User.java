package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class User implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private String name;
    private String  sex;

    public User() {
        System.out.println("--------------User----------------Constructed----------------");
    }

    public void init(){
        System.out.println("--------------User-----------------init--------------------------");
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setName(String name) {

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
