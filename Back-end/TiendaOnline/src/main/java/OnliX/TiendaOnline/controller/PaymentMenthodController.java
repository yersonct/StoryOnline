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

import OnliX.TiendaOnline.DTO.requestRegistetPaymentMethod;
import OnliX.TiendaOnline.model.paymentMethod;
import OnliX.TiendaOnline.service.PaymentMethodService;

@SuppressWarnings("unused")
@RestController
@RequestMapping("api/V1/paymentMethod")
public class PaymentMenthodController {
  /*
     * GET = Obtener datos o constutar
     * POST = Crear un registro
     * PUT = Actualización total
     * PATCH = Actualización parcial
     * DELETE = Eliminar
     */
    @Autowired
    private PaymentMethodService PaymentMethodService;
    @GetMapping("/")
    public ResponseEntity<Object>findAlLPaymentMethod(){
        var ListPaymentMethod = PaymentMethodService.findAlPaymentMethod();
        return new ResponseEntity<>(ListPaymentMethod,HttpStatus.OK);
    }
    @GetMapping("/{Id}")
    public ResponseEntity<Object> findBEntity(@PathVariable int id){
        var PaymentMethod = PaymentMethodService.findByIdPaymentMethod(id);
        return new ResponseEntity<>(PaymentMethod,HttpStatus.OK);
    }
    @PostMapping("/")
    public String postMethodName(@RequestBody requestRegistetPaymentMethod paymentMethod){
        PaymentMethodService.save(paymentMethod);
        return "Register OK";
    }
}
