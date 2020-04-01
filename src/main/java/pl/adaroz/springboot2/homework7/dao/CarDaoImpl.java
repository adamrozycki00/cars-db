package pl.adaroz.springboot2.homework7.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.adaroz.springboot2.homework7.model.Car;

import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveCar(String make, String model, int year) {
        Car car = new Car(0,make, model, year);
        String sql = "insert into cars values (?, ?, ?)";
        jdbcTemplate.update(sql, car.getMake(), car.getModel(), car.getYear());
    }

    @Override
    public List<Car> findAll() {
        return null;
    }

    @Override
    public void updateCar(Car car) {

    }

    @Override
    public void deleteCar(Car car) {

    }

    @Override
    public List<Car> findByYear(int from, int to) {
        return null;
    }

}
