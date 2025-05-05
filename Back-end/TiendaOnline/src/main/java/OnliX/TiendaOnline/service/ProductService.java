package OnliX.TiendaOnline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnliX.TiendaOnline.DTO.requestRegisterProduct;
import OnliX.TiendaOnline.Interfaces.IProduct;
import OnliX.TiendaOnline.model.product;

@Service
public class ProductService {
    /*
     * @Autowired = Incluye la conexion de la interface
     */
    @Autowired
    public IProduct ProductData;
    public List<product> findAllProduct(){
        return ProductData.findAll();
    }
    public Optional<product>findByIdProduct(int id){
        return ProductData.findById(id);
    }
    public List<product> findByName(String name){
        return ProductData.findByName(name);
    }
    public void save(product product){
        ProductData.save(product);
    }
  
    public void update(int id, requestRegisterProduct product2){
        var product = findByIdProduct(id);
        if(product.isPresent()){
            product.get().setName_product(product2.getName());
            product.get().setDescription(product2.getDescription());
            product.get().setPrice(product2.getPrice());
            ProductData.save(product.get());
        }
    }
    public void Delete(int id){
        var product = findByIdProduct(id);
        if(product.isPresent()){
            ProductData.delete(product.get());
        }
    }
}
