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
public void save(requestRegistetPaymentMethod paymentMethod){
    paymentMethodData.save(convertRegisterToPaymentMethod(paymentMethod));
}
public paymentMethod convertRegisterToPaymentMethod(requestRegistetPaymentMethod paymentMethod){
    return new paymentMethod(0, paymentMethod.getGuy(), true, paymentMethod.getPaymentDate());
}
public void update(int id,paymentMethod paymentMethodUpdate){
    var paymentMethod = findByIdPaymentMethod(id);
    if(paymentMethod.isPresent()){
        paymentMethod.get().setGuy(paymentMethodUpdate.getGuy());
        paymentMethod.get().setPaymentDate(paymentMethodUpdate.getPaymentDate());
    }
}
public void Delete(int id){
    var paymentMethod = findByIdPaymentMethod(id);
    if(paymentMethod.isPresent()){
        paymentMethodData.delete(paymentMethod.get());
    }
}
}