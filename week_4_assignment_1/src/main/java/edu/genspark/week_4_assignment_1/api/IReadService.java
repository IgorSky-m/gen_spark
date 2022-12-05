package edu.genspark.week_4_assignment_1.api;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface IReadService<T, ID>{

    T getOneById(ID uuid);
    Optional<T> findOneById(ID uuid);

    List<T> getAll();
    List<T> getList(Specification<T> specification);
    List<T> getList(Specification<T> specification, Sort sort);

    List<T> getList(Example<T> filter);
    List<T> getList(Example<T> filter, Sort sort);

    Page<T> getPage(Pageable pageable);
    Page<T> getPage(Example<T> example, Pageable pageable);
    Page<T> getPage(Specification<T> specification, Pageable pageable);




}
