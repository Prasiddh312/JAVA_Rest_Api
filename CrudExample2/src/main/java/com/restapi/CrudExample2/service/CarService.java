package com.restapi.CrudExample2.service;

import com.restapi.CrudExample2.entity.Cars;

import java.util.List;
import java.util.Optional;

public interface CarService {  // To Achieve Abstraction.

    public Cars saveCar(Cars car);
    public List<Cars> saveCars(List<Cars> cars);
    public List<Cars> getCars( );
    public Optional<Cars> getCarById(int id);
    public Cars getCarByName(String name);
    public String deleteCar(int id);
    public Cars updateCar(Cars car);

}
