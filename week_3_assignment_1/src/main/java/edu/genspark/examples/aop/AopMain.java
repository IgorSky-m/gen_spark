package edu.genspark.examples.aop;

import edu.genspark.examples.aop.api.IService;
import edu.genspark.examples.aop.config.AopApplicationConfiguration;
import edu.genspark.system.utills.ContextProcessor;
import edu.genspark.system.utills.api.IContextProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopMain {
    public static void main(String[] args) {
        IContextProcessor processor =
                new ContextProcessor(new AnnotationConfigApplicationContext(AopApplicationConfiguration.class))
                        .printContainerBeanNames();

        IService bean = processor.getBean("service");
        bean.doWork();
        bean.doWorkWithValue("dsa");
        bean.doWorkWithValue("Hello AOP");

        processor.closeContext();
    }
}
