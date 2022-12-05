package edu.genspark.examples.lifecycle.entity;


import edu.genspark.examples.lifecycle.entity.api.IDevice;
import edu.genspark.examples.lifecycle.entity.api.ITrackable;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Laptop implements IDevice, ITrackable , BeanNameAware, DisposableBean, InitializingBean {

    public Laptop(){
        System.out.println("in Laptop device constructor");
    }

    @Value("true")
    private boolean trackingActive;

    @Value("Laptop device")
    private String name;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean isTrackingActive() {
        return trackingActive;
    }

    @Override
    public void setTrackingActive(boolean trackingActive) {
        this.trackingActive = trackingActive;
    }


    @PostConstruct
    private void postConstruct(){
        System.out.println("in Laptop device Post Construct");
    }

    @PreDestroy
    private void preDestroy(){
        System.out.println("in Laptop device Pre Destroy");
    }


    @Override
    public void setBeanName(String s) {
        System.out.println("in bean name aware interface");
        name = s + " Device Aware";
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("in Laptop device Disposable bean destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("in Laptop device afterPropertiesSet");
    }
}
