package com.sena.ModelSegurity.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="Rol")
public class Rol {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="Id_Rol",nullable=false)
private int Id_Rol;
@Column(name="Name_Rol",nullable=false)
private String Name_Rol;

@Column(name="Descripcion",nullable=true, length=1000)
private String Descripcion;

public Rol() {
}

public Rol(int id_Rol, String name_Rol, String descripcion) {
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

 @OneToMany(mappedBy = "Rol",cascade = CascadeType.ALL)
    private List<RolUser> RolUser;
}
