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

import OnliX.TiendaOnline.DTO.requestRegisterReview;
import OnliX.TiendaOnline.service.ReviewService;

@RestController
@RequestMapping("api/V1/review")
public class ReviewController {
    /*
     * GET = Obtener datos o constutar
     * POST = Crear un registro
     * PUT = Actualización total
     * PATCH = Actualización parcial
     * DELETE = Eliminar
     */
    @Autowired
    private ReviewService ReviewService;
    @GetMapping("/")
    public ResponseEntity<Object> findAllReview(){
        var ListReview = ReviewService.findAllReview();
        return new ResponseEntity<>(ListReview,HttpStatus.OK);
    }
    @GetMapping("/{Id}")
    public ResponseEntity<Object> findByEntity(@PathVariable int id){
        var review = ReviewService.findByIdReview(id);
        return new ResponseEntity<>(review,HttpStatus.OK);
    }

    @PostMapping("/")
    public String postMethodName(@RequestBody requestRegisterReview review){
        ReviewService.save(review);
        return "Register OK";
    }
}
