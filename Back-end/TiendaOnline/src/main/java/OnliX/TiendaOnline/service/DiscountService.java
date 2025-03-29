package OnliX.TiendaOnline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnliX.TiendaOnline.DTO.requestRegisterDiscount;
import OnliX.TiendaOnline.Interfaces.IDiscount;
import OnliX.TiendaOnline.model.discount;

@Service
public class DiscountService {
    /*
     * @Autowired = Incluye la conexion de la interface
     */
    @Autowired
    private IDiscount DiscountData;
    public List<discount> findAllDiscounts(){
        return DiscountData.findAll();
    }
    public Optional<discount>findByIdDiscounts(int id){
        return DiscountData.findById(id);
    }
    public void save(requestRegisterDiscount discount){
        DiscountData.save(convertRegisterToDiscount(discount));
    }
    public discount convertRegisterToDiscount(requestRegisterDiscount discount){
        return new discount(0, discount.getCode(), discount.getPorcentage(), null, null);
    }
    public void update(int id,discount discountUpdate){
        var discount = findByIdDiscounts(id);
        if(discount.isPresent()){
            discount.get().setCode(discountUpdate.getCode());
            discount.get().setPorcentage(discountUpdate.getPorcentage());
        }
    }
    public void Delete(int id){
        var discount = findByIdDiscounts(id);
        if(discount.isPresent()){
            DiscountData.delete(discount.get());
        }
    }
}
