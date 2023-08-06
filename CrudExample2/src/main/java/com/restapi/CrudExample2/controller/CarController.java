package com.restapi.CrudExample2.controller;

import com.restapi.CrudExample2.entity.Cars;
import com.restapi.CrudExample2.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {
    @Autowired
    private CarServiceImpl service;
/*********POST API***********************/

@PostMapping("/addCar")
public Cars addCar(@RequestBody Cars car){
return service.saveCar(car);
}
@PostMapping("/addCars")
public List<Cars> addCars(@RequestBody List<Cars> car){
    return service.saveCars(car);
}
/*********GET API**************/
@GetMapping("/allCars")
public List<Cars> findAllCars(){
    return service.getCars();
}

@GetMapping("/car/{id}")
public Optional<Cars> findCarById(@PathVariable int id){
    return service.getCarById(id);

}
@GetMapping("/carByName/{name}")
public Cars findCarByName(@PathVariable String name){
    return service.getCarByName(name);
}
/***********PUT API**************/

@PutMapping("/updateCar")
public Cars updateCar(@RequestBody Cars car){
    return service.saveCar(car);
}
/***************DELETE API*********/

@DeleteMapping("/delete/{id}")
public String deleteCar(@PathVariable int id){
    return service.deleteCar(id);
}

}
