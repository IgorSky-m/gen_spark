package edu.genspark.examples.lifecycle.entity;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AnyObject implements BeanNameAware, DisposableBean {

    public AnyObject(){
        System.out.println("in AnyObject constructor");
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    private void postConstruct(){
        System.out.println("in AnyObject Post Construct");
    }

    @PreDestroy
    private void preDestroy(){
        System.out.println("in AnyObject Pre Destroy");
    }


    @Override
    public void setBeanName(String s) {
        System.out.println("in AnyObject bean name aware interface");
        name = s + " Aware";
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("in AnyObject Disposable bean destroy");
    }
}
