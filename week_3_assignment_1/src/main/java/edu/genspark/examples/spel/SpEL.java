package edu.genspark.examples.spel;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Data
@Component
public class SpEL {

    @Value("#{5}")
    private int i;

    @Value("#{50}")
    private int y;

    @Value("#{spEL.i + spEL.y}")
    private int z;

    @Value("#{spEL.random()}")
    private int random;

    @Value("#{spEL.z < spEL.random}")
    private boolean less;

    @Value("#{spEL.less ? 'LESS' : 'GREATER'}")
    private String ternaryOp;


    @Value("#{T(java.util.concurrent.ThreadLocalRandom).current().nextInt()}")
    private int nextRandomWithStaticMethod;


    @Value("${edu.genspark.examples.spel.word}")
    private String word;

    @Value("#{new edu.genspark.examples.spel.TestObject()}")
    private TestObject testObject;

    @Value("#{new edu.genspark.examples.spel.TestObject('Hello', 2)}")
    private TestObject testObjectWithParam;

    public int random(){
        return ThreadLocalRandom.current().nextInt();
    }
}
