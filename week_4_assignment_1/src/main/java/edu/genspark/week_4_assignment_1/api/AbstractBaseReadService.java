package edu.genspark.week_4_assignment_1.api;

import edu.genspark.week_4_assignment_1.exceptions.NotFoundException;
import edu.genspark.week_4_assignment_1.exceptions.RepositoryException;
import org.slf4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public abstract class AbstractBaseReadService<T , ID> implements IReadService<T, ID> {

    private final JpaRepositoryImplementation<T, ID> repository;
    private final MessageSource messageSource;


    public AbstractBaseReadService(JpaRepositoryImplementation<T, ID> repository, MessageSource messageSource) {
        init(repository, messageSource);
        this.repository = repository;
        this.messageSource = messageSource;
    }

    @Override
    public T getOneById(ID uuid) {
       try {
           return repository.findById(uuid)
                   .orElseThrow(NotFoundException::new);
       } catch (NotFoundException e){
           throw e;
       } catch (Exception e){
           getLogger().error(messageSource.getMessage("error.crud.read.one", null, LocaleContextHolder.getLocale()));
           throw new RepositoryException(e);
       }
    }

    @Override
    public Optional<T> findOneById(ID uuid) {
        try {
            return repository.findById(uuid);
        } catch (Exception e){
            getLogger().error(messageSource.getMessage("error.crud.read.one", null, LocaleContextHolder.getLocale()));
            throw new RepositoryException(e);
        }
    }

    @Override
    public List<T> getAll() {
        try {
            return repository.findAll();
        } catch (Exception e){
            getLogger().error(messageSource.getMessage("error.crud.read.list", null, LocaleContextHolder.getLocale()));
            throw new RepositoryException(e);
        }
    }

    @Override
    public List<T> getList(Specification<T> specification) {
        try {
            return repository.findAll(specification);
        } catch (Exception e){
            getLogger().error(messageSource.getMessage("error.crud.read.list", null, LocaleContextHolder.getLocale()));
            throw new RepositoryException(e);
        }
    }

    @Override
    public List<T> getList(Specification<T> specification, Sort sort) {
        try {
            return repository.findAll(specification, sort);
        } catch (Exception e){
            getLogger().error(messageSource.getMessage("error.crud.read.list", null, LocaleContextHolder.getLocale()));
            throw new RepositoryException(e);
        }
    }

    @Override
    public List<T> getList(Example<T> filter) {
        try {
            return repository.findAll(filter);
        } catch (Exception e){
            getLogger().error(messageSource.getMessage("error.crud.read.list", null, LocaleContextHolder.getLocale()));
            throw new RepositoryException(e);
        }
    }

    @Override
    public List<T> getList(Example<T> filter, Sort sort) {
        try {
            return repository.findAll(filter, sort);
        } catch (Exception e){
            getLogger().error(messageSource.getMessage("error.crud.read.list", null, LocaleContextHolder.getLocale()));
            throw new RepositoryException(e);
        }
    }

    @Override
    public Page<T> getPage(Pageable pageable) {
        try {
            return repository.findAll(pageable);
        } catch (Exception e){
            getLogger().error(messageSource.getMessage("error.crud.read.page", null, LocaleContextHolder.getLocale()));
            throw new RepositoryException(e);
        }
    }

    @Override
    public Page<T> getPage(Example<T> example, Pageable pageable) {
        try {
            return repository.findAll(example, pageable);
        } catch (Exception e){
            getLogger().error(messageSource.getMessage("error.crud.read.page", null, LocaleContextHolder.getLocale()));
            throw new RepositoryException(e);
        }
    }

    @Override
    public Page<T> getPage(Specification<T> specification, Pageable pageable) {
        try {
            return repository.findAll(specification, pageable);
        } catch (Exception e){
            getLogger().error(messageSource.getMessage("error.crud.read.page", null, LocaleContextHolder.getLocale()));
            throw new RepositoryException(e);
        }
    }

    protected MessageSource getMessageSource(){
        return messageSource;
    }

    protected JpaRepositoryImplementation<T, ID> getRepository(){
        return repository;
    }

    protected abstract Logger getLogger();


    private void init(JpaRepositoryImplementation<T, ID> repository, MessageSource messageSource){
        if (getLogger() == null || repository == null || messageSource == null) {
            throw new IllegalArgumentException("logger can't be null");
        }
    }
}
