package OnliX.TiendaOnline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnliX.TiendaOnline.DTO.requestRegisterCategory;
import OnliX.TiendaOnline.Interfaces.ICategory;
import OnliX.TiendaOnline.model.category;

@Service
public class CategoryService {
    /*
     * @Autowired = Incluye la conexion de la interface
     */
    @Autowired
    private ICategory categoryData;
    public List<category> findAllCategories(){
        return categoryData.findAll();
    }
    public Optional<category>findByCategory(int id){
        return categoryData.findById(id);
    }
    public List<category> findByName(String name){
        return categoryData.findByName(name);
    }
    public void save(category category){
        categoryData.save(category);
    }
  
    public void update(int id,requestRegisterCategory categoria){
        var category = findByCategory(id);
        if(category.isPresent()){
            category.get().setName(categoria.getName());
            category.get().setDescription(categoria.getDescription());
            categoryData.save(category.get());
        }
    }
    public void Delete(int id){
        var category = findByCategory(id);
        if(category.isPresent()){
            categoryData.delete(category.get());
        }
    }
}
