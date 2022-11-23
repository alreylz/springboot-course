package com.alreylz.springbootcourse.representations;



/*
    Requisitos de un tipo/clase retornable como representación REST:
    - Constructor público sin argumentos
    - Implementa serializable
    - Getters y Setters
 */


import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

// @ XmlRootElement indica que Spring tiene que tratar de convertir un objeto del tipo anotado a XML si se requiere.
@XmlRootElement
public class Computer implements Serializable {

    int id;
    String brand;
    String model;
    float price;

    public Computer() {
    }

    ;

    public Computer(int id, String brand, String model, float price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }


    //Getters y setters:

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
