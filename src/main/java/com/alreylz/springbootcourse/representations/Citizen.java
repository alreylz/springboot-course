package com.alreylz.springbootcourse.representations;


import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Citizen implements Serializable {

    private String name;
    private String surname;
    private String dni;
    private Address address;

    public Citizen() {
    };

    public Citizen(String name, String surname, String dni, Address address) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.address = address;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dni='" + dni + '\'' +
                ", address=" + address;
    }
}
