package org.example.entities.rest.api_case;

import lombok.extern.slf4j.Slf4j;
import org.example.entities.rest.api_case.api.IMyEntityRepository;
import org.example.entities.rest.api_case.api.IMyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@Transactional(readOnly = true)
@Service
public class MyService implements IMyService {


    private final IMyEntityRepository repository;

    public MyService(IMyEntityRepository repository) {
        this.repository = repository;
    }


    @Override
    public MyEntity findById(UUID id) {
        try {
            return repository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Entity not found"));
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<MyEntity> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public MyEntity create(MyEntity entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public MyEntity update(UUID id, MyEntity entity) {
        MyEntity byId = findById(id);
        byId.setName(entity.getName());
        byId.setDescription(entity.getDescription());
        try {
            return repository.save(byId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
