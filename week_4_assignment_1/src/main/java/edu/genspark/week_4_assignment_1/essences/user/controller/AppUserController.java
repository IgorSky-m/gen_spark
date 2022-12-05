package edu.genspark.week_4_assignment_1.essences.user.controller;

import edu.genspark.week_4_assignment_1.api.AbstractBaseController;
import edu.genspark.week_4_assignment_1.api.ICRUDService;
import edu.genspark.week_4_assignment_1.essences.user.dto.AppUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class AppUserController extends AbstractBaseController<AppUser, UUID> {

    public AppUserController(ICRUDService<AppUser, UUID> service) {
        super(service);
    }

}
