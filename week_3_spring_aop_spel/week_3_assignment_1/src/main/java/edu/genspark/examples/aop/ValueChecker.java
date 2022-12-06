package edu.genspark.examples.aop;

import edu.genspark.examples.aop.annotations.ValueCheck;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Aspect
@Component
public class ValueChecker {


    @Before("@annotation(valueCheck) && args(value, ..)")
    void pointcut(ValueCheck valueCheck, String value){
        System.out.println(Objects.equals(valueCheck.value(), value) ? "___VALUE CHECK GOOD___" : "___VALUE CHECK BAD___");
    }

}
