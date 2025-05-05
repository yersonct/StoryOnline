package OnliX.TiendaOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import OnliX.TiendaOnline.DTO.requestRegisterDiscount;
import OnliX.TiendaOnline.DTO.requestRegisterUser;
import OnliX.TiendaOnline.service.DiscountService;
import OnliX.TiendaOnline.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import OnliX.TiendaOnline.model.discount;
@SuppressWarnings("unused")
@RestController
@RequestMapping("api/v1/discount")
public class DiscountController {
    /*
     * GET = Obtener datos o constutar
     * POST = Crear un registro
     * PUT = Actualización total
     * PATCH = Actualización parcial
     * DELETE = Eliminar
     */
    @Autowired
    private DiscountService DiscountService;
    @GetMapping("/")
    public ResponseEntity<Object>findAllDiscount(){
        var ListDiscount = DiscountService.findAllDiscounts();
        return new ResponseEntity<Object>(ListDiscount,HttpStatus.OK);
    }
    @GetMapping("/{Id}")
    public  ResponseEntity<Object> findByEntity(@PathVariable int id){
        var discount = DiscountService.findByIdDiscounts(id);
        return new ResponseEntity<>(discount,HttpStatus.OK);
    }
    // @GetMapping("/name/{name}")
    // public ResponseEntity<Object> findByName(@PathVariable String name){
    //     var discount = DiscountService.findByName(name);
    //     return new ResponseEntity<Object>(discount,HttpStatus.OK);
    // }

    @DeleteMapping("/{id}")
     public ResponseEntity<Object> DeleteDiscount(@PathVariable int id){
        DiscountService.Delete(id);
        return new ResponseEntity<>("Delete Ok",HttpStatus.OK);
     }
    @PostMapping("/")
    public String postMethodName(@RequestBody discount discount){
        DiscountService.save(discount);
        return "Register OK";
    }
    
     @PutMapping("/{id}")
     public String Update(@RequestBody requestRegisterDiscount discount,@PathVariable int id){
        DiscountService.update(id,discount);
         return "Update Ok";
     }
}
