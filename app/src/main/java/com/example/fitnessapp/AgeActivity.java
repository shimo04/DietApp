package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class AgeActivity extends AppCompatActivity implements View.OnClickListener {
    private TextInputLayout AgText ;
    private Button SvBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        AgText = (TextInputLayout)findViewById(R.id.AgeT);

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
        Intent intent = new Intent(AgeActivity.this,SexActivity.class);
        String Ag = AgText.getEditText().getText().toString().trim();

        String Np = getIntent().getStringExtra("nom");

        intent.putExtra("nom",Np);
        intent.putExtra("age",Ag);

        startActivity(intent);

        //Toast.makeText(AgeActivity.this,Ag+""+Np, Toast.LENGTH_LONG).show();
    }
}