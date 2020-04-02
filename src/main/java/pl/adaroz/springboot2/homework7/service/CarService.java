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

    public void saveCar(String make, String model, int year) {
        carDao.saveCar(make, model, year);
    }

    public List<Car> findAll() {
        return carDao.findAll();
    }

    public void updateCar(Car car) {
        carDao.updateCar(car);
    }

    public void deleteCar(long id) {
        carDao.deleteCar(id);
    }

    public List<Car> findByYear(int from, int to) {
        return carDao.findByYear(from, to);
    }

}
