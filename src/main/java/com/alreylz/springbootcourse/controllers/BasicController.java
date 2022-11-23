package com.alreylz.springbootcourse.controllers;

import com.alreylz.springbootcourse.representations.Address;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador básico que demuestra el uso de spring-web para una variedad de casuísticas muy comunes en el desarrollo web.
 * <p>
 * Anotaciones principales a conocer:
 *
 * @PostConstruct
 * @RequestMapping (url, method)
 * @ResponseBody
 * @PathVariable
 * @RequestParam
 * @RequestBody </p>
 */
@Controller
public class BasicController {


    static final String basePath = "/spring-web-basic";
    List<Address> addresses = new ArrayList<Address>();


    // Equivalente a Init method en JEE
    // Aquí lo uso para mostrar datos de ejemplo
    @PostConstruct
    public void init() {

        Address addressA = new Address("A", "Calle Mayor", "Madrid", 28);
        Address addressB = new Address("B", "Paseo Reina Cristina", "Madrid", 15);
        Address addressC = new Address("C", "Avenida de la Ciudad de Barcelona", "Madrid", 2);
        Address addressD = new Address("D", "Paseo del Prado", "Madrid", 24);

        // ADD TO SAMPLE ADDRESSES LIST (SIMULATING DB)
        addresses.add(addressA);
        addresses.add(addressB);
        addresses.add(addressC);
        addresses.add(addressD);
    }


    @RequestMapping(value = basePath)
    public @ResponseBody
    String basicController() {
        return "<h1> Basic controller is responding this HTTP request </h1> " +
                "<h2> Base path is " + basePath + "</h2>";
    }


    //Ejemplos ultra-básicos de respuestas User-readable para cada uno de los métodos HTTP

    //GET
    @RequestMapping(value = basePath+"/req", method = RequestMethod.GET)
    public @ResponseBody
    String respondGET() {
        return "<h1> Ejemplo PUT </h1> ";
    }

    //POST
    @RequestMapping(value = basePath+"/req", method = RequestMethod.POST)
    public @ResponseBody
    String respondPUT() {
        return "<h1> Ejemplo POST </h1> ";
    }

    //PUT
    @RequestMapping(value = basePath+"/req", method = RequestMethod.PUT)
    public @ResponseBody
    String respondPOST() {
        return "<h1> Ejemplo PUT </h1> ";
    }


    //DELETE
    @RequestMapping(value = basePath+"/req", method = RequestMethod.DELETE)
    public @ResponseBody
    String respondDELETE() {
        return "<h1> Ejemplo DELETE </h1> ";
    }


    //PathVariable
    @RequestMapping(value = basePath+"/pathVar/{valueHere}", method = RequestMethod.GET)
    public @ResponseBody
    String pathVarExample(@PathVariable String valueHere) {
        return "<h1>" + valueHere + "</h1>";
    }

    //RequestParam : esperamos que en la petición haya un parámetro  con un nombre en específico (e.g., que viene de un formulario
    @RequestMapping(value = "basePath+/ReqParamA", method = RequestMethod.POST)
    public @ResponseBody
    String reqParamExampleA(@RequestParam String name) {
        return "<h1>" + name + "</h1>";
    }

    //Request body : se espera que un JSON completo venga en la petición y este se intentará convertir en el tipo definido como parámetro (en este caso Address)
    // En este caso vamos a devolver un Json también tal cual al recibido.
    @RequestMapping(value = basePath+"/ReqParamA", method = RequestMethod.POST)
    public @ResponseBody
    Address reqBodyParse(@RequestBody Address a) {
        return a;
    }


    @RequestMapping(value = basePath + "/addresses-html")
    public @ResponseBody
    String getAllAddressesPLAINTEXT() {

        String resp = "<h1> Lista de Addresses existentes </h1>";
        for (Address a : addresses) {
            resp += a.toString() + "<br/>";
        }
        return resp;
    }


}