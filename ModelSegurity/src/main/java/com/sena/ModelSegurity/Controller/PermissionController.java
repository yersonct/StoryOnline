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

import com.sena.ModelSegurity.DTOs.requestRegisterPermission;
import com.sena.ModelSegurity.Model.Permission;
import com.sena.ModelSegurity.Service.PermissionService;

@RestController
@RequestMapping("api/v1/Permission")
public class PermissionController {
     /*
     * GET = Obtener datos o constutar
     * POST = Crear un registro
     * PUT = Actualización total
     * PATCH = Actualización parcial
     * DELETE = Eliminar
     */
     @Autowired
     private PermissionService permissionService;
     @GetMapping("/")
     public ResponseEntity<Object>findAllPermission(){
         var ListPermission = permissionService.findAllPermission();
         return new ResponseEntity<Object>(ListPermission,HttpStatus.OK);
     }
     @GetMapping("/{Id}")
     public ResponseEntity<Object>finByEntityId(@PathVariable int Id){
         var permission = permissionService.findByIdPermission(Id);
         return new ResponseEntity<Object>(permission,HttpStatus.OK);
     }
     @DeleteMapping("/{Id}")
     public ResponseEntity<Object>deletePermission(@PathVariable int Id){
         permissionService.delete(Id);
         return new ResponseEntity<Object>("Delete Ok",HttpStatus.OK);
     }
     @PostMapping("/")
     public String postMethodName(@RequestBody Permission permission){
         permissionService.save(permission);
         return "Register Ok";
     }
     @PutMapping("/{id}")
     public String update(@RequestBody requestRegisterPermission permission, @PathVariable int id){
         permissionService.update(id,permission);
         return "Update Ok";
     }
}
