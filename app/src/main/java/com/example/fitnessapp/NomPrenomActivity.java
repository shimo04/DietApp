package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class NomPrenomActivity extends AppCompatActivity implements View.OnClickListener
{
    private TextInputLayout NpText;
    private Button Sv;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nom_prenom);

        NpText = (TextInputLayout)findViewById(R.id.NomPrenom);
        NpText.setOnClickListener(this);

        Sv = (Button)findViewById(R.id.IdRegister);
        Sv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        registerUser();
        startActivity((new Intent(this,SexActivity.class)));
    }

    private void registerUser()
    {
        String Np = NpText.getEditText().getText().toString().trim();
        if (Np.isEmpty())
        {
            NpText.setError("Saisir votre Nom et Prenom");
            NpText.requestFocus();
            return;
        }


    }
}