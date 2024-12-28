package com.packt.cardatabase.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {

    @PreAuthorize("hasRole('USER')")
    List<Car> findByBrand(@Param("brand") String brand);

    @PreAuthorize("hasRole('ADMIN')")
    List<Car> findByColor(@Param("color") String color);

    List<Car> findByModelYear(int modelYear);

    List<Car> findByBrandAndModel(String brand, String model);

    List<Car> findByBrandAndColor(String brand, String color);

    List<Car> findByBrandOrderByModelYearAsc(String brand);

    @Query("select c from Car c where c.brand like %?1")
    List<Car> findByBrandEndsWith(String brand);
}
