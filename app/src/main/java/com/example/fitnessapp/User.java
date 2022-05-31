package com.example.fitnessapp;

public class User
{
    public String NomPrenom,Age,Sex,Poids,Taille,Email;
    public User()
    {

    }
    public User(String NomPrenom,String Age,String Sex,String Poids,String Taille,String Email)
    {
        this.NomPrenom = NomPrenom;
        this.Age = Age;
        this.Sex = Sex;
        this.Poids = Poids;
        this.Taille = Taille;
        this.Email = Email;
    }
}
