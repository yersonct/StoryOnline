package com.sena.ModelSegurity.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.ModelSegurity.DTOs.requestRegisterPerson;
import com.sena.ModelSegurity.Model.Person;
import com.sena.ModelSegurity.Service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/v1/Person")
public class PersonController {
     /*
     * GET = Obtener datos o constutar
     * POST = Crear un registro
     * PUT = Actualización total
     * PATCH = Actualización parcial
     * DELETE = Eliminar
     */
    @Autowired
    private PersonService personService;
    @GetMapping("/")
    public ResponseEntity<Object>findAllPersons(){
        var ListPerson = personService.findAllPersons();
        return new ResponseEntity<Object>(ListPerson,HttpStatus.OK);
    }
    @GetMapping("/{Id}")
    public ResponseEntity<Object>finByEntityId(@PathVariable int Id){
        var person = personService.findByIdPerson(Id);
        return new ResponseEntity<Object>(person,HttpStatus.OK);
    }
    @DeleteMapping("/{Id}")
    public ResponseEntity<Object>deletePerson(@PathVariable int Id){
        personService.delete(Id);
        return new ResponseEntity<Object>("Delete Ok",HttpStatus.OK);
    }

    @PostMapping("/")
    public String postMethodName(@RequestBody Person person){
        personService.save(person);
        return "Register Ok";
    }

    @PutMapping("/{id}")
    public String update(@RequestBody requestRegisterPerson person, @PathVariable int id){
        personService.update(id,person);
        return "Update Ok";
    }
}
