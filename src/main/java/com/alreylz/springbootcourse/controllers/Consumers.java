package com.alreylz.springbootcourse.controllers;

import com.alreylz.springbootcourse.representations.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Controlador web que muestra cómo consumir peticiones desde Javascript (en el front) y desde el backend con Spring y restTemplate
 */
@Controller
public class Consumers {

    static final String basePath = "/microservice-consumers";

    @RequestMapping(value = basePath)
    public String consumersHome() {
        return "MsConsumersHome";
    }

    @RequestMapping(value = basePath + "/js")
    public String javascriptConsumer() {
        return "JSConsumer";
    }


    @Autowired
    RestTemplate restTemplate;


    @RequestMapping(value = "/uso-thymeleaf")
    public String ejemploThymleaf(Model model) {



//PAsamos info a la vista usando el parámetro model
        model.addAttribute("name", "Alejandro");
        //Devolvemos el nombre de la vista (que ha de estar en /resource/templates)
        return "HOLA";

    }


//
//    @RequestMapping(value = basePath + "/thymeleaf")
//    public String thymeleafConsumer(Model model) {

//
//        //Model es el objeto que permite hacer el equivalente a request.setAttribute()
//        model.addAttribute("singleAddress", anAddress);
//        model.addAttribute("listAddresses", allAddresses);
//
//        return "ThymeleafConsumer";
//    }


}
