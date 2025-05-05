package OnliX.TiendaOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import OnliX.TiendaOnline.DTO.requestRegisterSupplier;
import OnliX.TiendaOnline.DTO.requestRegisterUser;
import OnliX.TiendaOnline.model.supplier;
import OnliX.TiendaOnline.service.ShipmentService;
import OnliX.TiendaOnline.service.UserService;
import OnliX.TiendaOnline.service.supplierService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1/supplier")
public class SupplierController {
    /*
     * GET = Obtener datos o constutar
     * POST = Crear un registro
     * PUT = Actualización total
     * PATCH = Actualización parcial
     * DELETE = Eliminar
     */

     @Autowired
     private supplierService supplierService;

     @GetMapping("/")
     public ResponseEntity<Object>findAllSupplier(){
        var ListSupplier = supplierService.findAllSupplier();
        return new ResponseEntity<Object>(ListSupplier,HttpStatus.OK);
    }
    @GetMapping("/{Id}")
    public ResponseEntity<Object> findBEntity(@PathVariable int id){
        var supplier = supplierService.findByIdSupplier(id);
        return new ResponseEntity<Object>(supplier,HttpStatus.OK);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Object> findByName(@PathVariable String name){
        var supplier = supplierService.findByName(name);
        return new ResponseEntity<Object>(supplier,HttpStatus.OK);
    }

     @DeleteMapping("/{id}")
     public ResponseEntity<Object> DeleteSupplier(@PathVariable int id){
        supplierService.Delete(id);
        return new ResponseEntity<>("Delete Ok",HttpStatus.OK);
     }
    @PostMapping("/")
    public String postMethodName(@RequestBody supplier supplier) {
        supplierService.save(supplier);
        
        return "Register Ok";
    }
        @PutMapping("/{id}")
     public String Update(@RequestBody requestRegisterSupplier ListSupplier,@PathVariable int id){
        supplierService.update(id,ListSupplier);
         return "Update Ok";
     }
}
