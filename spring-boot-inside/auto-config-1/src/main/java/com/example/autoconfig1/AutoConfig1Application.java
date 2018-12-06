package com.example.autoconfig1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

import java.util.Map;

@SpringBootApplication
public class AutoConfig1Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AutoConfig1Application.class, args);
        Converter bean = context.getBean(Converter.class);
        System.out.println(bean);
    }

    @Bean
    @Conditional(UTF8Condition.class)
    UTF8Converter utf8Converter(){
        return new UTF8Converter();
    }
    @Bean
    @Conditional(GBKCondition.class)
    GBKConverter gbkConverter(){
        return new GBKConverter();
    }
}
