package pl.adaroz.springboot2.homework7.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.adaroz.springboot2.homework7.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CarDaoImpl implements CarDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveCar(String make, String model, String colour, Long year) {
        Car car = new Car(0L, make, model, colour, year);
        String sql = "insert into cars (make, model, colour, year) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, car.getMake(), car.getModel(), car.getColour(), car.getYear());
    }

    @Override
    public void saveCar(Car newCar) {
        String sql = "insert into cars (make, model, colour, year) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, newCar.getMake(), newCar.getModel(), newCar.getColour(), newCar.getYear());
    }

    @Override
    public List<Car> findAll() {
        List<Car> carList = new ArrayList<>();
        String sql = "select * from cars";
        List<Map<String, Object>> carMaps = jdbcTemplate.queryForList(sql);
        addCarToList(carList, carMaps);
        return carList;
    }

    @Override
    public void updateCar(Car car) {
        String sql = "update cars " +
                "set make=?, model=?, colour=?, year=? " +
                "where id=?";
        jdbcTemplate.update(sql, car.getMake(), car.getModel(), car.getColour(), car.getYear(), car.getId());
    }

    @Override
    public void deleteCar(Long id) {
        String sql = "delete from cars " +
                "where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Car> findByYear(Long from, Long to) {
        List<Car> carList = new ArrayList<>();
        String sql = "select * from cars " +
                "where year between ? and ?";
        List<Map<String, Object>> carMaps = jdbcTemplate.queryForList(sql, from, to);
        addCarToList(carList, carMaps);
        return carList;
    }

    private void addCarToList(List<Car> carList, List<Map<String, Object>> carMaps) {
        carMaps.stream().forEach(car -> carList.add(new Car(
                Long.parseLong(String.valueOf(car.get("id"))),
                String.valueOf(car.get("make")),
                String.valueOf(car.get("model")),
                String.valueOf(car.get("colour")),
                Long.parseLong(String.valueOf(car.get("year"))))));
    }

}
