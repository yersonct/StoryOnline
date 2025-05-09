package com.sena.ModelSegurity.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ModelSegurity.DTOs.requestRegisterFormModule;
import com.sena.ModelSegurity.Interfaces.IFormModule;
import com.sena.ModelSegurity.Model.FormModule;
@Service
public class FormModuleService {
@Autowired
private IFormModule formModuleData;
public List<FormModule> findAllFormModules(){
    return formModuleData.findAll();
}
public Optional<FormModule> findByIdFormModule(int id){
    return formModuleData.findById(id); 
}

public void save(FormModule formModule){
    formModuleData.save(formModule);
}
public void update(int id, requestRegisterFormModule formModuleUpdate){
    var formModule = findByIdFormModule(id);
    if(formModule.isPresent()){
        formModule.get().setId_FormModule(formModuleUpdate.getId_FormModule());

        formModuleData.save(formModule.get());
    }
}
public void delete(int id){
    var formModule = findByIdFormModule(id);
    if(formModule.isPresent()){
        formModuleData.deleteById(id);
    }
}
}
