package edu.genspark.entity;

import edu.genspark.entity.api.IPhone;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BasePhone implements IPhone {
    private String mob;
}
