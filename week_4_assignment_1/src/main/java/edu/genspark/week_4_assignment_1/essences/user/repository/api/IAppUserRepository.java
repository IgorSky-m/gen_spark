package edu.genspark.week_4_assignment_1.essences.user.repository.api;


import edu.genspark.week_4_assignment_1.essences.user.dto.AppUser;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IAppUserRepository extends JpaRepositoryImplementation<AppUser, UUID> {
}
