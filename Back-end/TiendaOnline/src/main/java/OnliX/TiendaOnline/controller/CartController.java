package OnliX.TiendaOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import OnliX.TiendaOnline.DTO.requestRegisterCart;
import OnliX.TiendaOnline.model.cart;
import OnliX.TiendaOnline.service.CartService;

@SuppressWarnings("unused")
@RestController
@RequestMapping("api/V1/cart")
public class CartController {
     /*
     * GET = Obtener datos o constutar
     * POST = Crear un registro
     * PUT = Actualización total
     * PATCH = Actualización parcial
     * DELETE = Eliminar
     */
    @Autowired
    private CartService CartService;
    @GetMapping("/")
    public ResponseEntity<Object>findAllCart(){
        var ListCart = CartService.findAllCart();
        return new ResponseEntity<Object>(ListCart,HttpStatus.OK);
    }
    @GetMapping("/{Id}")
    public ResponseEntity<Object> findByEntity(@PathVariable int id){
        var cart = CartService.findByIdCart(id);
        return new ResponseEntity<>(cart,HttpStatus.OK);
    }
    @PostMapping("/")
    public String postMethodName(@RequestBody requestRegisterCart cart){
        CartService.save(cart);
        return "Register OK";
    }
}
