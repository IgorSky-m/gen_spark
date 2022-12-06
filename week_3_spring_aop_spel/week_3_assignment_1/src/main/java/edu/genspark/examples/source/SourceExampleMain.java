package edu.genspark.examples.source;


import edu.genspark.examples.source.config.ApplicationConfiguration;
import edu.genspark.examples.source.entity.SourceStudent;
import edu.genspark.system.utills.ContextProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SourceExampleMain {
    public static void main(String[] args) {
        new ContextProcessor(new AnnotationConfigApplicationContext(ApplicationConfiguration.class))
                .printContextInfo(SourceStudent.class)
                .closeContext();
    }
}
