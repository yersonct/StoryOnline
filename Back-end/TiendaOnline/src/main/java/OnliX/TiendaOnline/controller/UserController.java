package OnliX.TiendaOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import OnliX.TiendaOnline.DTO.requestRegisterUser;
import OnliX.TiendaOnline.service.UserService;

@RestController
@RequestMapping("api/V1/user")
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

     @GetMapping("/{Id}")
     public ResponseEntity<Object> findByEntity(@PathVariable int id){
        var user = UserService.findByIdUser(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
     }
     @PostMapping("/")
     public String postMethodName(@RequestBody requestRegisterUser user){
        UserService.save(user);
        return "Register Ok";
     }
}
