package OnliX.TiendaOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import OnliX.TiendaOnline.DTO.requestRegisterDetailCart;
import OnliX.TiendaOnline.DTO.requestRegisterUser;
import OnliX.TiendaOnline.model.detailCart;
import OnliX.TiendaOnline.service.DetailCartService;
import OnliX.TiendaOnline.service.DiscountService;
import OnliX.TiendaOnline.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@SuppressWarnings("unused")
@RestController
@RequestMapping("api/v1/detailCart")
public class DetailCartController {
    /*
     * GET = Obtener datos o constutar
     * POST = Crear un registro
     * PUT = Actualización total
     * PATCH = Actualización parcial
     * DELETE = Eliminar
     */
    @Autowired
    private DetailCartService detailCartService;
    @GetMapping("/")
    public ResponseEntity<Object> findAllDetailCart(){
        var ListDetailCart= detailCartService.findAllDetailCart();
        return new ResponseEntity<Object>(ListDetailCart,HttpStatus.OK);
    }  
    @GetMapping("/{Id}")
    public ResponseEntity<Object> findByEntity(@PathVariable int id){
        var detailCart = detailCartService.findByIdDetailCart(id);
        return new ResponseEntity<>(detailCart,HttpStatus.OK);
    }
    // @GetMapping("/name/{name}")
    // public ResponseEntity<Object> findByName(@PathVariable String name){
    //     var detailCart = detailCartService.findByName(name);
    //     return new ResponseEntity<Object>(detailCart,HttpStatus.OK);
    // }

    @DeleteMapping("/{id}")
     public ResponseEntity<Object> DeleteDetailCart(@PathVariable int id){
        detailCartService.Delete(id);
        return new ResponseEntity<>("Delete Ok",HttpStatus.OK);
     }
    @PostMapping("/")
    public String postMethodName(@RequestBody detailCart detailCart){
        detailCartService.save(detailCart);
        return "Register OK";
    }
   
      @PutMapping("/{id}")
     public String Update(@RequestBody requestRegisterDetailCart detailCart,@PathVariable int id){
        detailCartService.update(id,detailCart);
         return "Update Ok";
     }
    
}
