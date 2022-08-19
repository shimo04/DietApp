package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class SexActivity extends AppCompatActivity implements View.OnClickListener
{
    private RadioGroup GenderText;
    private RadioButton SxText;
    private Button SvBtn ;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sex);

        GenderText = (RadioGroup)findViewById(R.id.Gender);

        SvBtn =(Button)findViewById(R.id.Suivant);
        SvBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        sexAdd();
    }

    private void sexAdd()
    {
        int radioId = GenderText.getCheckedRadioButtonId();
        SxText = findViewById(radioId);
        String Sx = SxText.getText().toString().trim();

        Intent intent = new Intent(SexActivity.this,PoidsActivity.class);

        Bundle extras = getIntent().getExtras();
        String np = extras.getString("nom");
        String ag = extras.getString("age");

        intent.putExtra("nom",np);
        intent.putExtra("age",ag);
        intent.putExtra("sex",Sx);

        startActivity(intent);

        //Toast.makeText(SexActivity.this,np+" "+ag+" "+Sx, Toast.LENGTH_LONG).show();
    }

}