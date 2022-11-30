package com.alreylz.springbootcourse.mongo.documents;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Base64;


@Document(collection = "myCollection")
public class Person implements Serializable {


    @Id
    private String id;
    private String name;
    private String surname;

    //Empty Constructor
    public Person() {
    }

    ;

    @PersistenceConstructor // Tells Spring to use this constructor whenever new documents are to be created
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    //Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


}
