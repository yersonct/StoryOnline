package com.sena.ModelSegurity.DTOs;

public class requestRegisterPerson {

    public int Id_Person;
    public String NamePerson;
    public String Document;
    public String Phone;
    public String LastName;
    public String Email;
    public String Age;
    public String active;
    public requestRegisterPerson(int id_Person, String namePerson, String document, String phone, String lastName,
            String email, String age, String active) {
        Id_Person = id_Person;
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
        Id_Person = id_Person;
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

}
