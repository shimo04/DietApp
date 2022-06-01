package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener
{
    private TextView Banner,BannerDescription;
    private EditText NomPrenomText,AgeText,PoidsText,TailleText,EmailText,PassText;
    private Button RegisterBtn;
    private RadioButton SexTextFemme, SexTextHomme;
    private ProgressBar ProgressB;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        Banner = (TextView)findViewById(R.id.Banner);
        Banner.setOnClickListener(this);

        RegisterBtn = (Button)findViewById(R.id.IdRegister);
        RegisterBtn.setOnClickListener(this);

        NomPrenomText = (EditText)findViewById(R.id.NomPrenom);
        AgeText = (EditText)findViewById(R.id.Age);
        SexTextFemme = (RadioButton)findViewById(R.id.SexF);
        SexTextHomme = (RadioButton)findViewById(R.id.SexH);
        PoidsText = (EditText)findViewById(R.id.Poids);
        TailleText = (EditText)findViewById(R.id.Taille);
        EmailText = (EditText)findViewById(R.id.IdEmail);
        PassText = (EditText)findViewById(R.id.Password);

        ProgressB = (ProgressBar)findViewById(R.id.ProgBar);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.Banner:
                startActivity((new Intent(this,MainActivity.class)));
                break;
            case R.id.IdRegister:
            {
                registerUser();
                break;
            }
        }
    }

    private void registerUser()
    {
        String NP = NomPrenomText.getText().toString().trim();
        String Ag = AgeText.getText().toString().trim();
        String SxF = SexTextFemme.getText().toString().trim();
        String SxH = SexTextHomme.getText().toString().trim();
        String Pd = PoidsText.getText().toString().trim();
        String Tl = TailleText.getText().toString().trim();
        String Em = EmailText.getText().toString().trim();
        String Ps = PassText.getText().toString().trim();
        String Sx ;

        if (NP.isEmpty())
        {
            NomPrenomText.setError("Saisir votre Nom et Prenom");
            NomPrenomText.requestFocus();
            return;
        }
        if (Ag.isEmpty())
        {
            AgeText.setError("saisir votre age");
            AgeText.requestFocus();
            return;
        }
        if (SxH.isEmpty())
        {
            Sx = SxH;
        }
        else
        {
            Sx = SxF;
        }

        if (Pd.isEmpty())
        {
            PoidsText.setError("saisir votre poids");
            PoidsText.requestFocus();
            return;

        }
        if(Tl.isEmpty())
        {
            TailleText.setError("saisir votre taille");
            TailleText.requestFocus();
            return;
        }
        //if (Patterns.EMAIL_ADDRESS.matcher(Em).matches())
        //{
          //  EmailText.setError("saisir votre email");
            //EmailText.requestFocus();
            //return;
        //}

        if (Ps.isEmpty())
        {
            PassText.setError("saisir votre Mot de passe");
            PassText.requestFocus();
            return;
        }
        if(Ps.length() < 6)
        {
            PassText.setError(" votre mot de passe doit etre au min 6 lettres ou chiffres");
            PassText.requestFocus();
            return;
        }

        ProgressB.setVisibility(View.GONE);
        mAuth.createUserWithEmailAndPassword(Em,Ps)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>()
                                                                          {
                                                                              @Override
                                                                              public void onComplete(@NonNull Task<AuthResult> task)
                                                                              {
                                                                                  if(task.isSuccessful())
                                                                                  {
                                                                                      User user = new User (NP,Ag,Sx,Pd,Tl,Em);
                                                                                      FirebaseDatabase.getInstance().getReference("Users")
                                                                                              .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user)
                                                                                              .addOnCompleteListener(new OnCompleteListener<Void>()
                                                                                      {
                                                                                          @Override
                                                                                          public void onComplete(@NonNull Task<Void> task)
                                                                                          {
                                                                                              if (task.isSuccessful())
                                                                                              {
                                                                                                  Toast.makeText(RegisterActivity.this,"User est ajouté",Toast.LENGTH_LONG).show();
                                                                                                  ProgressB.setVisibility((View.VISIBLE));
                                                                                              }
                                                                                              else
                                                                                              {
                                                                                                  Toast.makeText(RegisterActivity.this,"Failed to Register", Toast.LENGTH_LONG).show();
                                                                                                  ProgressB.setVisibility((View.GONE));
                                                                                              }
                                                                                          }
                                                                                      });
                                                                                  }
                                                                              }
                                                                          }
        );

    }
}