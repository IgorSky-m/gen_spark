package edu.genspark.examples.lifecycle.processors;

import edu.genspark.examples.lifecycle.annotations.DisableTracking;
import edu.genspark.examples.lifecycle.entity.Laptop;
import edu.genspark.examples.lifecycle.entity.api.IDevice;
import edu.genspark.examples.lifecycle.entity.api.ITrackable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class TestBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof Laptop){
            System.out.println("in Laptop device post processor BeforeInitialization");
        }

        DisableTracking annotation = bean.getClass().getAnnotation(DisableTracking.class);
        if (annotation != null && bean instanceof ITrackable){
            ((ITrackable) bean).setTrackingActive(false);
        }

       return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Laptop){
            System.out.println("in Laptop device post processor AfterInitialization");
        }

        StringBuilder builder =
                new StringBuilder(bean instanceof IDevice ? ((IDevice) bean).getName() : beanName);

        if (bean instanceof ITrackable){
            builder.append(" is tracking active: ").append(((ITrackable) bean).isTrackingActive());
        }

        System.out.println(builder);

        return bean;
    }





}
