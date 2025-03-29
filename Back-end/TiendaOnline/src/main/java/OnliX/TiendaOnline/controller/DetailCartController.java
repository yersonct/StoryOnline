package OnliX.TiendaOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import OnliX.TiendaOnline.model.detailCart;
import OnliX.TiendaOnline.service.DetailCartService;
import org.springframework.web.bind.annotation.GetMapping;
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
        return new ResponseEntity<Object>(Lis)
    }  
   
    
}
