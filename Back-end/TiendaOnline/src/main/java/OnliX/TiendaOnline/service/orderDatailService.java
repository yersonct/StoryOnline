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
    public void save(requestRegisterOrderDetail orderDetail){
        OrderDetailData.save(convertRegisterToOrderDetail(orderDetail));
    }
    public orderDetail convertRegisterToOrderDetail(requestRegisterOrderDetail orderDetail){
        return new orderDetail(0, orderDetail.getAmount(), orderDetail.getUnitPrice(),orderDetail.getSubtotal());
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
            orderDetail.delete(orderDetail.get());
        }
    }
}
