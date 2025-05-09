package com.sena.ModelSegurity.DTOs;

public class requestRegisterFormModule {

    public int Id_FormModule;
    public int Id_Form;
    public int Id_Module;
   
    public requestRegisterFormModule(int id_FormModule, int id_Form, int id_Module) {
        Id_FormModule = id_FormModule;
        Id_Form = id_Form;
        Id_Module = id_Module;
    }
    public int getId_FormModule() {
        return Id_FormModule;
    }
    public void setId_FormModule(int id_FormModule) {
        Id_FormModule = id_FormModule;
    }
    public int getId_Form() {
        return Id_Form;
    }
    public void setId_Form(int id_Form) {
        Id_Form = id_Form;
    }
    public int getId_Module() {
        return Id_Module;
    }
    public void setId_Module(int id_Module) {
        Id_Module = id_Module;
    }
}
