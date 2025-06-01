package OnliX.TiendaOnline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnliX.TiendaOnline.DTO.requestRegisterReview;
import OnliX.TiendaOnline.Interfaces.IReview;
import OnliX.TiendaOnline.model.review;
import OnliX.TiendaOnline.model.shipment;

@Service
public class ReviewService {
    /*
     * @Autowired = Incluye la conexion de la interface
     */
    @Autowired
    public IReview ReviewData;
    public List<review> findAllReview(){
        return ReviewData.findAll();
    }
    public Optional<review> findByIdReview(int id){
        return ReviewData.findById(id);
    }
    // public List<review> findByName(String name){
    //     return ReviewData.findByName(name);
    // }
    public void save(review review){
        ReviewData.save(review);
    }
  
    public void update(int id,requestRegisterReview listReview){
        var review = findByIdReview(id);
        if(review.isPresent()){
            review.get().setQualification(listReview.getQualification());
            review.get().setComment(listReview.getComment());
            ReviewData.save(review.get());
        }
    }
    public void Delete(int id){
        var review = findByIdReview(id);
        if(review.isPresent()){
            ReviewData.delete(review.get());
        }
    }
  
}
