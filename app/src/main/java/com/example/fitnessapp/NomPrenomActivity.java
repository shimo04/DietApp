package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class NomPrenomActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText NpText ;
    private Button SvBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nom_prenom);

        NpText = (EditText) findViewById(R.id.NomPrenomT);

        SvBtn =(Button)findViewById(R.id.Suivant);
        SvBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view)
    {
        nomPrenomAdd();
    }

    private void nomPrenomAdd()
    {
        Intent intent = new Intent(NomPrenomActivity.this,AgeActivity.class);
        String Np = NpText.getText().toString().trim();

        if (Np.isEmpty())
        {
            NpText.setError("saisissez votre Nom et Prenom");
            NpText.requestFocus();
            return;
        }

        intent.putExtra("nom",Np);
        startActivity(intent);
    }
}