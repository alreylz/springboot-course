package com.alreylz.springbootcourse.repos;

import com.alreylz.springbootcourse.mongo.documents.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MongoRepo extends CrudRepository<Person, String> {

    List<Person> findAll();
    List<Person> findPersonByName(String name);
    List<Person> findByNameAndSurname(String name, String surname  );

}
