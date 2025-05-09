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

import com.sena.ModelSegurity.DTOs.requestRegisterForm;
import com.sena.ModelSegurity.Model.Form;
import com.sena.ModelSegurity.Service.FormService;

@RestController
@RequestMapping("api/v1/Form")
public class FormController {
     /*
     * GET = Obtener datos o constutar
     * POST = Crear un registro
     * PUT = Actualización total
     * PATCH = Actualización parcial
     * DELETE = Eliminar
     */
     @Autowired
     private FormService formService;
     @GetMapping("/")
     public ResponseEntity<Object>findAllForms(){
         var ListForm = formService.findAllForms();
         return new ResponseEntity<Object>(ListForm,HttpStatus.OK);
     }
     @GetMapping("/{Id}")
     public ResponseEntity<Object>finByEntityId(@PathVariable int Id){
         var form = formService.findByIdForm(Id);
         return new ResponseEntity<Object>(form,HttpStatus.OK);
     }
     @DeleteMapping("/{Id}")
     public ResponseEntity<Object>deleteForm(@PathVariable int Id){
         formService.delete(Id);
         return new ResponseEntity<Object>("Delete Ok",HttpStatus.OK);
     }
     @PostMapping("/")
     public String postMethodName(@RequestBody Form form){
         formService.save(form);
         return "Register Ok";
     }
     @PutMapping("/{id}")
     public String update(@RequestBody requestRegisterForm form, @PathVariable int id){
         formService.update(id,form);
         return "Update Ok";
     }
}
