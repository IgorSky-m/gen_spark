package edu.genspark.week_4_assignment_1.essences.user.service.api;

import edu.genspark.week_4_assignment_1.api.IReadService;
import edu.genspark.week_4_assignment_1.essences.user.dto.AppUser;

import java.util.UUID;

public interface IAppUserService extends IReadService<AppUser, UUID> {

}
