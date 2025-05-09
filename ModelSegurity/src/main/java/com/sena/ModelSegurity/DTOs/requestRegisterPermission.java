package com.sena.ModelSegurity.DTOs;

public class requestRegisterPermission {
    public int Id_Permission;
    public String Name_Permission;

    public requestRegisterPermission(int id_Permission, String name_Permission) {
        Id_Permission = id_Permission;
        Name_Permission = name_Permission;
    }

    public int getId_Permission() {
        return Id_Permission;
    }

    public void setId_Permission(int id_Permission) {
        Id_Permission = id_Permission;
    }

    public String getName_Permission() {
        return Name_Permission;
    }

    public void setName_Permission(String name_Permission) {
        Name_Permission = name_Permission;
    }

}
