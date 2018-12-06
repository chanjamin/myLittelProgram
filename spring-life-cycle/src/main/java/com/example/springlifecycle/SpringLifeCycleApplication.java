package com.example.springlifecycle;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringLifeCycleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringLifeCycleApplication.class, args);
        LanguageBean bean = context.getBeanFactory().getBean(LanguageBean.class);
        System.out.println(bean.getMyNameInSpring());
    }
}
