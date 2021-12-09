package com.alreylz.springbootcourse.controllers;

import com.alreylz.springbootcourse.mysql.entities.Person;
import com.alreylz.springbootcourse.repos.PersonMysqlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MysqlController {

    @Autowired
     PersonMysqlRepo mysqlRepo;

    @RequestMapping("/people")
    public String showUser(Model model){

        System.out.println("PEOPLE TO BE STH");
        List<Person> personList = mysqlRepo.findAll();
        model.addAttribute("pList", personList);
        return "ShowPersonData";
    }


}
