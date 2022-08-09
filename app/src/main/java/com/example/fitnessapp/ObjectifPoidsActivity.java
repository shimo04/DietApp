package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class ObjectifPoidsActivity extends AppCompatActivity implements View.OnClickListener {
    private TextInputLayout ObjPsText, ObjSemText ;
    private Button SvBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objectif_poids);

        ObjPsText = (TextInputLayout)findViewById(R.id.EmailT);
        ObjSemText = (TextInputLayout)findViewById(R.id.SemaineObjT);

        SvBtn =(Button)findViewById(R.id.Suivant);
        SvBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        objectifPoidsSemaines();
    }

    private void objectifPoidsSemaines()
    {
        Intent intent = new Intent(ObjectifPoidsActivity.this,ActivitePhysiqueActivity.class);
        String Sem = ObjSemText.getEditText().getText().toString().trim();
        String PsObj = ObjPsText.getEditText().getText().toString().trim();

        Bundle extras = getIntent().getExtras();
        String np = extras.getString("nom");
        String ag = extras.getString("age");
        String sx = extras.getString("sex");
        String ps = extras.getString("poids");
        String tl = extras.getString("taille");

        intent.putExtra("nom",np);
        intent.putExtra("age",ag);
        intent.putExtra("sex",sx);
        intent.putExtra("poids",ps);
        intent.putExtra("taille",tl);
        intent.putExtra("ObjPoids",Sem);
        intent.putExtra("ObjSemaines",PsObj);

        startActivity(intent);

       // Toast.makeText(ObjectifPoidsActivity.this,np+" "+ag+" "+sx+" "+ps+" "+tl+" "+PsObj+" "+Sem, Toast.LENGTH_LONG).show();
    }
}