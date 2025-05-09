package com.sena.ModelSegurity.Service;
import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ModelSegurity.DTOs.requestRegisterPerson;
import com.sena.ModelSegurity.Interfaces.IPerson;
import com.sena.ModelSegurity.Model.Person;
@Service
public class PersonService {
     /*
     * @Autowired = Incluye la conexion de la interface
     */

     @Autowired
     private IPerson personData;
     public List<Person> findAllPersons(){
        return personData.findAll();
     }
     public Optional<Person> findByIdPerson(int id){
        return personData.findById(id);
     }

     public void save(Person person){
        personData.save(person);
     }

     public void update(int id, requestRegisterPerson personUpdate){
        var person = findByIdPerson(id);
        if(person.isPresent()){
            person.get().setNamePerson(personUpdate.getNamePerson());
            person.get().setLastName(personUpdate.getLastName());
            person.get().setEmail(personUpdate.getEmail());
            person.get().setPhone(personUpdate.getPhone());
            personData.save(person.get());
        }
     }

     public void delete(int id){
        var person = findByIdPerson(id);
        if(person.isPresent()){
            personData.deleteById(id);
        }
     }
}
