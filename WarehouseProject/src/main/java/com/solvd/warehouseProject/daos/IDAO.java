package com.solvd.warehouseProject.daos;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDAO<T> {
    T get(@Param("id") Long id);
    List<T> getAll();
    void insert(T t);
    void update(T t, @Param("id") Long id);
    void delete(@Param("id") Long id);
}
