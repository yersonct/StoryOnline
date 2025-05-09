package com.sena.ModelSegurity.DTOs;

public class requestRegisterFormRolPermission {
    public int Id_FormRolPermission;
    public int Id_Form;
    public int Id_Rol;
    public int Id_Permission;

    public requestRegisterFormRolPermission(int id_FormRolPermission, int id_Form, int id_Rol, int id_Permission) {
        Id_FormRolPermission = id_FormRolPermission;
        Id_Form = id_Form;
        Id_Rol = id_Rol;
        Id_Permission = id_Permission;
    }

    public int getId_FormRolPermission() {
        return Id_FormRolPermission;
    }

    public void setId_FormRolPermission(int id_FormRolPermission) {
        Id_FormRolPermission = id_FormRolPermission;
    }

    public int getId_Form() {
        return Id_Form;
    }

    public void setId_Form(int id_Form) {
        Id_Form = id_Form;
    }

    public int getId_Rol() {
        return Id_Rol;
    }

    public void setId_Rol(int id_Rol) {
        Id_Rol = id_Rol;
    }

    public int getId_Permission() {
        return Id_Permission;
    }

    public void setId_Permission(int id_Permission) {
        Id_Permission = id_Permission;
    }


}
