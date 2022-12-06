package edu.genspark.week_4_assignment_1.api;

import edu.genspark.week_4_assignment_1.exceptions.NotFoundException;
import edu.genspark.week_4_assignment_1.exceptions.RepositoryException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

public abstract class AbstractBaseCRUDService<T extends IIdentifiable<ID>, ID> extends AbstractBaseReadService<T, ID> implements ICRUDService<T, ID>  {

    public AbstractBaseCRUDService(JpaRepositoryImplementation<T, ID> repository, MessageSource messageSource) {
        super(repository, messageSource);
    }

    @Transactional
    @Override
    public T save(T t) {
        try {
            return getRepository().save(t);
        } catch (Exception e){
            getLogger().error(getMessageSource().getMessage("error.crud.create.one", null, LocaleContextHolder.getLocale()));
            throw new RepositoryException(e);
        }
    }

    @Transactional
    @Override
    public List<T> save(Collection<T> list) {
       try {
            return getRepository().saveAll(list);
       } catch (Exception e){
           getLogger().error(getMessageSource().getMessage("error.crud.create.list", null, LocaleContextHolder.getLocale()));
           throw new RepositoryException(e);
       }
    }

    @Transactional
    @Override
    public T update(ID id, T t) {
        try {
            T oneById = getOneById(id);
            t.setId(oneById.getId());
            return getRepository().save(t);
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e){
            getLogger().error(getMessageSource().getMessage("error.crud.update.one", null, LocaleContextHolder.getLocale()));
            throw new RepositoryException(e);
        }
    }

    @Transactional
    @Override
    public T deleteById(ID id) {
        try {
            T read = getOneById(id);
            getRepository().deleteById(id);
            return read;
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e){
        getLogger().error(getMessageSource().getMessage("error.crud.delete.one", null, LocaleContextHolder.getLocale()));
        throw new RepositoryException(e);
    }
    }

    @Transactional
    @Override
    public List<T> deleteAllById(Collection<ID> ids) {
        List<T> founded = getRepository().findAllById(ids);

        if (ids.size() != founded.size()) {

            throw new IllegalArgumentException(
                    getMessageSource()
                            .getMessage(
                                    "error.cud.delete.illegal.found.size",
                                    new Object[]{ids.size(), founded.size()},
                                    LocaleContextHolder.getLocale()
                            )
            );
        }

        getRepository().deleteAllById(ids);

        return founded;

    }

    @Transactional
    @Override
    public void deleteAll() {
        try {
            getRepository().deleteAll();
        } catch (Exception e) {
            getLogger().error(getMessageSource().getMessage("error.crud.delete.list", null, LocaleContextHolder.getLocale()));
            throw new RepositoryException(e);
        }
    }
}
