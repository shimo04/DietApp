package com.example.fitnessapp;

public class User
{
    public String NomPrenomU,AgeU,SexU,PoidsU,TailleU,EmailU,Pass;
    public User()
    {

    }
    public User (String NomPrenom,String AgeU,String SexU,String PoidsU,String TailleU,String EmailU)
    {
        this.NomPrenomU = NomPrenom;
        this.AgeU = AgeU;
        this.SexU = SexU;
        this.PoidsU = PoidsU;
        this.TailleU = TailleU;
        this.EmailU = EmailU;
    }

    public String getNomPrenomU() {
        return NomPrenomU;
    }

    public String getAgeU() {
        return AgeU;
    }

    public String getSexU() {
        return SexU;
    }

    public String getPoidsU() {
        return PoidsU;
    }

    public String getTailleU() {
        return TailleU;
    }

    public String getEmailU() {
        return EmailU;
    }

    public String getPass() {
        return Pass;
    }

    public void setNomPrenomU(String nomPrenomU) {
        NomPrenomU = nomPrenomU;
    }

    public void setAgeU(String ageU) {
        AgeU = ageU;
    }

    public void setSexU(String sexU) {
        SexU = sexU;
    }

    public void setPoidsU(String poidsU) {
        PoidsU = poidsU;
    }

    public void setTailleU(String tailleU) {
        TailleU = tailleU;
    }

    public void setEmailU(String emailU) {
        EmailU = emailU;
    }

    public void setPass(String pass) {
        Pass = pass;
    }
}
