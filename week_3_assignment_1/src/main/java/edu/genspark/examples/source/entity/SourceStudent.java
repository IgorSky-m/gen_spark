package edu.genspark.examples.source.entity;

import edu.genspark.entity.BaseStudent;
import edu.genspark.entity.api.IAddress;
import edu.genspark.entity.api.IPhone;

import java.util.List;

public class SourceStudent extends BaseStudent {

    public SourceStudent(int id, String name, List<IPhone> ph, IAddress add) {
        super(id, name, ph, add);
    }

    public SourceStudent() {
    }

    public void startUp(){
        System.out.println("INIT SOURCE STUDENT STARTUP");
    }

    public void shutDown(){
        System.out.println("INIT SOURCE STUDENT SHUTDOWN");
    }
}
