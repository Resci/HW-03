package com.mate.service;

import java.util.List;

public interface GenericService<T, I> {
    T create(T element);

    T get(I id);

    List<T> getAll();

    T update(T element);

    boolean delete(I id);
}
