package OnliX.TiendaOnline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Onlix.tiendaOnline.DTO.requestRegisterSupplier
import OnliX.TiendaOnline.Interfaces.ISupplier;
import OnliX.TiendaOnline.model.supplier;

@Service
public class supplierService {
    /*
     * @Autowired = Incluye la conexion de la interface
     */

    @Autowired
    public ISupplier supplierData;
    public List<supplier> findAllSupplier(){
        return supplierData.findAll();
    }

    public Optional<supplier> findByIdSupplier(int id){
        return supplierData.findById(id);
    }

    public void save(requestRegisterSupplier supplier){
        supplierData.save(convertRegisterToSupplier(supplier));
    }

    public supplier convertRegisterToSupplier(requestRegisterSupplier supplier){
        return new supplier()
    }
}   
