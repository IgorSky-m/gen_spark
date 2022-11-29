package edu.genspark.examples.annotation.entity;

import edu.genspark.entity.BasePhone;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Data
@Component
public class AnnotationPhonePrimary extends BasePhone {

    @Value("${edu.genspark.examples.annotation.entity.phone.mob}")
    private String mob;
}
