package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class ObjectifPoidsActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText ObjPsText, ObjSemText ;
    private Button SvBtn ;
    private TextView PoidsActText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objectif_poids);

        ObjPsText = (EditText)findViewById(R.id.PoidsObjT);
        ObjSemText = (EditText)findViewById(R.id.SemaineObjT);
        PoidsActText = (TextView)findViewById(R.id.PoidsAct);

        SvBtn =(Button)findViewById(R.id.Suivant);
        SvBtn.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        String ps = extras.getString("poids");
        PoidsActText.setText(ps);

    }

    @Override
    public void onClick(View v)
    {
        objectifPoidsSemaines();
    }

    private void objectifPoidsSemaines()
    {
        Intent intent = new Intent(ObjectifPoidsActivity.this,ActivitePhysiqueActivity.class);
        String Sem = ObjSemText.getText().toString().trim();
        String PsObj = ObjPsText.getText().toString().trim();

        if (PsObj.isEmpty())
        {
            ObjPsText.setError("saisissez votre objectif");
            ObjPsText.requestFocus();
            return;
        }
        else if (Sem.isEmpty())
        {
            ObjSemText.setError("saisissez nombre de semaines");
            ObjSemText.requestFocus();
            return;
        }

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
        //Toast.makeText(ObjectifPoidsActivity.this,np+" "+ag+" "+sx+" "+ps+" "+tl+" "+PsObj+" "+Sem, Toast.LENGTH_LONG).show();
    }
}