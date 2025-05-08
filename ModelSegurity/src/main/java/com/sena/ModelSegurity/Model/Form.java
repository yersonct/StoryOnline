package com.sena.ModelSegurity.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="Form")
public class Form {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="Id_Form",nullable=false)
private int Id_Form;
@Column(name="Name_Form",nullable=false)
private String Name_Form;
public Form() {
}
public Form(int id_Form, String name_Form) {
    Id_Form = id_Form;
    Name_Form = name_Form;
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

 @OneToMany(mappedBy = "Form",cascade = CascadeType.ALL)
    private List<FormModule> FormModule;
}
