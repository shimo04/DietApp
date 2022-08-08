package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.textfield.TextInputLayout;

import com.google.firebase.auth.FirebaseAuth;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.FirebaseDatabase;


public class InfoActivity extends AppCompatActivity implements View.OnClickListener
{
    private TextInputLayout EmailText,PasswordText;
    private Button Sv;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        mAuth = FirebaseAuth.getInstance();

        EmailText = (TextInputLayout)findViewById(R.id.AresseId);
        EmailText.setOnClickListener(this);

        PasswordText = (TextInputLayout)findViewById(R.id.PassId);
        PasswordText.setOnClickListener(this);

        Sv = (Button)findViewById(R.id.Suivant);
        Sv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        registerUser();
    }

    private void registerUser()
    {
        String Em = EmailText.getEditText().getText().toString().trim();
        String Ps = PasswordText.getEditText().getText().toString().trim();

        if (Em.isEmpty())
        {
            EmailText.setError("Saisir votre Adresse");
            PasswordText.requestFocus();
            return;
        }

        if (Ps.isEmpty())
        {
            PasswordText.setError("Saisir un mot de passe");
            PasswordText.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(Em,Ps)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>()
                                       {
                                           @Override
                                           public void onComplete(@NonNull Task<AuthResult> task)
                                           {
                                               if(task.isSuccessful())
                                               {
                                                   User user = new User ("","","","","",Em,Ps);
                                                   FirebaseDatabase.getInstance().getReference("Users")
                                                           .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user)
                                                           .addOnCompleteListener(new OnCompleteListener<Void>()
                                                           {
                                                               @Override
                                                               public void onComplete(@NonNull Task<Void> task)
                                                               {
                                                                   if (task.isSuccessful())
                                                                   {
                                                                       //Toast.makeText(InfoActivity.this,"User est ajouté",Toast.LENGTH_LONG).show();
                                                                       startActivity(new Intent(InfoActivity.this,NomPrenomActivity.class));
                                                                   }
                                                                   else
                                                                   {
                                                                       Toast.makeText(InfoActivity.this,"Failed to Register", Toast.LENGTH_LONG).show();
                                                                   }
                                                               }
                                                           });
                                               }
                                           }
                                       }
                );

    }


}