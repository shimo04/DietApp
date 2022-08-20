package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class TailleActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText TlText ;
    private Button SvBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taille);

        TlText = (EditText) findViewById(R.id.TailleT);

        SvBtn =(Button)findViewById(R.id.Suivant);
        SvBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        tailleAdd();
    }

    private void tailleAdd()
    {
        Intent intent = new Intent(TailleActivity.this,ObjectifPoidsActivity.class);
        String Tl = TlText.getText().toString().trim();

        if (Tl.isEmpty())
        {
            TlText.setError("saisissez votre Age");
            TlText.requestFocus();
            return;
        }

        Bundle extras = getIntent().getExtras();
        String np = extras.getString("nom");
        String ag = extras.getString("age");
        String sx = extras.getString("sex");
        String ps = extras.getString("poids");

        intent.putExtra("nom",np);
        intent.putExtra("age",ag);
        intent.putExtra("sex",sx);
        intent.putExtra("poids",ps);
        intent.putExtra("taille",Tl);

        startActivity(intent);

        //Toast.makeText(TailleActivity.this,np+" "+ag+" "+sx+" "+ps+" "+Tl, Toast.LENGTH_LONG).show();
    }
}