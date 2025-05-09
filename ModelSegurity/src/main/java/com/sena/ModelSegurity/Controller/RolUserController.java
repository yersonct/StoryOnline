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

import com.sena.ModelSegurity.DTOs.requestRegisterRolUser;
import com.sena.ModelSegurity.Model.RolUser;
import com.sena.ModelSegurity.Service.RolUserService;

@RestController
@RequestMapping("api/v1/RolUser")
public class RolUserController {
     /*
     * GET = Obtener datos o constutar
     * POST = Crear un registro
     * PUT = Actualización total
     * PATCH = Actualización parcial
     * DELETE = Eliminar
     */

     @Autowired
     private RolUserService rolUserService;
     @GetMapping("/")
     public ResponseEntity<Object>findAllRolUser(){
         var ListRolUser = rolUserService.findAllRolUser();
         return new ResponseEntity<Object>(ListRolUser,HttpStatus.OK);
     }
     @GetMapping("/{Id}")
     public ResponseEntity<Object>finByEntityId(@PathVariable int Id){
         var rolUser = rolUserService.findByIdRolUser(Id);
         return new ResponseEntity<Object>(rolUser,HttpStatus.OK);
     }
     @DeleteMapping("/{Id}")
     public ResponseEntity<Object>deleteRolUser(@PathVariable int Id){
         rolUserService.delete(Id);
         return new ResponseEntity<Object>("Delete Ok",HttpStatus.OK);
     }
     @PostMapping("/")
     public String postMethodName(@RequestBody RolUser rolUser){
         rolUserService.save(rolUser);
         return "Register Ok";
     }
     @PutMapping("/{id}")
     public String update(@RequestBody requestRegisterRolUser rolUser, @PathVariable int id){
         rolUserService.update(id,rolUser);
         return "Update Ok";
     }
}
