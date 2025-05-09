package com.sena.ModelSegurity.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ModelSegurity.DTOs.requestRegisterRolUser;
import com.sena.ModelSegurity.Interfaces.IRolUser;
import com.sena.ModelSegurity.Model.RolUser;

@Service
public class RolUserService {

    @Autowired
    private IRolUser rolUserData;
    public List<RolUser> findAllRolUser() {
        return rolUserData.findAll();
    }
    public Optional<RolUser> findByIdRolUser(int id) {
        return rolUserData.findById(id);
    }
    public void save(RolUser rolUser) {
        rolUserData.save(rolUser);
    }
    public void update(int id, requestRegisterRolUser rolUserUpdate) {
        var rolUser = findByIdRolUser(id);
        if (rolUser.isPresent()) {
            rolUser.get().setId_RolUser(rolUserUpdate.getId_Rol());
            rolUserData.save(rolUser.get());
        }
    }
    public void delete(int id) {
        var rolUser = findByIdRolUser(id);
        if (rolUser.isPresent()) {
            rolUserData.deleteById(id);
        }
    }
}
