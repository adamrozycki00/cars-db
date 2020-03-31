package pl.adaroz.springboot2.homework7.dao;

import pl.adaroz.springboot2.homework7.model.Car;

import java.util.List;

public interface CarDao {

    void saveCar();

    List<Car> findAll();

    void updateCar(Car car);

    void deleteCar(Car car);

    List<Car> findByYear(int from, int to);

}
