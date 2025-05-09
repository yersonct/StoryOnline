package com.sena.ModelSegurity.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="FormModule")
public class FormModule {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="Id_FormModule",nullable=false)
private int Id_FormModule;

    public FormModule() {
    }
    
    public FormModule(int id_FormModule, com.sena.ModelSegurity.Model.Form form, Module module) {
        Id_FormModule = id_FormModule;
        Form = form;
        this.module = module;
    }

    public int getId_FormModule() {
        return Id_FormModule;
    }

    public void setId_FormModule(int id_FormModule) {
        Id_FormModule = id_FormModule;
    }

    @ManyToOne
    @JoinColumn(name="Id_Form",nullable = false)
    private Form Form;
    @ManyToOne
    @JoinColumn(name="Id_Module",nullable = false)
    private Module module;
}
