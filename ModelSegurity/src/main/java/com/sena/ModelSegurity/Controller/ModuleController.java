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

import com.sena.ModelSegurity.DTOs.requestRegisterModule;
import com.sena.ModelSegurity.Service.ModuleService;

@RestController
@RequestMapping("api/v1/Module")
public class ModuleController {
     /*
     * GET = Obtener datos o constutar
     * POST = Crear un registro
     * PUT = Actualización total
     * PATCH = Actualización parcial
     * DELETE = Eliminar
     */
     @Autowired
     private ModuleService moduleService;
     @GetMapping("/")
     public ResponseEntity<Object>findAllModule(){
         var ListModule = moduleService.findAllModule();
         return new ResponseEntity<Object>(ListModule,HttpStatus.OK);
     }
     @GetMapping("/{Id}")
     public ResponseEntity<Object>finByEntityId(@PathVariable int Id){
         var module = moduleService.findByIdModule(Id);
         return new ResponseEntity<Object>(module,HttpStatus.OK);
     }
     @DeleteMapping("/{Id}")
     public ResponseEntity<Object>deleteModule(@PathVariable int Id){
         moduleService.delete(Id);
         return new ResponseEntity<Object>("Delete Ok",HttpStatus.OK);
     }
     @PostMapping("/")
     public String postMethodName(@RequestBody Module module){
         moduleService.save(module);
         return "Register Ok";
     }
     @PutMapping("/{id}")
     public String update(@RequestBody requestRegisterModule module, @PathVariable int id){
         moduleService.update(id,module);
         return "Update Ok";
     }
}
