package com.sena.ModelSegurity.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name="RolUser")
public class RolUser {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="Id_RolUser",nullable=false)
private int Id_RolUser;

public RolUser() {
}



public RolUser(int id_RolUser, com.sena.ModelSegurity.Model.Rol rol, com.sena.ModelSegurity.Model.Users users) {
    Id_RolUser = id_RolUser;
    Rol = rol;
    Users = users;
}



public int getId_RolUser() {
    return Id_RolUser;
}

public void setId_RolUser(int id_RolUser) {
    Id_RolUser = id_RolUser;
}

    @ManyToOne
    @JoinColumn(name="Id_Rol",nullable = false)
    private Rol Rol;


    @ManyToOne
    @JoinColumn(name="Id_Users",nullable = false)
    private Users Users;


}
