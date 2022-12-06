package edu.genspark.week_4_assignment_1.essences.user.service;

import edu.genspark.week_4_assignment_1.api.AbstractBaseCRUDService;
import edu.genspark.week_4_assignment_1.essences.phone.repository.api.IUserPhoneRepository;
import edu.genspark.week_4_assignment_1.essences.user.dto.AppUser;
import edu.genspark.week_4_assignment_1.essences.user.repository.api.IAppUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class AppUserService extends AbstractBaseCRUDService<AppUser, UUID> {

    private static final Logger logger = LoggerFactory.getLogger(AppUserService.class);

    private final IUserPhoneRepository userPhoneRepository;

    public AppUserService(IAppUserRepository repository, IUserPhoneRepository userPhoneRepository, MessageSource messageSource) {
        super(repository, messageSource);
        this.userPhoneRepository = userPhoneRepository;
    }

    @Transactional
    @Override
    public AppUser save(AppUser appUser) {
        AppUser savedUser = super.save(appUser);
        appUser.getPhones().forEach(e -> e.setAppUser(appUser));
        userPhoneRepository.saveAllAndFlush(appUser.getPhones());

        return savedUser;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }


}
