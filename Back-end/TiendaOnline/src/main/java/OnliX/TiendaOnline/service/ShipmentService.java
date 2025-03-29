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

    public void save(requestRegisterShipment shipment){
        shipmentData.save(convertRegisterToShipment(shipment));
    }
    public shipment convertRegisterToShipment(requestRegisterShipment shipment){
        return new shipment(0, null, true,shipment.getCompanyShipping(), null, null);
    }
}
