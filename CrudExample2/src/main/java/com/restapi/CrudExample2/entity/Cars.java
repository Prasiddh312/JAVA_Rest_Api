package com.restapi.CrudExample2.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Cars_Tbl")
public class Cars {//POJO or Model Class
    @Id
    @GeneratedValue
    @Column(name="Car_id")
    public int id;
    @Column(name="Car_name")
    public String name;

    public String color;
    @Column(name="price_in_$")
    public double price;

}
