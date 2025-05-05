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
    public List<supplier> findByName(String name){
        return supplierData.findByName(name);
    }
    public void save(supplier supplier){
        supplierData.save(supplier);
    }

 
    public void update(int id,requestRegisterSupplier listSupplier){
        var supplier = findByIdSupplier(id);
        if(supplier.isPresent()){
            supplier.get().setName_supplier(listSupplier.getName());
            supplier.get().setContact_supplie(listSupplier.getContact());
            supplierData.save(supplier.get());
        }
    }
    public void Delete(int id){
        var supplier = findByIdSupplier(id);
        if(supplier.isPresent()){
            supplierData.delete(supplier.get());
        }
    }
}
