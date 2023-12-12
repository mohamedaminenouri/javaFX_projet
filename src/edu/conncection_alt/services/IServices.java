package edu.conncection_alt.services;

import java.util.List;

public interface IServices<T> {
    void addEntity(T t);
    List<T> getAllData();

}
