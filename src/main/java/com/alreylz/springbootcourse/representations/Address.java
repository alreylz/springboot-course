package com.alreylz.springbootcourse.representations;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


/*
    Requisitos de un tipo/clase retornable como representación REST:
    - Implementa serializable
    - Getters y Setters
 */

@XmlRootElement
public class Address implements Serializable {

    private String id;
    private String street;
    private String city;
    private int number;

    public Address(String id,String street, String city, int number) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.number = number;
    }



    public String getId(){
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return
                "street='" + street + '\'' +
                        ", city='" + city + '\'' +
                        ", number=" + number
                ;
    }

}
