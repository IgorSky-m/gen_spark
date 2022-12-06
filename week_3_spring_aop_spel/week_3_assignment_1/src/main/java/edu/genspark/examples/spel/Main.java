package edu.genspark.examples.spel;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SpEL bean = context.getBean(SpEL.class);
        System.out.println(bean);
    }
}
