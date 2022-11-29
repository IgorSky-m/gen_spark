package edu.genspark.examples.annotation.entity;

import edu.genspark.entity.BaseStudent;
import edu.genspark.entity.api.IAddress;
import edu.genspark.entity.api.IPhone;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Data
@Component
public class AnnotationStudent extends BaseStudent {

    @Value("23")
    private int id;

    @Value("${edu.genspark.examples.annotation.entity.student.name}")
    private String name;

    @Autowired
    private List<IPhone> ph;

    @Autowired

    private IAddress add;


    @PostConstruct
    public void startUp(){
        System.out.println("INIT ANNOTATION STUDENT STARTUP");
    }

    @PreDestroy
    public void shutDown(){
        System.out.println("INIT ANNOTATION STUDENT SHUTDOWN");
    }
}
