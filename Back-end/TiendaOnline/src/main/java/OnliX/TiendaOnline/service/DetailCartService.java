package OnliX.TiendaOnline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnliX.TiendaOnline.DTO.requestRegisterDetailCart;
import OnliX.TiendaOnline.Interfaces.IDetailCart;
import OnliX.TiendaOnline.model.detailCart;

@Service
public class DetailCartService {
    /*
     * @Autowired = Incluye la conexion de la interface
     */
    @Autowired 
    private IDetailCart detailCartData;
    public List<detailCart> findAllDetailCart(){
        return detailCartData.findAll();
    }
    public Optional<detailCart> findByIdDetailCart(int id){
        return detailCartData.findById(id);
    }
    public void save(requestRegisterDetailCart detailCart){
        detailCartData.save(convertRegisterToDetailCart(detailCart));
    }
    public detailCart convertRegisterToDetailCart(requestRegisterDetailCart detailCart){
        return new detailCart(0, detailCart.getAmount());
    }
    public void update(int id,detailCart detailCartUpdate){
       var detailCart = findByIdDetailCart(id);
       if(detailCart.isPresent()){
        detailCart.get().setAmount(detailCartUpdate.getAmount());
       }
    }
    public void Delete(int id){
        var detailCart = findByIdDetailCart(id);
        if(detailCart.isPresent()){
            detailCartData.delete(detailCart.get());
        }
    }
}
