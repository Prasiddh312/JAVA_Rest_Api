package com.restapi.sprigbootcrudexample.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PRODUCT_TBL")

public class Product { //Model Class

    @Id
    @GeneratedValue //to generate id Automatically
    private int id;
    private String name;

    private int quantity;

    private double price;
}
