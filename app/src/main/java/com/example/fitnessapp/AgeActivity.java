package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class AgeActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText AgText ;
    private Button SvBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        AgText = (EditText) findViewById(R.id.AgeT);

        SvBtn =(Button)findViewById(R.id.Suivant);
        SvBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
       ageAdd();
    }

    private void ageAdd()
    {
        String Ag = AgText.getText().toString().trim();
        if (Ag.isEmpty())
        {
            AgText.setError("saisissez votre Age");
            AgText.requestFocus();
            return;
        }

        Intent intent = new Intent(AgeActivity.this,SexActivity.class);

        Bundle extras = getIntent().getExtras();
        String np = extras.getString("nom");

        intent.putExtra("nom",np);
        intent.putExtra("age",Ag);

        String Np = getIntent().getStringExtra("");

        startActivity(intent);

        //Toast.makeText(AgeActivity.this,Ag+""+Np, Toast.LENGTH_LONG).show();
    }
}