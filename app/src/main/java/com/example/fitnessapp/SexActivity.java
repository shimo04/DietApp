package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class SexActivity extends AppCompatActivity implements View.OnClickListener {
    private TextInputLayout SxText ;
    private Button SvBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sex);

        SxText = (TextInputLayout)findViewById(R.id.SexT);

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
        String Sx = SxText.getEditText().getText().toString().trim();

        Intent intent = new Intent(SexActivity.this,PoidsActivity.class);
        intent.putExtra("",Sx);

        String Ag = getIntent().getStringExtra("");

        startActivity(intent);

        Toast.makeText(SexActivity.this,Ag+" "+Sx+" ", Toast.LENGTH_LONG).show();
    }

}