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
    // public List<discount> findByName(String name){
    //     return DiscountData.findByName(name);
    // }

    public void save(discount discount){
        DiscountData.save(discount);
    }
    
    public void update(int id,requestRegisterDiscount discount2){
        var discount = findByIdDiscounts(id);
        if(discount.isPresent()){
            discount.get().setCode(discount2.getCode());
            discount.get().setPorcentage(discount2.getPorcentage());
            DiscountData.save(discount.get());
        }
    }
    public void Delete(int id){
        var discount = findByIdDiscounts(id);
        if(discount.isPresent()){
            DiscountData.delete(discount.get());
        }
    }
}
