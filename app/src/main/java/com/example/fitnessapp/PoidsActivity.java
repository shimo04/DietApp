package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class PoidsActivity extends AppCompatActivity implements View.OnClickListener {
    private TextInputLayout PsText ;
    private Button SvBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poids);

        PsText = (TextInputLayout)findViewById(R.id.PoidsT);

        SvBtn =(Button)findViewById(R.id.Suivant);
        SvBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        poidsAdd();
    }

    private void poidsAdd()
    {
        Intent intent = new Intent(PoidsActivity.this,TailleActivity.class);
        String Ps = PsText.getEditText().getText().toString().trim();

        Bundle extras = getIntent().getExtras();
        String np = extras.getString("nom");
        String ag = extras.getString("age");
        String sx = extras.getString("sex");


        intent.putExtra("nom",np);
        intent.putExtra("age",ag);
        intent.putExtra("sex",sx);
        intent.putExtra("poids",Ps);

        startActivity(intent);

        //Toast.makeText(PoidsActivity.this,np+" "+ag+" "+sx+" "+Ps, Toast.LENGTH_LONG).show();
    }
}