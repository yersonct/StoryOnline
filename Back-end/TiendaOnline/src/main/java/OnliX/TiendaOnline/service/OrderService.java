package OnliX.TiendaOnline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnliX.TiendaOnline.DTO.requestRegisterOrder;
import OnliX.TiendaOnline.Interfaces.IOrder;
import OnliX.TiendaOnline.model.order;
import OnliX.TiendaOnline.model.orderDetail;

@Service
public class OrderService {

    /*
     * @Autowired = Incluye la conexion de la interface
     */
    @Autowired
    private IOrder  OrderData;
    public   List<order> findAllOrder(){
        return OrderData.findAll();
    }
    public Optional<order> findByIdOrder(int id){
        return OrderData.findById(id);
    }
    public void save(requestRegisterOrder order){
        OrderData.save(convertRegisterToOrder(order));
    }

    public order convertRegisterToOrder(requestRegisterOrder order){
        return new order(0, order.getDate(),order.getTotal(), true);
    }
    public void update(int id,order orderUpdate){
        var  order = findByIdOrder(id);
        if(order.isPresent()){
            order.get().setDate(orderUpdate.getDate());
            order.get().setTotal(orderUpdate.getTotal());
        }
    }
    public void Delete(int id){
        var order = findByIdOrder(id);
        if(order.isPresent()){
            OrderData.delete(order.get());
        }

    }
}
