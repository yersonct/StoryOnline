package OnliX.TiendaOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import OnliX.TiendaOnline.DTO.requestRegisterOrderDetail;
import OnliX.TiendaOnline.service.orderDatailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/V1/orderDetail")
public class OrderDetailController {
    /*
     * GET = Obtener datos o constutar
     * POST = Crear un registro
     * PUT = Actualización total
     * PATCH = Actualización parcial
     * DELETE = Eliminar
     */
    @Autowired
    private orderDatailService orderDetailService;
    @GetMapping("/")
    public ResponseEntity<Object> findAllOrderDetails(){

    var ListOrderDetail = orderDetailService.findAllOrderDetails();
    return new ResponseEntity<Object>(ListOrderDetail,HttpStatus.OK);
    }
    @GetMapping("/{Id}")
    public ResponseEntity<Object> findByEntity(@PathVariable int id){
        var orderDetail = orderDetailService.findByIdOrderDetail(id);
        return new ResponseEntity<>(orderDetail,HttpStatus.OK);
    }
    @PostMapping("/")
    public String postMethodName(@RequestBody requestRegisterOrderDetail orderDetail) {
        //TODO: process POST request
        orderDetailService.save(orderDetail);
        return "Register OK";
    }
    
}
