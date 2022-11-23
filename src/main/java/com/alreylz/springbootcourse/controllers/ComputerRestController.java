package com.alreylz.springbootcourse.controllers;

import com.alreylz.springbootcourse.mysql.entities.Computer;
import com.alreylz.springbootcourse.repos.ComputerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RESTFUL API para operaciones CRUD sobre la entidad Computer === tabla 'computers'
 * Utiliza un DAO que se crea a partir de CrudRepository<Computer,Long>
 */
@Controller
public class ComputerRestController {

    static final String basePath = "/restful";

    // DAO (Data Access Object) / CRUD
    @Autowired
    ComputerDAO cDao;

    // GET - Extraer info de bbdd (listar todos los ordenadores)
    @RequestMapping(value = basePath + "/computers", method = RequestMethod.GET)
    public @ResponseBody
    List<Computer> getAllComputers() {
        List<Computer> computerList = null;
        try {
            computerList = cDao.findAll();

        } catch (Exception e) {
            System.out.println(e);
        }
        return computerList;
    }


    // GET (by id) - Extraer info de bbdd (listar un ordenador por id)
    @RequestMapping(value = basePath + "/computers/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Computer getComputer(@PathVariable String id) {
        Computer fromDbComputer = null;
        try {
            Long longId = Long.parseLong(id);
            fromDbComputer = cDao.findById(longId).orElse(null);

        } catch (Exception e) {
            System.out.println(e);
        }
        return fromDbComputer;
    }


    // POST - Inserción de info en BBDD
    // @RequestBody permite directamente parsear un JSON que viene en el cuerpo de la petición a un tipo de datos de Java
    // -> @RequestParam por contra, requeriría extraer uno a uno los parámetros del JSON que viene
    @RequestMapping(value = basePath + "/computers", method = RequestMethod.POST)
    public @ResponseBody
    Computer insertComputer(@RequestBody Computer c) {
        try {
            cDao.save(c);
        } catch (Exception e) {
            System.out.println(e);
        }
        return c;
    }

    // PUT - Actualización de info en BBDD
    @RequestMapping(value = basePath + "/computers/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    Computer updateComputer(@PathVariable String id, @RequestBody Computer toUpdate) {
        Computer updatedComputer = null;
        try {
            //Convertimos el id al tipo de datos del id de base de datos (Long integer)
            Long intId = Long.parseLong(id);
            // Buscamos por id y en caso de no encontrar nada, obtenemos null
            Computer fromDBComputer = cDao.findById(intId).orElse(null);

            if (fromDBComputer != null) {
                cDao.save(toUpdate);
                updatedComputer = toUpdate;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return updatedComputer;
    }

    // DELETE - Eliminación de info en BBDD
    @RequestMapping(value = basePath + "/computers/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Computer deleteOne(@PathVariable String id) {
        Computer toDeleteComputer = null;
        try {
            //Convertimos el id al tipo de datos del id de base de datos (Long integer)
            Long intId = Long.parseLong(id);
            // Buscamos por id y en caso de no encontrar nada, obtenemos null
            toDeleteComputer = cDao.findById(intId).orElse(null);
            cDao.delete(toDeleteComputer);
        } catch (Exception e) {
            System.out.println(e);
        }
        return toDeleteComputer;
    }


}
