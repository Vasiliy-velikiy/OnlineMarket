package com.moskalev.service;

import java.util.List;

public interface CrudService<T> {

    public List<T> readAll();

    public T read(String t);

    public void create(T t);

    public void delete(T t);

    public void update(T t, T newT);
}
