package edu.genspark.examples.annotation.entity;

import edu.genspark.entity.BasePhone;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Data
@Component
public class AnnotationPhoneSecondary extends BasePhone {

    @Value("(001) 434-4321")
    private String mob;
}
