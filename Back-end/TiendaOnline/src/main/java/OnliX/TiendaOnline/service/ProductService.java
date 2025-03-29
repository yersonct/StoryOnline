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
    public void save(requestRegisterProduct product){
        ProductData.save(convertRegisterToProduct(product));
    }
    public product convertRegisterToProduct(requestRegisterProduct product){
        return new product(0, product.getName(), product.getDescription(), product.getPrice());
    }
    public void update(int id, product productUpdate){
        var product = findByIdProduct(id);
        if(product.isPresent()){
            product.get().setName_product(productUpdate.getName_product());
            product.get().setDescription(productUpdate.getDescription());
            product.get().setPrice(productUpdate.getPrice());
        }
    }
    public void Delete(int id){
        var product = findByIdProduct(id);
        if(product.isPresent()){
            ProductData.delete(product.get());
        }
    }
}
