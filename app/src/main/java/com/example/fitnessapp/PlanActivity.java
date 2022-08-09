package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class PlanActivity extends AppCompatActivity implements View.OnClickListener {
    private TextInputLayout PlanText ;
    private Button SvBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        PlanText = (TextInputLayout)findViewById(R.id.PlanT);

        SvBtn =(Button)findViewById(R.id.Suivant);
        SvBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        planningOption();
    }

    private void planningOption()
    {
        Intent intent = new Intent(PlanActivity.this,RegisterActivity.class);
        String Plan = PlanText.getEditText().getText().toString().trim();

        Bundle extras = getIntent().getExtras();
        String np = extras.getString("nom");
        String ag = extras.getString("age");
        String sx = extras.getString("sex");
        String ps = extras.getString("poids");
        String tl = extras.getString("taille");
        String objPs = extras.getString("ObjPoids");
        String objSem = extras.getString("ObjSemaines");
        String act = extras.getString("Activite");

        intent.putExtra("nom",np);
        intent.putExtra("age",ag);
        intent.putExtra("sex",sx);
        intent.putExtra("poids",ps);
        intent.putExtra("taille",tl);
        intent.putExtra("ObjPoids",objPs);
        intent.putExtra("ObjSemaines",objSem);
        intent.putExtra("Activite",act);
        intent.putExtra("Plan",Plan);

        startActivity(intent);

        //Toast.makeText(PlanActivity.this,np+" "+ag+" "+sx+" "+ps+" "+tl+" "
                //+objPs+" "+objSem+" "+act+" "+Plan, Toast.LENGTH_LONG).show();
    }
}