package com.moskalev.controller;

import java.util.List;

public interface CrudController<T> {

    public T read(String email);

    public List<T> readAll();

    public void create(T t);

    public void delete(T t);

    public void update(T t, T newT);
}
