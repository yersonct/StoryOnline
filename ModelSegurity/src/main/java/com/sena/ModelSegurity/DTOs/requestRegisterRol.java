package com.sena.ModelSegurity.DTOs;

public class requestRegisterRol {
    public int Id_Rol;
    public String Name_Rol;
    public String Descripcion;

    public requestRegisterRol(int id_Rol, String name_Rol, String descripcion) {
        Id_Rol = id_Rol;
        Name_Rol = name_Rol;
        Descripcion = descripcion;
    }

    public int getId_Rol() {
        return Id_Rol;
    }

    public void setId_Rol(int id_Rol) {
        Id_Rol = id_Rol;
    }

    public String getName_Rol() {
        return Name_Rol;
    }

    public void setName_Rol(String name_Rol) {
        Name_Rol = name_Rol;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

}
