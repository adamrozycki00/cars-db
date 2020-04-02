package pl.adaroz.springboot2.homework7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.adaroz.springboot2.homework7.model.Car;
import pl.adaroz.springboot2.homework7.service.CarService;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("")
    public String getAllCars(Model model) {
        List<Car> allCars = carService.findAll();
        model.addAttribute("allCars", allCars);
        return "/cars";
    }

    @GetMapping("/delete")
    public String deleteCar(@RequestParam long id) {
        carService.deleteCar(id);
        return "redirect:/cars";
    }

}
