package pl.adaroz.springboot2.homework7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adaroz.springboot2.homework7.dao.CarDao;
import pl.adaroz.springboot2.homework7.model.Car;

import java.util.List;

@Service
public class CarService {

    private CarDao carDao;

    @Autowired
    public CarService(CarDao carDao) {
        this.carDao = carDao;
    }

    public void saveCar(String make, String model, String colour, Long year) {
        carDao.saveCar(make, model, colour, year);
    }

    public void saveCar(Car newCar) {
        carDao.saveCar(newCar);
    }

    public List<Car> findAll() {
        return carDao.findAll();
    }

    public void updateCar(Car car) {
        carDao.updateCar(car);
    }

    public void deleteCar(Long id) {
        carDao.deleteCar(id);
    }

    public List<Car> findByYear(Long from, Long to) {
        return carDao.findByYear(from, to);
    }

}
