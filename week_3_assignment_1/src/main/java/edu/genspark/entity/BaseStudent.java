package edu.genspark.entity;

import edu.genspark.entity.api.IAddress;
import edu.genspark.entity.api.IPhone;
import edu.genspark.entity.api.IStudent;
import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseStudent implements IStudent {
    private int id;
    private String name;
    private List<IPhone> ph;
    private IAddress add;


    public void startUp(){
        System.out.println("INIT BASE STUDENT STARTUP");
    }

    public void shutDown(){
        System.out.println("INIT BASE STUDENT SHUTDOWN");
    }


}
