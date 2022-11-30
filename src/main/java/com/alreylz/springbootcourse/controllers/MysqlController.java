package com.alreylz.springbootcourse.controllers;

import com.alreylz.springbootcourse.mysql.entities.Person;
import com.alreylz.springbootcourse.repos.PersonMysqlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class MysqlController {

    @Autowired
     PersonMysqlRepo mysqlRepo;






    @RequestMapping("mysql/people")
    public String showPeopleInDB(Model model){

        System.out.println("PEOPLE TO BE STH");
        List<Person> personList = mysqlRepo.findAll();
        model.addAttribute("pList", personList);
        return "ShowPersonData";
    }

    @RequestMapping(value = "mysql/people",method = RequestMethod.POST)
    public @ResponseBody String createPerson(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("file") MultipartFile file){
        try{
           Person nuPerson =  new Person(name,surname, file.getBytes());
            mysqlRepo.save(nuPerson);
            System.out.println("SAVED NU PERSON");
        } catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
        return " TODO OK";
    }


    @GetMapping("mysql/new/person")
    public String showCreatePersonForm(Model model ){

        model.addAttribute("rootWebPath","http://localhost:8080/");
        return "CreatePerson";
    }



}
