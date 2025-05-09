package com.sena.ModelSegurity.DTOs;

public class requestRegisterRolUser {
    public int Id_RolUser;
    public int Id_Rol;
    public int Id_Users;

    public requestRegisterRolUser(int id_RolUser, int id_Rol, int id_Users) {
        Id_RolUser = id_RolUser;
        Id_Rol = id_Rol;
        Id_Users = id_Users;
    }

    public int getId_RolUser() {
        return Id_RolUser;
    }

    public void setId_RolUser(int id_RolUser) {
        Id_RolUser = id_RolUser;
    }

    public int getId_Rol() {
        return Id_Rol;
    }

    public void setId_Rol(int id_Rol) {
        Id_Rol = id_Rol;
    }

    public int getId_Users() {
        return Id_Users;
    }

    public void setId_Users(int id_Users) {
        Id_Users = id_Users;
    }

}
