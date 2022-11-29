package edu.genspark.examples.annotation.entity;

import edu.genspark.entity.BaseStudent;
import edu.genspark.entity.api.IAddress;
import edu.genspark.entity.api.IPhone;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class AnnotationConstructorInjectionStudent extends BaseStudent {

    public AnnotationConstructorInjectionStudent(
            @Value("78") int id,
            @Value("${edu.genspark.examples.annotation.entity.student.name}") String name,
            List<IPhone> ph, //Autowired by default
            @Qualifier("annotationSecondaryAddress") IAddress add //Autowired by default, use qualifier because want to change realization
    ){
        super(id, name, ph, add);
    }

}
