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
    public Void save(requestRegisterOrderDetail orderDetail){
        OrderDetailData.save(convertRegisterToOrderDetail(orderDetail));
    }
    public orderDetail convertRegisterToOrderDetail(requestRegisterOrderDetail orderDetail){
        return new orderDetail();
    }
}
