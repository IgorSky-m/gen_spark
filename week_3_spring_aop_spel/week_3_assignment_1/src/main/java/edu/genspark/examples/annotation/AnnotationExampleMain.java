package edu.genspark.examples.annotation;

import edu.genspark.entity.api.IStudent;
import edu.genspark.system.utills.ContextProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AnnotationExampleMain {
    public static void main(String[] args) {
        new ContextProcessor(new ClassPathXmlApplicationContext("AnnotationExampleContext.xml"))
                .printContainerBeanNames()
                .printContextInfo(IStudent.class, "annotationStudent", "annotationConstructorInjectionStudent")
                .closeContext();
    }
}
