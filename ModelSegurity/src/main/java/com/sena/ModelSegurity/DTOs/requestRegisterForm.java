package com.sena.ModelSegurity.DTOs;

public class requestRegisterForm {
    public int Id_Form;
    public String Name_Form;
    public String Description;

    public requestRegisterForm(int id_Form, String name_Form, String description) {
        Id_Form = id_Form;
        Name_Form = name_Form;
        Description = description;
    }

    public int getId_Form() {
        return Id_Form;
    }

    public void setId_Form(int id_Form) {
        Id_Form = id_Form;
    }

    public String getName_Form() {
        return Name_Form;
    }

    public void setName_Form(String name_Form) {
        Name_Form = name_Form;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

}
