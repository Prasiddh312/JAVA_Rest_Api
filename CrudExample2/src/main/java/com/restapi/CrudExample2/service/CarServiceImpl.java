package com.restapi.CrudExample2.service;

import com.restapi.CrudExample2.entity.Cars;
import com.restapi.CrudExample2.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository repository;

    /*********POST METHOD*******/
    public Cars saveCar(Cars car){
        car.price=car.price/85; //Price In Dollar


        return  repository.save(car);
    }
    public List<Cars> saveCars(List<Cars> cars){
        for (Cars c:cars
             ) {
            c.price=c.price/85;  //price in dollar
        }
        return repository.saveAll(cars);
    }

/***************GET METHOD*******/
@Override
public List<Cars> getCars( ){
    return repository.findAll();
}

public Optional <Cars> getCarById(int id){
    if(repository.findById(id).isPresent()){
        return repository.findById(id);
    }
    else
        return null;

}
public Cars getCarByName(String name){
    return repository.findByName(name);
}

/*************************DELETE***************/

public String deleteCar(int id){
     repository.deleteById(id);
     return "Car Removed!!"+id;

}
/****************PUT**********************/

public Cars updateCar(Cars car){
Cars existingCar=repository.findById(car.getId()).orElse(null);//Returns Optional
existingCar.setName(car.getName());
existingCar.setColor(car.getName());
existingCar.setPrice(car.getPrice());
return repository.save(existingCar);
}



}
