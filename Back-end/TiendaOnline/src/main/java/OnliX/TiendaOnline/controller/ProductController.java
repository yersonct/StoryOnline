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

import OnliX.TiendaOnline.DTO.requestRegisterProduct;
import OnliX.TiendaOnline.DTO.requestRegisterUser;
import OnliX.TiendaOnline.model.product;
import OnliX.TiendaOnline.service.ProductService;
import OnliX.TiendaOnline.service.ReviewService;
import OnliX.TiendaOnline.service.UserService;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    /*
     * GET = Obtener datos o constutar
     * POST = Crear un registro
     * PUT = Actualización total
     * PATCH = Actualización parcial
     * DELETE = Eliminar
     */
    @Autowired
    private ProductService ProductService;
    @GetMapping("/")
    public ResponseEntity<Object> findAllProduct(){
        var ListProduct = ProductService.findAllProduct();
        return new ResponseEntity<Object>(ListProduct,HttpStatus.OK);
    }
    @GetMapping("/{Id}")
    public  ResponseEntity<Object> findByEntity(@PathVariable int id){
        var product = ProductService.findByIdProduct(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Object> findByName(@PathVariable String name){
        var product = ProductService.findByName(name);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
       @DeleteMapping("/{id}")
     public ResponseEntity<Object> DeleteProduct(@PathVariable int id){
        ProductService.Delete(id);
        return new ResponseEntity<>("Delete Ok",HttpStatus.OK);
     }
    @PostMapping("/")
    public String postMethodName(@RequestBody product product){
        ProductService.save(product);
        return "Register OK";
    }
    @PutMapping("/{id}")
     public String Update(@RequestBody requestRegisterProduct product,@PathVariable int id){
        ProductService.update(id,product);
         return "Update Ok";
     }
}
