package edu.genspark.week_4_assignment_1.essences.user.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.genspark.week_4_assignment_1.api.IIdentifiable;
import edu.genspark.week_4_assignment_1.essences.phone.dto.UserPhone;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class AppUser implements IIdentifiable<UUID> {

    @Id
    private UUID id;

    private String name;

    private String login;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


    @OneToMany(mappedBy = "appUser", targetEntity = UserPhone.class, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<UserPhone> phones;

}
