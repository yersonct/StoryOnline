package com.sena.ModelSegurity.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ModelSegurity.DTOs.requestRegisterFormRolPermission;
import com.sena.ModelSegurity.Interfaces.IFormRolPermission;
import com.sena.ModelSegurity.Model.FormRolPermission;

@Service
public class FormRolPermissionService {
   /*
     * @Autowired = Incluye la conexion de la interface
     */
    @Autowired
    private IFormRolPermission formRolPermissionData;
    public List<FormRolPermission> findAllFormRolPermissions(){
        return formRolPermissionData.findAll();
    }
    public Optional<FormRolPermission> findByIdFormRolPermission(int id){
        return formRolPermissionData.findById(id);
    }
    public void save(FormRolPermission formRolPermission){
        formRolPermissionData.save(formRolPermission);
    }
    public void update(int id, requestRegisterFormRolPermission formRolPermissionUpdate){
        var formRolPermission = findByIdFormRolPermission(id);
        if(formRolPermission.isPresent()){
            formRolPermission.get().setId_FormRolPermission(formRolPermissionUpdate.getId_FormRolPermission());
           
            formRolPermissionData.save(formRolPermission.get());
        }
    }
    public void delete(int id){
        var formRolPermission = findByIdFormRolPermission(id);
        if(formRolPermission.isPresent()){
            formRolPermissionData.deleteById(id);
        }
    }
}
