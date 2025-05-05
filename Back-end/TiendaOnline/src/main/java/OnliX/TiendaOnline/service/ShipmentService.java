package OnliX.TiendaOnline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnliX.TiendaOnline.DTO.requestRegisterShipment;
import OnliX.TiendaOnline.Interfaces.IShipment;
import OnliX.TiendaOnline.model.shipment;

@Service
public class ShipmentService {
    /*
     * @Autowired = Incluye la conexion de la interface
     */
    @Autowired
    public IShipment shipmentData;
    public List<shipment> findAllShipment(){
        return shipmentData.findAll();
    }
    public Optional<shipment> findByIdShipment(int id){
        return shipmentData.findById(id);
    }

    // public List<shipment> findByName(String name){
    //     return shipmentData.findByName(name);
    // }
    public void save(shipment shipment){
        shipmentData.save(shipment);
    }
 
    public void update(int id,requestRegisterShipment listShipment){
        var shipment = findByIdShipment(id);
        if(shipment.isPresent()){
            shipment.get().setCompanyShipping(listShipment.getCompanyShipping());
            shipment.get().setShippingDate(listShipment.getShippingDate());
            shipment.get().setDeliveryDate(listShipment.getDeliveryDate());
            shipmentData.save(shipment.get());
        }
    }
    public void Delete(int id){
        var shipment = findByIdShipment(id);
        if(shipment.isPresent()){
            shipmentData.delete(shipment.get());
        }
    }
}
