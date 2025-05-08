package com.sena.ModelSegurity.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name="Person")
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id_Person", nullable=false)
    private int Id_Person;

    @Column(name="NamePerson", nullable=false)
    private String NamePerson;

    @Column(name="Document", nullable=false)
    private String Document;

    @Column(name="Phone", nullable=false)
    private String Phone;

    @Column(name="LastName", nullable=false)
    private String LastName;

    @Column(name="Email", nullable=false)
    private String Email;

    @Column(name="Age", nullable=false)
    private String Age;

    @Column(name="active", nullable=false)
    private String active;

    public Person() {
    }

    public Person(int id_Person, String namePerson, String document, String phone, String lastName, String email,
            String age, String active) {
        this.Id_Person = id_Person;
        NamePerson = namePerson;
        Document = document;
        Phone = phone;
        LastName = lastName;
        Email = email;
        Age = age;
        this.active = active;
    }

    public int getId_Person() {
        return Id_Person;
    }

    public void setId_Person(int id_Person) {
        this.Id_Person = id_Person;
    }

    public String getNamePerson() {
        return NamePerson;
    }

    public void setNamePerson(String namePerson) {
        NamePerson = namePerson;
    }

    public String getDocument() {
        return Document;
    }

    public void setDocument(String document) {
        Document = document;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @OneToOne(mappedBy = "Users", cascade = CascadeType.ALL)
    private Users Users;
    
}
