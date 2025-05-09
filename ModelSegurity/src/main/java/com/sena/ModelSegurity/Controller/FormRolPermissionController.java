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

import com.sena.ModelSegurity.DTOs.requestRegisterFormRolPermission;
import com.sena.ModelSegurity.Model.FormRolPermission;
import com.sena.ModelSegurity.Service.FormRolPermissionService;

@RestController
@RequestMapping("api/v1/FormRolPermission")
public class FormRolPermissionController {
     /*
     * GET = Obtener datos o constutar
     * POST = Crear un registro
     * PUT = Actualización total
     * PATCH = Actualización parcial
     * DELETE = Eliminar
     */
     @Autowired
     private FormRolPermissionService formRolPermissionService;
     @GetMapping("/")
     public ResponseEntity<Object>findAllFormRolPermission(){
         var ListFormRolPermission = formRolPermissionService.findAllFormRolPermissions();
         return new ResponseEntity<Object>(ListFormRolPermission,HttpStatus.OK);
     }
     @GetMapping("/{Id}")
     public ResponseEntity<Object>finByEntityId(@PathVariable int Id){
         var formRolPermission = formRolPermissionService.findByIdFormRolPermission(Id);
         return new ResponseEntity<Object>(formRolPermission,HttpStatus.OK);
     }
     @DeleteMapping("/{Id}")
     public ResponseEntity<Object>deleteFormRolPermission(@PathVariable int Id){
         formRolPermissionService.delete(Id);
         return new ResponseEntity<Object>("Delete Ok",HttpStatus.OK);
     }
     @PostMapping("/")
     public String postMethodName(@RequestBody FormRolPermission formRolPermission){
         formRolPermissionService.save(formRolPermission);
         return "Register Ok";
     }
     @PutMapping("/{id}")
     public String update(@RequestBody requestRegisterFormRolPermission formRolPermission, @PathVariable int id){
         formRolPermissionService.update(id,formRolPermission);
         return "Update Ok";
     }
   
}
