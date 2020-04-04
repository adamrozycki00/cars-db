package pl.adaroz.springboot2.homework7.dao;

import pl.adaroz.springboot2.homework7.model.Car;

import java.util.List;

public interface CarDao {

    void saveCar(String make, String model, String colour, Long year);

    void saveCar(Car newCar);

    List<Car> findAll();

    void updateCar(Car car);

    void deleteCar(Long id);

    List<Car> findByYear(Long from, Long to);

    Long getMinYear();

    Long getMaxYear();

}
