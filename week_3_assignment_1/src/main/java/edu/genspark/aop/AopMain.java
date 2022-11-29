package edu.genspark.aop;

import edu.genspark.aop.api.IService;
import edu.genspark.aop.config.AopApplicationConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class AopMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AopApplicationConfiguration.class);
        System.out.println(Arrays.deepToString(context.getBeanDefinitionNames()));

        IService bean = (IService) context.getBean("service");

        bean.doWork();
        bean.doWorkWithValue("dsa");
        context.close();
    }
}
