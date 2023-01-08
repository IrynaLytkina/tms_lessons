package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarService implements CarInterface{
    StartupServlet servlet = new StartupServlet();

    @Override
    public void save(Car car) {
        try {
            Connection connection = servlet.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car (id, model, year, cost) values(?, ?, ?, ?)");
            preparedStatement.setInt(1, car.getId());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setString(3, car.getYear());
            preparedStatement.setInt(4, car.getCost());
            preparedStatement.execute();
        } catch (Exception exc) {
            throw new RuntimeException("SQL ADD FAILED");
        }
    }

    @Override
    public void delete(int id) {
        try {
            Connection connection = servlet.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from car where id = ?");
            preparedStatement.setLong(1, id);

            preparedStatement.execute();
        } catch (Exception exc) {
            throw new RuntimeException("SQL DELETE FAILED");
        }
    }

    @Override
    public List<Car> getAll() {
        try {
            Connection connection = servlet.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from car");
            return get(resultSet);
        } catch (Exception exc) {
            throw new RuntimeException("SQL EXCEPTION");
        }
    }

    @Override
    public Car getById(int id) {
        try {
            Connection connection = servlet.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from car where id=?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            return (Car) get(resultSet);
        } catch (Exception exc) {
            throw new RuntimeException("SQL EXCEPTION");
        }
    }

    private List<Car> get(ResultSet resultSet) {

        List<Car> cars = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String model = resultSet.getString("model");
                String year = resultSet.getString("year");
                int cost = resultSet.getInt("cost");
                Car car = new Car(id, model, year, cost);
                cars.add(car);
            }
        } catch (Exception exc) {
            throw new RuntimeException("SQL EXCEPTION");
        }
        return cars;
    }
}