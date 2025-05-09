package com.sena.ModelSegurity.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ModelSegurity.DTOs.requestRegisterRol;
import com.sena.ModelSegurity.Interfaces.IRol;
import com.sena.ModelSegurity.Model.Rol;
@Service
public class RolService {
   /*
     * @Autowired = Incluye la conexion de la interface
     */
    @Autowired
    private IRol rolData;
    public List<Rol> findAllRol(){
        return rolData.findAll();
    }
    public Optional<Rol> findByIdRol(int id){
        return rolData.findById(id);
    }
    public void save(Rol rol){
        rolData.save(rol);
    }
    public void update(int id, requestRegisterRol rolUpdate){
        var rol = findByIdRol(id);
        if(rol.isPresent()){
            rol.get().setName_Rol(rolUpdate.getName_Rol());
            rol.get().setDescripcion(rolUpdate.getDescripcion());
            rolData.save(rol.get());
        }
    }
    public void delete(int id){
        var rol = findByIdRol(id);
        if(rol.isPresent()){
            rolData.deleteById(id);
        }
    }
}
