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

import OnliX.TiendaOnline.DTO.requestRegisterOrder;
import OnliX.TiendaOnline.model.order;
import OnliX.TiendaOnline.service.OrderService;



@RestController
@RequestMapping("api/V1/order")
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
        return new ResponseEntity<>(ListOrder,HttpStatus.OK);
    } 
    @GetMapping("/{Id}")
    public ResponseEntity<Object> findByEntity(@PathVariable int id) {
        var order = orderService.findByIdOrder(id);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }
    @PostMapping("/")
    public String postMethodName(@RequestBody requestRegisterOrder order){
        orderService.save(order);
        return "Register Ok";
    }
    
    
}
