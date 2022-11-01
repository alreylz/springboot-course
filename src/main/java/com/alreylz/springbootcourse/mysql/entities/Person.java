package com.alreylz.springbootcourse.mysql.entities;


/* Be careful with the imports */
import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.io.Serializable;

/* For base64 conversion */
import java.util.Base64;

@Entity
@Table(name="Person")
public class Person implements Serializable {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generation strategy IDENTITY means don't repeat IDs just like that.
    private Long personId;


    private String name;
    private String surname;
    @Lob
    private byte[] img;



    public Person(){}

    @PersistenceConstructor
    public Person(String name, String surname, byte[] img) {
        this.name = name;
        this.surname = surname;
        this.img = img;
    }

    public Long getIdPerson() {
        return personId;
    }

    public void setIdPerson(Long idPerson) {
        this.personId = idPerson;
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

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }



    public String base64Img(){
        return new String(Base64.getEncoder().encode(img));
    }


}
