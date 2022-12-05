package edu.genspark.week_4_assignment_1.api;

import java.util.Collection;
import java.util.List;

public interface ICUDService<T, ID> {

    T save(T t);
    List<T> save(Collection<T> list);

    T  update(ID id, T t);

    T deleteById(ID id);
    List<T> deleteAllById(Collection<ID> ids);
}
