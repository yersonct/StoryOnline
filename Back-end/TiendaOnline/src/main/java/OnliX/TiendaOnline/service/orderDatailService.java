package OnliX.TiendaOnline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnliX.TiendaOnline.DTO.requestRegisterOrderDetail;
import OnliX.TiendaOnline.Interfaces.IOrderDetail;
import OnliX.TiendaOnline.model.orderDetail;

@Service
public class orderDatailService {
    /*
     * @Autowired = Incluye la conexion de la interface
     */
    @Autowired
    private IOrderDetail OrderDetailData;
    public List<orderDetail> findAllOrderDetails(){
        return OrderDetailData.findAll(); // obtener todos los orderDetail
    }
    public Optional<orderDetail> findByIdOrderDetail(int id){
        return OrderDetailData.findById(id);
    }
    // public List<orderDetail> findByName(String name){
    //     return OrderDetailData.findByName(name);
    // }
    public void save(orderDetail orderDetail){
        OrderDetailData.save(orderDetail);
    }
   
    public void update(int id,orderDetail orderDetailUpdate){
        var orderDetail = findByIdOrderDetail(id);
        if(orderDetail.isPresent()){
            orderDetail.get().setAmount(orderDetailUpdate.getAmount());
            orderDetail.get().setUnitPrice(orderDetailUpdate.getUnitPrice());
            orderDetail.get().setSubtotal(orderDetailUpdate.getSubtotal());
        }
    }
    public void Delete(int id){
        var orderDetail = findByIdOrderDetail(id);
        if(orderDetail.isPresent()){
            OrderDetailData.delete(orderDetail.get());
        }
    }
}
