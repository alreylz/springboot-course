package com.alreylz.springbootcourse.controllers;

import com.alreylz.springbootcourse.mysql.entities.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class SpringAPIConsumer {


    @Autowired
    RestTemplate restTemplate;


    //PETICION TIPO GET
    @RequestMapping(value = "/api-consumer/get", method = RequestMethod.GET)
    public @ResponseBody
    String getAllComputersByCallingApi() {

        Computer[] arrayC =
                restTemplate.getForObject("http://localhost:8081/restful/computers", Computer[].class);

        System.out.println(arrayC[0].getBrand());

        Computer onec = arrayC[0];
        return " <p> " + onec.getBrand() + "," + onec.getModel() + "," + onec.getPrice() + "</p>";
    }

    //PETICION TIPO POST
    @RequestMapping(value = "/api-consumer/post", method = RequestMethod.GET)
    public @ResponseBody
    String postAComputer() {


        Computer toInsertC = new Computer("myBrand", "model1231", 898);


        Computer resultC =
                restTemplate.postForObject("http://localhost:8081/restful/computers", toInsertC, Computer.class);


        return "<h1> Ordenador insertado por microservicio: </h1> <p> " + resultC.getId() + "," + resultC.getBrand() + "," + resultC.getModel() + "," + resultC.getPrice() + "</p>";
    }


    //PETICION TIPO PUT
    @RequestMapping(value = "/api-consumer/put", method = RequestMethod.GET)
    public @ResponseBody
    String updateAComputer() {


        Computer newCompDate = new Computer("updatedBrand", "updatedModel", 777);


        restTemplate.put("http://localhost:8081/restful/computers/{id}", newCompDate,  "4");


        return "<h1> Ordenador actualizado por microservicio: </h1> <p> " + newCompDate.getId() + "," + newCompDate.getBrand() + "," + newCompDate.getModel() + "," + newCompDate.getPrice() + "</p>";
    }


    //PETICION TIPO DELETE
    @RequestMapping(value = "/api-consumer/delete", method = RequestMethod.GET)
    public @ResponseBody
    String deleteAComputer() {
        restTemplate.delete("http://localhost:8081/restful/computers/{id}", "4");


        return "<h1> Ordenador eliminado correctamente por microservicio: </h1>";
    }


}
