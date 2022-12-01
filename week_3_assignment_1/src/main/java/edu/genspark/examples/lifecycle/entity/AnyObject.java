package edu.genspark.examples.lifecycle.entity;

import org.springframework.stereotype.Component;

@Component
public class AnyObject {

    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
