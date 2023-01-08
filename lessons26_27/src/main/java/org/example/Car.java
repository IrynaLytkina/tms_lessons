package org.example;

import java.util.Objects;

public class Car {
    private int id;
    private String model;
    private String year;
    private int cost;

    public Car() {
    }

    public Car(int id, String model, String year, int cost) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", model='" + model + '\'' + ", year='" + year + '\'' + ", cost=" + cost + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && cost == car.cost && Objects.equals(model, car.model) && Objects.equals(year, car.year);
    }

}