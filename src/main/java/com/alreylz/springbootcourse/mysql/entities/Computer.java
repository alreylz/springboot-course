package com.alreylz.springbootcourse.mysql.entities;



/*
    Requisitos de un tipo/clase retornable como representación REST:
    - Constructor público sin argumentos
    - Implementa serializable
    - Getters y Setters
 */


import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Entity
@Table(name = "computers")
// @ XmlRootElement indica que Spring tiene que tratar de convertir un objeto del tipo anotado a XML si se requiere.
@XmlRootElement
public class Computer implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String brand;
    String model;
    float price;

    public Computer() {
    }

    @PersistenceConstructor
    public Computer(String brand, String model, float price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }


    public Computer(Long id, String brand, String model, float price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }


    //Getters y setters:

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
