package com.sena.ModelSegurity.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Permission")
public class Permission {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name="Id_Permission",nullable=false)
    private int Id_Permission;

    @Column(name="Name_Permission",nullable=false)
    private String Name_Permission;

    public Permission() {
    }

    public Permission(int id_Permission, String name_Permission) {
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
