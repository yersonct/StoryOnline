package com.sena.ModelSegurity.DTOs;

public class requestRegisterUsers {

    public int Id_Users;
    public String NamePerson;
    public String PassWord;
    public int Id_Person;

    public requestRegisterUsers(int id_Users, String namePerson, String passWord, int id_Person) {
        Id_Users = id_Users;
        NamePerson = namePerson;
        PassWord = passWord;
        Id_Person = id_Person;
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

    public int getId_Person() {
        return Id_Person;
    }

    public void setId_Person(int id_Person) {
        Id_Person = id_Person;
    }
}
