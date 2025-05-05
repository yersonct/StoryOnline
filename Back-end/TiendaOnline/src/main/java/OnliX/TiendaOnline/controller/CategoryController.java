package OnliX.TiendaOnline.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import OnliX.TiendaOnline.DTO.requestRegisterCategory;
import OnliX.TiendaOnline.DTO.requestRegisterUser;
import OnliX.TiendaOnline.model.category;
import OnliX.TiendaOnline.service.CategoryService;
import OnliX.TiendaOnline.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@SuppressWarnings("unused")
@RestController
@RequestMapping("api/v1/category")
public class CategoryController {
     /*
     * GET = Obtener datos o constutar
     * POST = Crear un registro
     * PUT = Actualización total
     * PATCH = Actualización parcial
     * DELETE = Eliminar
     */
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/")
    public ResponseEntity<Object> findAllCategories(){
        var ListCategory = categoryService.findAllCategories();
        return new ResponseEntity<Object>(ListCategory,HttpStatus.OK);
    }
    @GetMapping("/{Id}")
    public ResponseEntity<Object>findByEntity(@PathVariable int id){
        var category = categoryService.findByCategory(id);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Object> findByName(@PathVariable String name){
        var category = categoryService.findByName(name);
        return new ResponseEntity<Object>(category,HttpStatus.OK);
    }

     @DeleteMapping("/{id}")
     public ResponseEntity<Object> DeleteCategory(@PathVariable int id){
        categoryService.Delete(id);
        return new ResponseEntity<>("Delete Ok",HttpStatus.OK);
     }
    @PostMapping("/")
    public String postMethodName(@RequestBody category category) {
        //TODO: process POST request
        categoryService.save(category);
        return "Register Ok";
    }
    
     @PutMapping("/{id}")
     public String Update(@RequestBody requestRegisterCategory categoria,@PathVariable int id){
        categoryService.update(id,categoria);
         return "Update Ok";
     }
}
