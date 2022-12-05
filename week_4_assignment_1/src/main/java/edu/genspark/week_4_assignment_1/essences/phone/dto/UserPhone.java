package edu.genspark.week_4_assignment_1.essences.phone.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.genspark.week_4_assignment_1.api.IIdentifiable;
import edu.genspark.week_4_assignment_1.essences.user.dto.AppUser;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class UserPhone implements IIdentifiable<UUID> {

    @Id
    private UUID id;

    private String number;

    @ManyToOne
    @JsonBackReference
    private AppUser appUser;
}
