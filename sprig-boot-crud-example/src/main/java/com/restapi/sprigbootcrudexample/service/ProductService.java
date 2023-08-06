package com.restapi.sprigbootcrudexample.service;

import com.restapi.sprigbootcrudexample.entity.Product;
import com.restapi.sprigbootcrudexample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired //this product service will communicate with repository-for that we need ti inject Repository in Service Class.
    private ProductRepository repository;
    /******POST METHOD********/
    //POST -to save single product in DB

    public Product saveProduct(Product product){

        if(product.getPrice()<15){
            product.setPrice(15);
        }
        product.setName(product.getName().trim());// To remove Spaces at beginning and at end in a String.


        return repository.save(product);
    }

    //POST-to save List of products

    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    /******GET Method**************/
    //GET-TO fetch values as list from DB

    public List<Product> getProducts(){
        return repository.findAll();
    }
    //GET-to fetch single value from DB by ID

    public Product getProductById(int id){
        return repository.findById(id).orElse(null);//it will return Optional.
    }

    //GET-to fetch a value from DB By name
    public Product getProductByName(String name){
        return repository.findByName(name); //for this we need to create findByName method in repositry.
    }
    /**********DELETE METHOD********/

    //DELETE-to delete a product by ID

    public String deleteProduct(int id){
        repository.deleteById(id);
        return "Product Removed!!"+id;
    }
    /**************UPDATE METHOD OR PUT****************/

    public Product updateProduct(Product product){
        Product existingProduct=repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);

        //NOTE-Because there is no Update method in Spring Data JPA all we need to play with SAVE method.
    }

}
