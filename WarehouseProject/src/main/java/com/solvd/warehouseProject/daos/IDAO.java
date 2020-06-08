package com.solvd.warehouseProject.daos;

import java.util.List;

public interface IDAO<T> {
    T get(Long id);
    List<T> getAll();
    void insert(T t);
    void update(T t, Long id);
    void delete(Long id);
}
