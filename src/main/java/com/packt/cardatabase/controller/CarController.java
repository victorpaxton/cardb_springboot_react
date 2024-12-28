package com.packt.cardatabase.controller;

import com.packt.cardatabase.domain.CarRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
}
