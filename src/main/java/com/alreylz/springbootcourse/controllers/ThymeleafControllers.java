package com.alreylz.springbootcourse.controllers;

import com.alreylz.springbootcourse.mysql.entities.Person;
import com.alreylz.springbootcourse.repos.PersonMysqlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public class ThymeleafControllers {

    @Autowired
    PersonMysqlRepo mysqlRepo;


    // Esto permite extraer el puerto en ejecución y usarlo en el código.
    @Value("#{environment['server.port']}")
    int port;


    static final String basePath = "/thymeleaf-examples";


    // Muestra una vista de thymeleaf que muestra en una tabla todos los elementos 'Person' de la base de datos Mysql
    @RequestMapping("show-people")
    public String showPeopleInDBWithThymeleaf(Model model) {
        List<Person> personList = mysqlRepo.findAll();
        model.addAttribute("pList", personList);
        return "ShowPersonData";
    }

    // Muestra un formulario de creación de registro 'Person'
    @GetMapping("new-person-form")
    public String showCreatePersonForm(Model model) {
        model.addAttribute("port", port);
        return "PersonCreateForm";
    }


    @RequestMapping(value = "insert-person", method = RequestMethod.POST)
    public @ResponseBody
    String createPerson(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("file") MultipartFile file) {
        try {
            Person nuPerson = new Person(name, surname, file.getBytes());
            mysqlRepo.save(nuPerson);
            System.out.println("SAVED NU PERSON");
        } catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
        return "INSERCIÓN DE PERSONA OK";
    }


}
