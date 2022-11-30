package edu.genspark.system.utills;

import edu.genspark.entity.BaseStudent;
import edu.genspark.entity.api.IStudent;
import edu.genspark.system.utills.api.IContextProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@RequiredArgsConstructor
public class ContextProcessor implements IContextProcessor {

    private final ConfigurableApplicationContext context;

    @Override
    public IContextProcessor printContainerBeanNames() {
        System.out.println("----------------------------BEAN NAMES INFO--------------------------------------------");
        System.out.println(Arrays.deepToString(context.getBeanDefinitionNames()));
        return this;
    }

    @Override
    public IContextProcessor printContextInfo(Class<? extends BaseStudent> studentClass, String...identifiers) {
        System.out.println("----------------------------STUDENT INFO--------------------------------------------");
        if (identifiers.length > 0){
            Arrays.stream(identifiers).forEach(id -> printInfo(studentClass, id));
        } else {
            IStudent student = context.getBean(studentClass);

            System.out.println(student);
        }

        return this;
    }

    @Override
    public <T> T getBean(String id) {
        return (T) context.getBean(id);
    }

    @Override
    public void closeContext() {
        context.close();
    }


    private void printInfo(Class<? extends BaseStudent> studentClass, String identifier){
        IStudent student = context.getBean(identifier, studentClass);
        System.out.println(student);
    }
}
