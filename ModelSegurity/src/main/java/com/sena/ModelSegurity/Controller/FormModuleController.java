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

import com.sena.ModelSegurity.DTOs.requestRegisterFormModule;
import com.sena.ModelSegurity.Model.FormModule;
import com.sena.ModelSegurity.Service.FormModuleService;

@RestController
@RequestMapping("api/v1/FormModule")
public class FormModuleController {
     /*
     * GET = Obtener datos o constutar
     * POST = Crear un registro
     * PUT = Actualización total
     * PATCH = Actualización parcial
     * DELETE = Eliminar
     */
     @Autowired
     private FormModuleService formModuleService;
     @GetMapping("/")
     public ResponseEntity<Object>findAllFormModules(){
         var ListFormModule = formModuleService.findAllFormModules();
         return new ResponseEntity<Object>(ListFormModule,HttpStatus.OK);
     }
     @GetMapping("/{Id}")
     public ResponseEntity<Object>finByEntityId(@PathVariable int Id){
         var formModule = formModuleService.findByIdFormModule(Id);
         return new ResponseEntity<Object>(formModule,HttpStatus.OK);
     }
     @DeleteMapping("/{Id}")
     public ResponseEntity<Object>deleteFormModule(@PathVariable int Id){
         formModuleService.delete(Id);
         return new ResponseEntity<Object>("Delete Ok",HttpStatus.OK);
     }
     @PostMapping("/")
     public String postMethodName(@RequestBody FormModule formModule){
         formModuleService.save(formModule);
         return "Register Ok";
     }
     @PutMapping("/{id}")
     public String update(@RequestBody requestRegisterFormModule formModule, @PathVariable int id){
         formModuleService.update(id,formModule);
         return "Update Ok";
     }
     
}
