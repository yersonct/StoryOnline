package com.sena.ModelSegurity.DTOs;

public class requestRegisterModule {
    public int Id_Module;
    public String Name_Module;
    public String Description;

    public requestRegisterModule(int id_Module, String name_Module, String description) {
        Id_Module = id_Module;
        Name_Module = name_Module;
        Description = description;
    }

    public int getId_Module() {
        return Id_Module;
    }

    public void setId_Module(int id_Module) {
        Id_Module = id_Module;
    }

    public String getName_Module() {
        return Name_Module;
    }

    public void setName_Module(String name_Module) {
        Name_Module = name_Module;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

}
