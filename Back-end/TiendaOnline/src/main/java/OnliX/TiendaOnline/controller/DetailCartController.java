package OnliX.TiendaOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import OnliX.TiendaOnline.DTO.requestRegisterDetailCart;
import OnliX.TiendaOnline.model.detailCart;
import OnliX.TiendaOnline.service.DetailCartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/V1/detailCart")
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
    @PostMapping("/")
    public String postMethodName(@RequestBody requestRegisterDetailCart detailCart){
        detailCartService.save(detailCart);
        return "Register OK";
    }
   
    
}
