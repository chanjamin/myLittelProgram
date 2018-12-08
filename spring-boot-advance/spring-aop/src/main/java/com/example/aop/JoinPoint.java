package com.example.aop;

import org.springframework.stereotype.Component;

@Component
public class JoinPoint {
    void pointCut(String arg){
        System.out.println(arg);
    }
}
