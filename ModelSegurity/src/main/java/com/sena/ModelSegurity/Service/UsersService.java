package com.sena.ModelSegurity.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ModelSegurity.DTOs.requestRegisterUsers;
import com.sena.ModelSegurity.Interfaces.IUsers;
import com.sena.ModelSegurity.Model.Users;

@Service
public class UsersService {
      /*
     * @Autowired = Incluye la conexion de la interface
     */

     @Autowired
     private IUsers usersData;
     public List<Users> findAllUsers(){
        return usersData.findAll();
     }
     public Optional<Users> findByIdUsers(int id){
        return usersData.findById(id);
     }
     public void save(Users users){
        usersData.save(users);
     }
     public void update(int id, requestRegisterUsers usersUpdate){
        var users = findByIdUsers(id);
        if(users.isPresent()){
            users.get().setNamePerson(usersUpdate.getNamePerson());
            users.get().setPassWord(usersUpdate.getPassWord());
            
            usersData.save(users.get());
        }
     }
     public void delete(int id){
        var users = findByIdUsers(id);
        if(users.isPresent()){
            usersData.deleteById(id);
        }
     }
}
