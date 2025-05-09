package com.sena.ModelSegurity.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ModelSegurity.DTOs.requestRegisterForm;
import com.sena.ModelSegurity.Interfaces.IForm;
import com.sena.ModelSegurity.Model.Form;
@Service
public class FormService {
  /*
     * @Autowired = Incluye la conexion de la interface
     */
    @Autowired
    private IForm formData;
    public List<Form> findAllForms(){
        return formData.findAll();
    }
    public Optional<Form> findByIdForm(int id){
        return formData.findById(id);
    }
    public void save(Form form){
        formData.save(form);
    }
    public void update(int id, requestRegisterForm formUpdate){
        var form = findByIdForm(id);
        if(form.isPresent()){
            form.get().setName_Form(formUpdate.getName_Form());
            form.get().setDescription(formUpdate.getDescription());
            formData.save(form.get());
        }
    }
    public void delete(int id){
        var form = findByIdForm(id);
        if(form.isPresent()){
            formData.deleteById(id);
        }
    }
}
