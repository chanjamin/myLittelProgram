package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAdvice {
    @Before("execution(void com.example.aop.JoinPoint.pointCut(*))")
    public void logBefore(){
        System.out.println("--------------------------------logBefore");
    }
    @After("execution(void com.example.aop.JoinPoint.pointCut(*))")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("----------------logAfter===========arg="+ Arrays.asList(joinPoint.getArgs()));
    }
}
