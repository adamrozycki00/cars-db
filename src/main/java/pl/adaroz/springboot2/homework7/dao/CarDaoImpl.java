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
    public void saveCar(String make, String model, int year) {
        Car car = new Car(0, make, model, year);
        String sql = "insert into cars (make, model, year) values (?, ?, ?)";
        jdbcTemplate.update(sql, car.getMake(), car.getModel(), car.getYear());
    }

    @Override
    public List<Car> findAll() {
        List<Car> carList = new ArrayList<>();
        String sql = "select * from cars";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach(car -> carList.add(new Car(
                Long.parseLong(String.valueOf(car.get("id"))),
                String.valueOf(car.get("make")),
                String.valueOf(car.get("model")),
                Integer.parseInt(String.valueOf(car.get("year"))))));
        return carList;
    }

    @Override
    public void updateCar(Car car) {
        String sql = "update cars " +
                "set make=?, model=?, year=? " +
                "where id=?";
        jdbcTemplate.update(sql, car.getMake(), car.getModel(), car.getYear(), car.getId());
    }

    @Override
    public void deleteCar(long id) {
        String sql = "delete from cars " +
                "where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Car> findByYear(int from, int to) {
        List<Car> carList = new ArrayList<>();
        String sql = "select * from cars " +
                "where year between ? and ?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, from, to);
        maps.stream().forEach(car -> carList.add(new Car(
                Long.parseLong(String.valueOf(car.get("id"))),
                String.valueOf(car.get("make")),
                String.valueOf(car.get("model")),
                Integer.parseInt(String.valueOf(car.get("year"))))));
        return carList;
    }

}
