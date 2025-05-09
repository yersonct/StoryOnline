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

import com.sena.ModelSegurity.DTOs.requestRegisterRol;
import com.sena.ModelSegurity.Model.Rol;
import com.sena.ModelSegurity.Service.RolService;

@RestController
@RequestMapping("api/v1/Rol")
public class RolController {
     /*
     * GET = Obtener datos o constutar
     * POST = Crear un registro
     * PUT = Actualización total
     * PATCH = Actualización parcial
     * DELETE = Eliminar
     */

     @Autowired
     private RolService rolService;
     @GetMapping("/")
     public ResponseEntity<Object>findAllRol(){
         var ListRol = rolService.findAllRol();
         return new ResponseEntity<Object>(ListRol,HttpStatus.OK);
     }
     @GetMapping("/{Id}")
     public ResponseEntity<Object>finByEntityId(@PathVariable int Id){
         var rol = rolService.findByIdRol(Id);
         return new ResponseEntity<Object>(rol,HttpStatus.OK);
     }
     @DeleteMapping("/{Id}")
     public ResponseEntity<Object>deleteRol(@PathVariable int Id){
         rolService.delete(Id);
         return new ResponseEntity<Object>("Delete Ok",HttpStatus.OK);
     }
     @PostMapping("/")
     public String postMethodName(@RequestBody Rol rol){
         rolService.save(rol);
         return "Register Ok";
     }
     @PutMapping("/{id}")
     public String update(@RequestBody requestRegisterRol rol, @PathVariable int id){
         rolService.update(id,rol);
         return "Update Ok";
     }
}
