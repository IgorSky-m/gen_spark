package edu.genspark.examples.annotation.entity;


import edu.genspark.entity.BaseAddress;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class AnnotationSecondaryAddress extends BaseAddress {

    @Value("San Diego")
    private String city;

    @Value("California")
    private String state;

    @Value("The United States")
    private String country;

    @Value("91911")
    private String zipcode;
}