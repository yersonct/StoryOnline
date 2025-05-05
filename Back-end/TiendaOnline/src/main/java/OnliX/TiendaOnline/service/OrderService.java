package OnliX.TiendaOnline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnliX.TiendaOnline.DTO.requestRegisterOrder;
import OnliX.TiendaOnline.Interfaces.IOrder;
import OnliX.TiendaOnline.model.Orders;

@SuppressWarnings("unused")
@Service
public class OrderService {

    /*
     * @Autowired = Incluye la conexion de la interface
     */
    @Autowired
    private IOrder  OrderData;
    public   List<Orders> findAllOrder(){
        return OrderData.findAll();
    }
    public Optional<Orders> findByIdOrder(int id){
        return OrderData.findById(id);
    }
    // public List<Orders> findByName(String name){
    //     return OrderData.findByName(name);
    // }

    public void save(Orders order){
        OrderData.save(order);
    }


    public void update(int id,requestRegisterOrder order2){
        var  order = findByIdOrder(id);
        if(order.isPresent()){
            order.get().setDate(order2.getDate());
            order.get().setTotal(order2.getTotal());
            OrderData.save(order.get());
        }
    }
    public void Delete(int id){
        var order = findByIdOrder(id);
        if(order.isPresent()){
            OrderData.delete(order.get());
        }

    }
}
