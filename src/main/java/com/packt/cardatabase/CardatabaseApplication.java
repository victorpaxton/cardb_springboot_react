package com.packt.cardatabase;

import com.packt.cardatabase.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

    private final CarRepository carRepository;

    private final OwnerRepository ownerRepository;

    private final AppUserRepository urepository;

    public CardatabaseApplication(CarRepository carRepository, OwnerRepository ownerRepository, AppUserRepository appUserRepository, AppUserRepository urepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
        this.urepository = urepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CardatabaseApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        // Add your own code here
//		Owner owner1 = new Owner("John", "Johnson");
//		Owner owner2 = new Owner("Mary", "Robinson");
//		ownerRepository.saveAll(Arrays.asList(owner1, owner2));
//
//		carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", "Convertible", 2017, 59000, owner1));
//		carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", "Electric", 2014, 29000, owner2));
//		carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", "Hybrid", 2018, 39000, owner2));

//		for (Car car : carRepository.findAll()) {
//			logger.info("Model: {}, Brand: {}", car.getModel(), car.getBrand());
//		}

//        // Username: user, password: user
//        urepository.save(new AppUser("user", "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue","USER"));
//        // Username: admin, password: admin
//        urepository.save(new AppUser("admin", "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));
    }
}
