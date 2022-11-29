package edu.genspark.examples.annotation;

import edu.genspark.examples.annotation.entity.AnnotationConstructorInjectionStudent;
import edu.genspark.examples.annotation.entity.AnnotationStudent;
import edu.genspark.system.utills.ContextProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AnnotationExampleMain {
    public static void main(String[] args) {
        new ContextProcessor(new ClassPathXmlApplicationContext("AnnotationExampleContext.xml"))
                .printContainerBeanNames()
                .printContextInfo(AnnotationStudent.class)
                .printContextInfo(AnnotationConstructorInjectionStudent.class)
                .closeContext();
    }
}
