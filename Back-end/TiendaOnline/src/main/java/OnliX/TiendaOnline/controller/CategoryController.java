package OnliX.TiendaOnline.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import OnliX.TiendaOnline.DTO.requestRegisterCategory;
import OnliX.TiendaOnline.model.category;
import OnliX.TiendaOnline.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/V1/category")
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
    @PostMapping("/")
    public String postMethodName(@RequestBody requestRegisterCategory category) {
        //TODO: process POST request
        categoryService.save(category);
        return "Register Ok";
    }
    
    
}
