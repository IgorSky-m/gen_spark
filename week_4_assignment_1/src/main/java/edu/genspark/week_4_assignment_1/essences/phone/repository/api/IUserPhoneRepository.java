package edu.genspark.week_4_assignment_1.essences.phone.repository.api;

import edu.genspark.week_4_assignment_1.essences.phone.dto.UserPhone;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUserPhoneRepository extends JpaRepositoryImplementation<UserPhone, UUID> {
}
