package com.example.fitnessapp;

public class User
{
    public String NomPrenom,Age,Sex,Poids,Taille,ObjectifPoids,ObjectifSemaines,ActivitePhysique,Plan,Email,Pass;
    public User()
    {

    }
    public User (String NomPrenom,String Age,String Sex,String Poids,String Taille,String ObjectifPoids,
                 String ObjectifSemaines,String ActivitePhysique,String Plan,String Email,String Pass)
    {
        this.NomPrenom = NomPrenom;
        this.Age = Age;
        this.Sex = Sex;
        this.Poids = Poids;
        this.Taille = Taille;
        this.ObjectifPoids = ObjectifPoids;
        this.ObjectifSemaines = ObjectifSemaines;
        this.ActivitePhysique = ActivitePhysique;
        this.Plan = Plan;
        this.Email = Email;
        this.Pass = Pass;
    }
}
