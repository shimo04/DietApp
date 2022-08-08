package com.example.fitnessapp;

public class User
{
    public String NomPrenom,Age,Sex,Poids,Taille,Email,Pass;
    public User()
    {

    }
    public User(String NomPrenom,String Age,String Sex,String Poids,String Taille,String Email,String Pass)
    {
        this.NomPrenom = NomPrenom;
        this.Age = Age;
        this.Sex = Sex;
        this.Poids = Poids;
        this.Taille = Taille;
        this.Email = Email;
        this.Pass = Pass;
    }
}
