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
    public List<review> findAllShipment(){
        return ReviewData.findAll();
    }
    public Optional<review> findByIdReview(int id){
        return ReviewData.findById(id);
    }
    public void save(requestRegisterReview review){
        ReviewData.save(convertRegisterToReview(review));
    }
    public review convertRegisterToReview(requestRegisterReview review){
        return new review(0, review.getQualification(), review.getComment(), null);
    }
    public void update(int id,review reviewUpdate){
        var review = findByIdReview(id);
        if(review.isPresent()){
            review.get().setQualification(reviewUpdate.getQualification());
            review.get().setComment(reviewUpdate.getComment());
        }
    }
    public void Delete(int id){
        var review = findByIdReview(id);
        if(review.isPresent()){
            ReviewData.delete(review.get());
        }
    }
    public Object findAllReview() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllReview'");
    }
}
