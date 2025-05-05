package OnliX.TiendaOnline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnliX.TiendaOnline.DTO.requestRegisterCart;
import OnliX.TiendaOnline.Interfaces.ICart;
import OnliX.TiendaOnline.model.cart;

@Service
public class CartService {
    /*
     * @Autowired = Incluye la conexion de la interface
     */
    @Autowired
    private ICart CartData;
    public List<cart> findAllCart(){
        return CartData.findAll();
    }
    public Optional<cart>findByIdCart(int id){
        return CartData.findById(id);
    }
    // public List<cart> findByName(String name){
    //     return CartData.findByName(name);
    // }
    public void save(cart cart){
        CartData.save(cart);
    }
    
    public void update(int id,requestRegisterCart cartUpdate){
        var cart = findByIdCart(id);
        if(cart.isPresent()){
            cart.get().setUpdateData(cartUpdate.getUpdateData());
            CartData.save(cart.get());
        }
    }
    public void Delete(int id){
        var cart = findByIdCart(id);
        if(cart.isPresent()){
            CartData.delete(cart.get());
        }
    }
}
