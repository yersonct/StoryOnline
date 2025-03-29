package OnliX.TiendaOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return shipmentData,findAll();
    }

    public void save(requestRegisterShipment shipment){
        shipmentData.save(convertRegisterToShipment(shipment));
    }
}
