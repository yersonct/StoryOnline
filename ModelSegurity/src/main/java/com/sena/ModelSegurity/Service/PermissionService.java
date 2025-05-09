package com.sena.ModelSegurity.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ModelSegurity.DTOs.requestRegisterPermission;
import com.sena.ModelSegurity.Interfaces.IPermission;
import com.sena.ModelSegurity.Model.Permission;
@Service
public class PermissionService {
      /*
     * @Autowired = Incluye la conexion de la interface
     */
    @Autowired
    private IPermission permissionData;
    public List<Permission> findAllPermission(){
        return permissionData.findAll();
    }
    public Optional<Permission> findByIdPermission(int id){
        return permissionData.findById(id);
    }
    public void save(Permission permission){
        permissionData.save(permission);
    }
    public void update(int id, requestRegisterPermission permissionUpdate){
        var permission = findByIdPermission(id);
        if(permission.isPresent()){
            permission.get().setName_Permission(permissionUpdate.getName_Permission());
            permissionData.save(permission.get());
        }
    }
    public void delete(int id){
        var permission = findByIdPermission(id);
        if(permission.isPresent()){
            permissionData.deleteById(id);
        }
    }
}
