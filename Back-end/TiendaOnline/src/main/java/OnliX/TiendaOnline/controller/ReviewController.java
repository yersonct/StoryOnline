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

import OnliX.TiendaOnline.DTO.requestRegisterReview;
import OnliX.TiendaOnline.DTO.requestRegisterUser;
import OnliX.TiendaOnline.model.review;
import OnliX.TiendaOnline.service.ReviewService;
import OnliX.TiendaOnline.service.UserService;

@RestController
@RequestMapping("api/v1/review")
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
        return new ResponseEntity<Object>(ListReview,HttpStatus.OK);
    }
    @GetMapping("/{Id}")
    public ResponseEntity<Object> findByEntity(@PathVariable int id){
        var review = ReviewService.findByIdReview(id);
        return new ResponseEntity<Object>(review,HttpStatus.OK);
    }

    // @GetMapping("/name/{name}")
    // public ResponseEntity<Object> findByName(@PathVariable String name){
    //     var review = ReviewService.findByName(name);
    //     return new ResponseEntity<>(review,HttpStatus.OK);
    // }
     @DeleteMapping("/{id}")
     public ResponseEntity<Object> DeleteReview(@PathVariable int id){
        ReviewService.Delete(id);
        return new ResponseEntity<>("Delete Ok",HttpStatus.OK);
     }

    @PostMapping("/")
    public String postMethodName(@RequestBody review review){
        ReviewService.save(review);
        return "Register OK";
    }
    @PutMapping("/{id}")
     public String Update(@RequestBody requestRegisterReview ListReview,@PathVariable int id){
        ReviewService.update(id,ListReview);
         return "Update Ok";
     }
}
