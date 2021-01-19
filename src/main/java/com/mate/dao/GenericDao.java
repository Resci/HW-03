package com.mate.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T, I> {
    T create(T car);

    Optional<T> get(I id);

    List<T> getAll();

    T update(T car);

    boolean delete(I id);
}
