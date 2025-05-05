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

import OnliX.TiendaOnline.DTO.requestRegisterShipment;
import OnliX.TiendaOnline.DTO.requestRegisterUser;
import OnliX.TiendaOnline.model.shipment;
import OnliX.TiendaOnline.service.ShipmentService;
import OnliX.TiendaOnline.service.UserService;
@RestController
@RequestMapping("api/v1/shipment")
public class shipmentController {
    /*
     * GET = Obtener datos o constutar
     * POST = Crear un registro
     * PUT = Actualización total
     * PATCH = Actualización parcial
     * DELETE = Eliminar
     */
    @Autowired
    private ShipmentService ShipmentService;
    @GetMapping("/")
    public ResponseEntity<Object> findAllShipment(){
        var ListShipment = ShipmentService.findAllShipment();
        return new ResponseEntity<Object>(ListShipment,HttpStatus.OK);
    }
    @GetMapping("/{Id}")
    public ResponseEntity<Object>findByEntity(@PathVariable int id){
        var shipment = ShipmentService.findByIdShipment(id);
        return new ResponseEntity<Object>(shipment,HttpStatus.OK);
    }
    // @GetMapping("/name/{name}")
    // public ResponseEntity<Object> findByName(@PathVariable String name){
    //     var shipment = ShipmentService.findByName(name);
    //     return new ResponseEntity<>(shipment,HttpStatus.OK);
    // }

      @DeleteMapping("/{id}")
     public ResponseEntity<Object> DeleteShipment(@PathVariable int id){
        ShipmentService.Delete(id);
        return new ResponseEntity<>("Delete Ok",HttpStatus.OK);
     }
    @PostMapping("/")
    public String postMethodName(@RequestBody shipment shipment){
        ShipmentService.save(shipment);
        return "Register Ok";
    }
     @PutMapping("/{id}")
     public String Update(@RequestBody requestRegisterShipment ListShipment,@PathVariable int id){
        ShipmentService.update(id,ListShipment);
         return "Update Ok";
     }
}
