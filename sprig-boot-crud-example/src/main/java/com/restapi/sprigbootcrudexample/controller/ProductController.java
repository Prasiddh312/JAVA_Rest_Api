package com.restapi.sprigbootcrudexample.controller;

import com.restapi.sprigbootcrudexample.entity.Product;
import com.restapi.sprigbootcrudexample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
//This Controller class will communicate with Service Class-For that we need to inject Service in Controller Class.
    private ProductService service;

    //Here we need to add All the Rest Endpoints which we have created in Service Class.

    /**************POST API***************/
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }

    /*************GET API*******************/

    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return service.getProducts();
    }
    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable int id){
        return service.getProductById(id);
    }

//    @GetMapping("/product/{name}")
//    public Product findProductByName(@PathVariable String name){
//        return service.getProductByName(name);
//    }
    /********PUT API**************/

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }
    /*************DELETE API****************/

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }

}

