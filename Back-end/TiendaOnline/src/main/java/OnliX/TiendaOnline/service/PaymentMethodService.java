package OnliX.TiendaOnline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnliX.TiendaOnline.DTO.requestRegistetPaymentMethod;
import OnliX.TiendaOnline.Interfaces.IPaymentMethod;
import OnliX.TiendaOnline.model.paymentMethod;

@Service
public class PaymentMethodService {
@Autowired
public IPaymentMethod paymentMethodData;
public List<paymentMethod> findAlPaymentMethod(){
    return paymentMethodData.findAll();
}
public Optional<paymentMethod> findByIdPaymentMethod(int id){
    return paymentMethodData.findById(id);
}
// public List<paymentMethod> findByName(String name){
//     return paymentMethodData.findByName(name);
// }

public void save(paymentMethod paymentMethod){
    paymentMethodData.save(paymentMethod);
}

public void update(int id,requestRegistetPaymentMethod user){
    var paymentMethod = findByIdPaymentMethod(id);
    if(paymentMethod.isPresent()){
        paymentMethod.get().setGuy(user.getGuy());
        paymentMethod.get().setPaymentDate(user.getPaymentDate());
        paymentMethodData.save(paymentMethod.get());
    }
}
public void Delete(int id){
    var paymentMethod = findByIdPaymentMethod(id);
    if(paymentMethod.isPresent()){
        paymentMethodData.delete(paymentMethod.get());
    }
}
}