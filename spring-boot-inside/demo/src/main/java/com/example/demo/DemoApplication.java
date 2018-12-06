package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@SpringBootApplication
@EnableCaching
public class DemoApplication {

    public static void main(String[] args) {
  ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

//        User user = context.getBeanFactory().getBean(User.class);
//        System.out.println(user);
//        UserBean bean = context.getBeanFactory().getBean(UserBean.class);
//        System.out.println(bean);
//        Object user2 = context.getBeanFactory().getBean("userBean");
//        System.out.println(user2);
//        Object  userBean= context.getBeanFactory().getBean("&userBean");
//        System.out.println(userBean);

        //测试spring 4.3构造函数参数注入

//        Book book = context.getBean(Book.class);
//        System.out.println(book.getContext());
    }

    @Bean(initMethod = "init")
    @Primary
    public User createU(){
        return new User();
    }
}
