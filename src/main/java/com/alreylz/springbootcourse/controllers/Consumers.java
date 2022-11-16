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


    @RequestMapping(value = basePath + "/thymeleaf")
    public String thymeleafConsumer(Model model) {

        System.out.println("Petición a thymeleaf");
        //Petición a microservicio REST (obtengo un objeto)
        Address anAddress = restTemplate.getForObject("http://localhost:8080/spring-web-example/address/{id}", Address.class, "A");
        //Petición a microservicio REST (obtengo un array)
        Address[] allAddresses = restTemplate.getForObject("http://localhost:8080/spring-web-example/addresses", Address[].class);

        //Model es el objeto que permite hacer el equivalente a request.setAttribute()
        model.addAttribute("singleAddress", anAddress);
        model.addAttribute("listAddresses", allAddresses);

        return "ThymeleafConsumer";
    }


}
