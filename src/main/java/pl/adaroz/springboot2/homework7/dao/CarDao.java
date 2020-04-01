package pl.adaroz.springboot2.homework7.dao;

import org.springframework.stereotype.Component;
import pl.adaroz.springboot2.homework7.model.Car;

import java.util.List;

@Component
public interface CarDao {

    public void saveCar(String make, String model, int year);

    List<Car> findAll();

    void updateCar(Car car);

    void deleteCar(Car car);

    List<Car> findByYear(int from, int to);

}
