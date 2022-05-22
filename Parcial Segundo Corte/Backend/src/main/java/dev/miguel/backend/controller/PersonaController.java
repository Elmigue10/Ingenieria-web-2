package dev.miguel.backend.controller;

import dev.miguel.backend.model.Persona;
import dev.miguel.backend.service.PersonaService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PersonaController {

    private PersonaService personaService;

    private static final Logger logger = LogManager.getLogger("PersonaController");

    @GetMapping("/personas")
    public ResponseEntity<List<Persona>> list(){
        logger.info("Listing people...");
        return new ResponseEntity<>(personaService.list(), HttpStatus.OK);
    }

    @GetMapping("/personas/{id}")
    public ResponseEntity<Persona> getPersonById(@PathVariable int id){
        logger.info("Listing person by id: " + id);
        return new ResponseEntity(personaService.getPersonById(id), HttpStatus.OK);
    }

    @PostMapping("/personas")
    public ResponseEntity save(@RequestBody Persona persona){
        logger.info("Saving person: " + persona);
        personaService.save(persona);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/personas")
    public ResponseEntity update(@RequestBody Persona persona){
        logger.info("Updating person: " + persona);
        personaService.update(persona);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/personas/{id}")
    public ResponseEntity deleteById(@PathVariable int id){
        logger.info("Deleting person: " + id);
        personaService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
