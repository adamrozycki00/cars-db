package pl.adaroz.springboot2.homework7;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.adaroz.springboot2.homework7.model.Car;
import pl.adaroz.springboot2.homework7.service.CarService;

@Component
public class Main {

    private CarService carService;

    public Main(CarService carService) {
        this.carService = carService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void test() {

        carService.saveCar("Toyota", "Auris", 2009);

        carService.findAll().stream()
                .forEach(System.out::println);
        System.out.println("----------------");

        carService.updateCar(new Car(4L, "Fiat", "Bravia", 2000));

        carService.deleteCar(5L);

        carService.findByYear(2016, 2020).stream()
                .forEach(System.out::println);

    }

}
