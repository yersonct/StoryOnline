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

import OnliX.TiendaOnline.DTO.requestRegisterOrder;
import OnliX.TiendaOnline.DTO.requestRegisterUser;
import OnliX.TiendaOnline.model.Orders;
import OnliX.TiendaOnline.service.OrderService;
import OnliX.TiendaOnline.service.UserService;



@SuppressWarnings("unused")
@RestController
@RequestMapping("api/v1/Orders")
public class OrderController {
    /*
     * GET = Obtener datos o constutar
     * POST = Crear un registro
     * PUT = Actualización total
     * PATCH = Actualización parcial
     * DELETE = Eliminar
     */
    @Autowired
    private OrderService orderService;
    @GetMapping("/")
    public ResponseEntity<Object> findAllOrder(){
        var ListOrder = orderService.findAllOrder();
        return new ResponseEntity<Object>(ListOrder,HttpStatus.OK);
    } 
    @GetMapping("/{Id}")
    public ResponseEntity<Object> findByEntity(@PathVariable int id) {
        var order = orderService.findByIdOrder(id);
        return new ResponseEntity<Object>(order,HttpStatus.OK);
    }
    // @GetMapping("/name/{name}")
    // public ResponseEntity<Object> findByName(@PathVariable String name) {
    //     var order = orderService.findByName(name);
    //     return new ResponseEntity<>(order,HttpStatus.OK);
    // }
        @DeleteMapping("/{id}")
     public ResponseEntity<Object> Deleteorder(@PathVariable int id){
        orderService.Delete(id);
        return new ResponseEntity<>("Delete Ok",HttpStatus.OK);
     }
    @PostMapping("/")
    public String postMethodName(@RequestBody Orders order){
        orderService.save(order);
        return "Register Ok";
    }
     @PutMapping("/{id}")
     public String Update(@RequestBody requestRegisterOrder Order,@PathVariable int id){
        orderService.update(id,Order);
         return "Update Ok";
     }
    
}
