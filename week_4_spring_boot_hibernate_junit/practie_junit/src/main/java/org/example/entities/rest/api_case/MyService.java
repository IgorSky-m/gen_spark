package org.example.entities.rest.api_case;

import org.example.entities.rest.api_case.api.IMyEntityRepository;
import org.example.entities.rest.api_case.api.IMyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Transactional(readOnly = true)
@Service
public class MyService implements IMyService {

    private final IMyEntityRepository repository;


    public MyService(IMyEntityRepository repository) {
        this.repository = repository;
    }


    @Override
    public MyEntity findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Entity not found"));
    }

    @Override
    public List<MyEntity> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public MyEntity create(MyEntity entity) {
        return repository.save(entity);
    }

    @Transactional
    @Override
    public MyEntity update(UUID id, MyEntity entity) {
        MyEntity byId = findById(id);
        byId.setName(entity.getName());
        byId.setDescription(entity.getDescription());
        return repository.save(byId);
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
