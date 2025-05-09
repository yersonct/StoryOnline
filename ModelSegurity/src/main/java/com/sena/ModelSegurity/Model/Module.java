package com.sena.ModelSegurity.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="Module")
public class Module {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="Id_Module",nullable=false)
private int Id_Module;
@Column(name="Name_Module",nullable=false)
private String Name_Module;
public Module() {
}
public Module(int id_Module, String name_Module) {
    Id_Module = id_Module;
    Name_Module = name_Module;
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

@OneToMany(mappedBy = "module", cascade = CascadeType.ALL)  // Modificado
    private List<FormModule> formModules;
}
