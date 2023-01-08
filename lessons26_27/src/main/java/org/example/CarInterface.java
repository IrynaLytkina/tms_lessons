package org.example;

import java.util.List;

public interface CarInterface {
    void save(Car car);

    void delete(int id);

    List<Car> getAll();

    Car getById(int id);
}