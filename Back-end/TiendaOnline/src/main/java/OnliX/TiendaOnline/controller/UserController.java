package OnliX.TiendaOnline.controller;

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

import OnliX.TiendaOnline.DTO.requestRegisterUser;
import OnliX.TiendaOnline.model.Users;
import OnliX.TiendaOnline.service.UserService;

@RestController
@RequestMapping("api/v1/Users")
public class UserController {
    /*
     * GET = Obtener datos o constutar
     * POST = Crear un registro
     * PUT = Actualización total
     * PATCH = Actualización parcial
     * DELETE = Eliminar
     */

     @Autowired

     private UserService UserService;

     @GetMapping("/")
     public ResponseEntity<Object> findAllUser(){
        var ListUser = UserService.findAllUSer();
        return new ResponseEntity<Object>(ListUser,HttpStatus.OK);
     }

     @GetMapping("/{id}")
     public ResponseEntity<Object> findByEntity(@PathVariable int id){
        var user = UserService.findByIdUser(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
     }

   @GetMapping("/name/{name}")
   public ResponseEntity<Object> findByName(@PathVariable String name){
   var user = UserService.findByName(name);
   return new ResponseEntity<Object>(user,HttpStatus.OK);
   }
     @DeleteMapping("/{id}")
     public ResponseEntity<Object> DeleteUser(@PathVariable int id){
        UserService.Delete(id);
        return new ResponseEntity<>("Delete Ok",HttpStatus.OK);
     }

     @PostMapping("/")
     public String postMethodName(@RequestBody Users user){
        UserService.save(user);
        return "Register Ok";
     }

     @PutMapping("/{id}")
     public String Update(@RequestBody requestRegisterUser user,@PathVariable int id){
        UserService.update(id,user);
         return "Update Ok";
     }

}
