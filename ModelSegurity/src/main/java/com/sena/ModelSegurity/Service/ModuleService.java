package com.sena.ModelSegurity.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ModelSegurity.DTOs.requestRegisterModule;
import com.sena.ModelSegurity.Interfaces.IModule;
import com.sena.ModelSegurity.Model.Module;
@Service
public class ModuleService {
    /*
     * @Autowired = Incluye la conexion de la interface
     */
    @Autowired
    private IModule moduleData;
    public List<Module> findAllModule(){
        return moduleData.findAll();
    }
    public Optional<Module> findByIdModule(int id){
        return moduleData.findById(id);
    }
    public void save(java.lang.Module module){
        moduleData.save(module);
    }
    public void update(int id, requestRegisterModule moduleUpdate){
        var module = findByIdModule(id);
        if(module.isPresent()){
            module.get().setName_Module(moduleUpdate.getName_Module());
            moduleData.save(module.get());
        }
    }
    public void delete(int id){
        var module = findByIdModule(id);
        if(module.isPresent()){
            moduleData.deleteById(id);
        }
    }
}
