package OnliX.TiendaOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import OnliX.TiendaOnline.DTO.requestRegisterShipment;
import OnliX.TiendaOnline.service.ShipmentService;

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
        return new ResponseEntity<>(ListShipment,HttpStatus.OK);
    }
    @GetMapping("/{Id}")
    public ResponseEntity<Object>findByEntity(@PathVariable int id){
        var shipment = ShipmentService.findByIdShipment(id);
        return new ResponseEntity<>(shipment,HttpStatus.OK);
    }
    @PostMapping("/")
    public String postMethodName(@RequestBody requestRegisterShipment shipment){
        ShipmentService.save(shipment);
        return "Register Ok";
    }
}
