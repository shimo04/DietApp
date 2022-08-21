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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText EmailText, PassText;
    private Button SvBtn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        EmailText = (EditText) findViewById(R.id.EmailT);
        PassText = (EditText) findViewById(R.id.PassT);

        SvBtn = (Button) findViewById(R.id.Suivant);
        SvBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        registerUser();
    }

    private void registerUser() {
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        String email = EmailText.getText().toString().trim();
        String pass = PassText.getText().toString().trim();

        if (email.isEmpty()) {
            EmailText.setError("saisissez votre adresse mail");
            EmailText.requestFocus();
            return;
        } else if (pass.isEmpty()) {
            PassText.setError("saisissez un mot de passe");
            PassText.requestFocus();
            return;
        }

        Bundle extras = getIntent().getExtras();
        String np = extras.getString("nom");
        String ag = extras.getString("age");
        String sx = extras.getString("sex");
        String ps = extras.getString("poids");
        String tl = extras.getString("taille");
        String objPs = extras.getString("ObjPoids");
        String objSem = extras.getString("ObjSemaines");
        String act = extras.getString("Activite");
        String plan = extras.getString("Plan");

        intent.putExtra("nom", np);
        intent.putExtra("age", ag);
        intent.putExtra("sex", sx);
        intent.putExtra("poids", ps);
        intent.putExtra("taille", tl);
        intent.putExtra("ObjPoids", objPs);
        intent.putExtra("ObjSemaines", objSem);
        intent.putExtra("Activite", act);
        intent.putExtra("Plan", plan);
        intent.putExtra("Email", email);
        intent.putExtra("Password", pass);

        // startActivity(intent);

        //Toast.makeText(RegisterActivity.this,np+" "+ag+" "+sx+" "+ps+" "+tl+" "
        // +objPs+" "+objSem+" "+act+" "+plan+" "+email+" "+pass, Toast.LENGTH_LONG).show();

        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                           @Override
                                           public void onComplete(@NonNull Task<AuthResult> task) {
                                               if (task.isSuccessful()) {
                                                   User user = new User(np, ag, sx, ps, tl, objPs, objSem, act, plan, email, pass);
                                                   FirebaseDatabase.getInstance().getReference("Users")
                                                           .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user)
                                                           .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                               @Override
                                                               public void onComplete(@NonNull Task<Void> task) {
                                                                   if (task.isSuccessful()) {
                                                                       Toast.makeText(RegisterActivity.this, "User est ajouté", Toast.LENGTH_LONG).show();
                                                                       startActivity(intent);
                                                                   } else {
                                                                       Toast.makeText(RegisterActivity.this, "Failed to Register", Toast.LENGTH_LONG).show();

                                                                   }
                                                               }
                                                           });
                                               }
                                           }
                                       }
                );

    }
}

    //if (Patterns.EMAIL_ADDRESS.matcher(Em).matches())
    //{
    //  EmailText.setError("saisir votre email");
    //EmailText.requestFocus();
    //return;
    //}
