package com.sena.ModelSegurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.ModelSegurity.DTOs.requestRegisterUsers;
import com.sena.ModelSegurity.Model.Users;
import com.sena.ModelSegurity.Service.UsersService;

@RestController
@RequestMapping("api/v1/Users")
public class UsersController {
     /*
     * GET = Obtener datos o constutar
     * POST = Crear un registro
     * PUT = Actualización total
     * PATCH = Actualización parcial
     * DELETE = Eliminar
     */
     @Autowired
     private UsersService usersService;
     @GetMapping("/")
     public ResponseEntity<Object>findAllUsers(){
         var ListUsers = usersService.findAllUsers();
         return new ResponseEntity<Object>(ListUsers,HttpStatus.OK);
     }
     @GetMapping("/{Id}")
     public ResponseEntity<Object>finByEntityId(@PathVariable int Id){
         var users = usersService.findByIdUsers(Id);
         return new ResponseEntity<Object>(users,HttpStatus.OK);
     }
     @DeleteMapping("/{Id}")
     public ResponseEntity<Object>deleteUsers(@PathVariable int Id){
         usersService.delete(Id);
         return new ResponseEntity<Object>("Delete Ok",HttpStatus.OK);
     }
     @PostMapping("/")
     public String postMethodName(@RequestBody Users users){
         usersService.save(users);
         return "Register Ok";
     }
     @PutMapping("/{id}")
     public String update(@RequestBody requestRegisterUsers users, @PathVariable int id){
         usersService.update(id,users);
         return "Update Ok";
     }
}
