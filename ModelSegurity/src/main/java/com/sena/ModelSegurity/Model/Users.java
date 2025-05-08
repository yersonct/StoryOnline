package com.sena.ModelSegurity.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name="Users")
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
   
    
    @Column(name="Id_Users",nullable=false)
    private int Id_Users;

    @Column(name="NamePerson", nullable=false)
    private String NamePerson;

    @Column(name="Password", nullable=false)
    private String PassWord;
    

    
    public Users() {
    }


    
    public Users(int id_Users, String namePerson, String passWord, Person person) {
        Id_Users = id_Users;
        NamePerson = namePerson;
        PassWord = passWord;
        this.person = person;
    }



    public int getId_Users() {
        return Id_Users;
    }



    public void setId_Users(int id_Users) {
        Id_Users = id_Users;
    }



    public String getNamePerson() {
        return NamePerson;
    }



    public void setNamePerson(String namePerson) {
        NamePerson = namePerson;
    }



    public String getPassWord() {
        return PassWord;
    }



    public void setPassWord(String passWord) {
        PassWord = passWord;
    }



    public Person getPerson() {
        return person;
    }



    public void setPerson(Person person) {
        this.person = person;
    }



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Person", referencedColumnName = "Id_Person")
    private Person person;


    @OneToMany(mappedBy = "Users",cascade = CascadeType.ALL)
    private List<RolUser> RolUser;

}
