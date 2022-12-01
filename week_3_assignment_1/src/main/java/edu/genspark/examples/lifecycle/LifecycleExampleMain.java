package edu.genspark.examples.lifecycle;

import edu.genspark.examples.lifecycle.entity.AnyObject;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifecycleExampleMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext("edu.genspark.examples.lifecycle");

        context.getBean(AnyObject.class);

        context.close();
    }
}