package com.alreylz.springbootcourse.controllers;

import com.alreylz.springbootcourse.mysql.entities.Computer;
import com.alreylz.springbootcourse.repos.ComputerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Clase Controller que además de exponer endpoints para crear, leer, actualizar y eliminar registros 'Computer',
 * hace uso del contenedor ResponseEntity para retornar códigos de error informativos al cliente del microservicio
 * (es una copia 'mejorada' de ComputerRestController
 */
@Controller
public class ComputerRestControllerWResponseEntity {

    static final String basePath = "/restfulRespEntity";

    // DAO (Data Access Object) / CRUD
    @Autowired
    ComputerDAO cDao;

    // GET - Extraer info de bbdd (listar todos los ordenadores)
    @RequestMapping(value = basePath + "/computers", method = RequestMethod.GET)
    ResponseEntity<List<Computer>> getAllComputers() {
        List<Computer> computerList = null;

        try {
            computerList = cDao.findAll();

            if (computerList.isEmpty() || computerList == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


        return new ResponseEntity<>(computerList, HttpStatus.OK);
    }


    // GET (by id) - Extraer info de bbdd (listar un ordenador por id)
    @RequestMapping(value = basePath + "/computers/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<Computer> getComputer(@PathVariable String id) {
        Computer fromDbComputer = null;
        try {
            Long longId = Long.parseLong(id);
            fromDbComputer = cDao.findById(longId).orElse(null);
            if (fromDbComputer == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(fromDbComputer, HttpStatus.OK);
    }


    // POST - Inserción de info en BBDD
    // @RequestBody permite directamente parsear un JSON que viene en el cuerpo de la petición a un tipo de datos de Java
    // -> @RequestParam por contra, requeriría extraer uno a uno los parámetros del JSON que viene
    @RequestMapping(value = basePath + "/computers", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Computer> insertComputer(@RequestBody Computer c) {

        if (c != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            cDao.save(c);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(c, HttpStatus.OK);

    }

    // PUT - Actualización de info en BBDD
    @RequestMapping(value = basePath + "/computers/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<Computer> updateComputer(@PathVariable String id, @RequestBody Computer toUpdate) {
        Computer updatedComputer = null;
        try {
            //Convertimos el id al tipo de datos del id de base de datos (Long integer)
            Long intId = Long.parseLong(id);
            // Buscamos por id y en caso de no encontrar nada, obtenemos null
            Computer fromDBComputer = cDao.findById(intId).orElse(null);

            if (fromDBComputer != null) {
                cDao.save(toUpdate);
                updatedComputer = toUpdate;

            } else {
                return new ResponseEntity<>(updatedComputer, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(updatedComputer, HttpStatus.OK);
    }

    // DELETE - Eliminación de info en BBDD
    @RequestMapping(value = basePath + "/computers/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity<Computer> deleteOne(@PathVariable String id) {
        Computer toDeleteComputer = null;
        try {
            //Convertimos el id al tipo de datos del id de base de datos (Long integer)
            Long intId = Long.parseLong(id);
            // Buscamos por id y en caso de no encontrar nada, obtenemos null
            toDeleteComputer = cDao.findById(intId).orElse(null);
            if (toDeleteComputer == null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


            cDao.delete(toDeleteComputer);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(toDeleteComputer, HttpStatus.OK);
    }


}

