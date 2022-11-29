package edu.genspark.examples.spel;

import java.util.concurrent.ThreadLocalRandom;

public class StaticMethodTest {
    public static int test(){
        return ThreadLocalRandom.current().nextInt();
    }
}
