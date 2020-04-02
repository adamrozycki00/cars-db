package pl.adaroz.springboot2.homework7.dao;

import org.springframework.stereotype.Component;
import pl.adaroz.springboot2.homework7.model.Car;

import java.util.List;

@Component
public interface CarDao {

    public void saveCar(String make, String model, Long year);

    public void saveCar(Car newCar);

    List<Car> findAll();

    void updateCar(Car car);

    void deleteCar(Long id);

    List<Car> findByYear(Long from, Long to);

}
