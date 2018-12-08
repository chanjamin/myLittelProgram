package com.example.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {
    @Before("execution(void com.example.aop.JoinPoint.pointCut(*))")
    public void logBefore(){
        System.out.println("--------------------------------logBefore");
    }
}
