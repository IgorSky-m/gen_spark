package edu.genspark.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomLogger {

    @Before("@annotation(edu.genspark.aop.annotations.AopCustomLog)")
    public void startLog(){
        System.out.println("---------------------start log---------------------");
    }

    @After("@annotation(edu.genspark.aop.annotations.AopCustomLog)")
    public void endLog(){
        System.out.println("---------------------end log---------------------");
    }

}
