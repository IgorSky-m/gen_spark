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

    @Value("${edu.genspark.examples.spel.word}")
    private String word;

    public int random(){
        return ThreadLocalRandom.current().nextInt();
    }
}
