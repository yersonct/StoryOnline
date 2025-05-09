package com.sena.ModelSegurity.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="FormRolPermission")
public class FormRolPermission {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="Id_FormRolPermission",nullable=false)
private int Id_FormRolPermission;

public FormRolPermission() {
}



public FormRolPermission(int id_FormRolPermission, com.sena.ModelSegurity.Model.Form form,
        com.sena.ModelSegurity.Model.Rol rol, com.sena.ModelSegurity.Model.Permission permission) {
    Id_FormRolPermission = id_FormRolPermission;
    Form = form;
    Rol = rol;
    Permission = permission;
}



public int getId_FormRolPermission() {
    return Id_FormRolPermission;
}

public void setId_FormRolPermission(int id_FormRolPermission) {
    Id_FormRolPermission = id_FormRolPermission;
}

    @ManyToOne
    @JoinColumn(name="Id_Form",nullable = false)
    private Form Form;

    @ManyToOne
    @JoinColumn(name="Id_Rol",nullable = false)
    private Rol Rol;

    @ManyToOne
    @JoinColumn(name="Id_Permission",nullable = false)
    private Permission Permission;

}
