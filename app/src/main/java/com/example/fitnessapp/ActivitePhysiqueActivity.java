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

public class ActivitePhysiqueActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioGroup ActiviteText ;
    private RadioButton Activite;
    private Button SvBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activite_physique);

        ActiviteText = (RadioGroup) findViewById(R.id.ActivitePhyT);

        SvBtn =(Button)findViewById(R.id.Suivant);
        SvBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        activitePhysique();
    }

    private void activitePhysique()
    {
        int radioId = ActiviteText.getCheckedRadioButtonId();
        Activite = findViewById(radioId);
        String Act = Activite.getText().toString().trim();

        Intent intent = new Intent(ActivitePhysiqueActivity.this,PlanActivity.class);

        Bundle extras = getIntent().getExtras();
        String np = extras.getString("nom");
        String ag = extras.getString("age");
        String sx = extras.getString("sex");
        String ps = extras.getString("poids");
        String tl = extras.getString("taille");
        String objPs = extras.getString("ObjPoids");
        String objSem = extras.getString("ObjSemaines");

        intent.putExtra("nom",np);
        intent.putExtra("age",ag);
        intent.putExtra("sex",sx);
        intent.putExtra("poids",ps);
        intent.putExtra("taille",tl);
        intent.putExtra("ObjPoids",objPs);
        intent.putExtra("ObjSemaines",objSem);
        intent.putExtra("Activite",Act);

        startActivity(intent);

         //Toast.makeText(ActivitePhysiqueActivity.this,np+" "+ag+" "+sx+" "+ps+" "+tl+" "+objPs+" "+objSem+" "+Act, Toast.LENGTH_LONG).show();
    }
}