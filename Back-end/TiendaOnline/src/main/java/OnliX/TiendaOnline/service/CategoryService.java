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
    public void save(requestRegisterCategory category){
        categoryData.save(convertRegisterToCategory(category));
    }
    public category convertRegisterToCategory(requestRegisterCategory category){
        return new category(0, category.getName(), category.getDescription());
    }
    public void update(int id,category categoryUpdate){
        var category = findByCategory(id);
        if(category.isPresent()){
            category.get().setName(categoryUpdate.getName());
            category.get().setDescription(categoryUpdate.getDescription());
        }
    }
    public void Delete(int id){
        var category = findByCategory(id);
        if(category.isPresent()){
            categoryData.delete(category.get());
        }
    }
}
