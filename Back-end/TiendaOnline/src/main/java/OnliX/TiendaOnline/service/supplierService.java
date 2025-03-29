package OnliX.TiendaOnline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnliX.TiendaOnline.DTO.requestRegisterSupplier;
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
        return new supplier(0, supplier.getName(), supplier.getContact(), null);
    }
    public void update(int id,supplier supplierUpdate){
        var supplier = findByIdSupplier(id);
        if(supplier.isPresent()){
            supplier.get().setName_supplier(supplierUpdate.getName_supplier());
            supplier.get().setContact_supplie(supplierUpdate.getContact_supplie());
        }
    }
    public void Delete(int id){
        var supplier = findByIdSupplier(id);
        if(supplier.isPresent()){
            supplierData.delete(supplier.get());
        }
    }
}
