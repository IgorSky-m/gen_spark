package edu.genspark.entity;

import edu.genspark.entity.api.IAddress;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseAddress implements IAddress {
    private String city;
    private String state;
    private String country;
    private String zipcode;
}
