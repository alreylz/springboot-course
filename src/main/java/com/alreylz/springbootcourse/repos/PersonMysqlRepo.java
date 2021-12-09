package com.alreylz.springbootcourse.repos;

import com.alreylz.springbootcourse.mysql.entities.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonMysqlRepo extends CrudRepository<Person, Long> {

    List<Person> findAll();

}
