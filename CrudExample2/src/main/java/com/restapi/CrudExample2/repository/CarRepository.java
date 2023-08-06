package com.restapi.CrudExample2.repository;

import com.restapi.CrudExample2.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Cars,Integer> {
    Cars findByName(String name);
}
