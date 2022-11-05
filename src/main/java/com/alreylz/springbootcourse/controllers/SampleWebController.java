package com.alreylz.springbootcourse.controllers;


import com.alreylz.springbootcourse.mongo.documents.Person;
import com.alreylz.springbootcourse.representations.Address;
import com.alreylz.springbootcourse.representations.Citizen;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SampleWebController {


    static final String basePath = "/spring-web-example";


    /* SAMPLE DATA INITIALIZATION */

    List<Citizen> citizens = new ArrayList<Citizen>();
    List<Address> addresses = new ArrayList<Address>();


    // Equivalente a Init method en JEE
    // Aquí lo uso para mostrar datos de ejemplo
    @PostConstruct
    public void init() {
        System.out.println("[@alreylz] Initializing default data in MongoDB");


        Address addressA = new Address("A", "Calle Atocha", "Madrid", 28);
        Address addressB = new Address("B", "Paseo Reina Cristina", "Madrid", 15);
        Address addressC = new Address("C", "Avenida de la Ciudad de Barcelona", "Madrid", 2);
        Address addressD = new Address("D", "Paseo del Prado", "Madrid", 24);

        Citizen citizenA = new Citizen("Peter", "Parker", "01147831Q", addressA);
        Citizen citizenB = new Citizen("Shurmanito", "Diesinueve", "93463279L", addressB);
        Citizen citizenC = new Citizen("Aitor", "Tilla", "28741600H", addressC);
        Citizen citizenD = new Citizen("Aurelio", "Platino", "61610231Q", addressD);

        // ADD TO SAMPLE ADDRESSES LIST (SIMULATING DB)
        addresses.add(addressA);
        addresses.add(addressB);
        addresses.add(addressC);
        addresses.add(addressD);

        // ADD TO SAMPLE CITIZEN LIST (SIMULATING DB)
        citizens.add(citizenA);
        citizens.add(citizenB);
        citizens.add(citizenC);
        citizens.add(citizenD);


    }


    /*
    ----------------------------------
      ENDPOINTS
    ----------------------------------
     */
    @RequestMapping(value = basePath)
    public @ResponseBody
    String sampleWebController() {
        return "Hi there ";
    }

    /**
     * REST Endpoint que obtiene todas las representaciones Address disponibles
     *
     * @return JSON/XML con la lista de representaciones Address
     */
    @RequestMapping(value = basePath + "/addresses", method = RequestMethod.GET)
    public @ResponseBody
    List<Address> getAllAddressesREST() {
        return addresses;
    }


    @RequestMapping(value = basePath + "/addresses", method = RequestMethod.POST)
    public @ResponseBody
    Address insertAddressREST(@RequestParam String id, @RequestParam String street, @RequestParam String city, @RequestParam int number) {
        Address nuAddress = new Address(id, street, city, number);
        // Simulamos inserción en BBDD
        addresses.add(nuAddress);
        return nuAddress;
    }


    //UPDATE - PUT
    @RequestMapping(value = basePath + "/address/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    Address updateAddressREST(@PathVariable String id, @RequestParam String street, @RequestParam String city, @RequestParam int number) {

        Address found = getAddressById(id);
        found.setStreet(street);
        found.setCity(city);
        found.setNumber(number);
        return found;

    }

    // DELETE -> DELETE
    @RequestMapping(value = basePath + "/address/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Address deleteAddress(@PathVariable String id) {

        Address deleted = null;
        int index = 0;

        for (Address a : addresses) {
            if (a.getId().equals(id)) {
                deleted = a;
            }
            index++;
        }
        addresses.remove(index);
        return deleted;
    }


    /***
     * REST Endpoint que permite devolver una representación de un Address dado un id como parte de la URL (e.g., (addresses/A) -> devuelve el Address con el id 'A')
     * @param id cadena de texto identificando el recurso
     * @return JSON/XML asociado a un Address con el id dado
     */
    @RequestMapping(value = basePath + "/addresses/{id}")
    public @ResponseBody
    Address getAddressById(@PathVariable String id) {
        Address result = null;
        for (Address a : addresses) {
            if (a.getId().equals(id))
                result = a;
        }
        return result;
    }

    /***
     * REST Endpoint que permite buscar Addresses que cumplen con unos criterios dados por queryString (.../?key=value)
     * @param fCity la ciudad por la que filtrar
     * @param fNumber el número por el que filtrar
     * @return JSON/XML con los elementos Address que cumplen un filtro u otro
     */
    @RequestMapping(value = basePath + "/addresses/search")
    public @ResponseBody
    List<Address> getFilteredAddressesREST(@RequestParam(value = "city", required = false) String fCity, @RequestParam(value = "number", required = false) String fNumber) {

        List<Address> results = new ArrayList<Address>();
        //Simulamos query
        for (Address a : addresses) {

            if (fCity != null && fCity.equalsIgnoreCase(a.getCity()) || Integer.parseInt(fNumber) == a.getNumber()) {
                results.add(a);
            }
        }

        return results;
    }


    @RequestMapping(value = basePath + "/addresses-html")
    public @ResponseBody
    String getAllAddressesPLAINTEXT() {


        String resp = "<h1> Lista de direcciones existentes </h1>";
        for (Address a : addresses) {
            resp += a.toString() + "<br/>";
        }

        return resp;
    }


}
