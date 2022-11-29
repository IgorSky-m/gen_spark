package edu.genspark.examples.annotation.entity;

import edu.genspark.entity.BaseAddress;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Data
@Component
@Primary
public class AnnotationAddress extends BaseAddress {

    @Value("Chi")
    private String city;

    @Value("Illinois")
    private String state;

    @Value("The United States")
    private String country;

    @Value("60002")
    private String zipcode;
}
