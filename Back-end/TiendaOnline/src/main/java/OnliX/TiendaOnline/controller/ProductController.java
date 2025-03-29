package OnliX.TiendaOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import OnliX.TiendaOnline.service.ProductService;

@RestController
@RequestMapping("api/V1/product")
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
        return new ResponseEntity<>(ListProduct,HttpStatus.OK);
    }
    @GetMapping("/{Id}")
    public  ResponseEntity<Object> findByEntity(@PathVariable int id){
        var product = ProductService.findByIdProduct(id);
        return new ResponseEntity<>(product,HttpStatus.Ok);
    }
    @PostMapping("/")
    public String postMethodName(@RequestBody requestRegisterProduct product){
        ProductData.save(product);
        return "Register OK";
    }
}
