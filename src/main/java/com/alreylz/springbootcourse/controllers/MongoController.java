package com.alreylz.springbootcourse.controllers;

import com.alreylz.springbootcourse.mongo.documents.Person;
import com.alreylz.springbootcourse.repos.MongoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class MongoController {

// instancia de MongoRepo
    @Autowired
    MongoRepo mongoRepo;

    @GetMapping("/mongo")
    public String rootTutorial() {
        return "MongoTutorial";
    }




    @PostConstruct
    public void init(){
        mongoRepo.deleteAll();
        System.out.println("[@alreylz] Initializing default data in MongoDB");
        List<Person> defaultPeople = new ArrayList<Person>();

        defaultPeople.add(new Person("Alejandro","Rey"));
        defaultPeople.add(new Person("Pedro","Picapiedra"));
        defaultPeople.add(new Person("Juana","De Arco"));
        defaultPeople.add(new Person("Napoleón","Bonaparte"));


        mongoRepo.saveAll(defaultPeople);

    }








    //Displays all people in the database.
    @RequestMapping("/mongo/html/people")
    public String displayPeople(Model model){

        List<Person> personList = mongoRepo.findAll();
        model.addAttribute("pList",personList);
        return "ShowPersonData";
    }


    @RequestMapping("mongo/insert/{name}/{surname}")
    public @ResponseBody  String insert(@PathVariable String name, @PathVariable String surname, Model m){

        Person nuPerson = new Person(name,surname);
        mongoRepo.save( nuPerson);
        return name + " "+ surname;
    }






    @RequestMapping("/mongo/rest/people")
    public @ResponseBody List<Person> showPeople(Model model){

        List<Person> personList = mongoRepo.findAll();

        return personList;
    }
















}
