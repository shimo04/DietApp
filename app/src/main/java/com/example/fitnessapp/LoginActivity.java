package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.Transition;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener
{
    private TextView registerText,ForgottenPassText;
    private TextInputLayout EmailText,PasswordText;
    private Button SignIn;

    private  FirebaseAuth mAuth;
    private ProgressBar ProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        registerText = (TextView) findViewById(R.id.Register);
        registerText.setOnClickListener(this);

        SignIn =(Button)findViewById(R.id.Login);
        SignIn.setOnClickListener(this);

        EmailText = (TextInputLayout)findViewById(R.id.Email);
        PasswordText = (TextInputLayout)findViewById(R.id.Password);

        ProgressBar = (ProgressBar)findViewById(R.id.ProgBar);
        ProgressBar.setVisibility(View.GONE);

        mAuth = FirebaseAuth.getInstance();
   }

   @Override
    public void onClick(View v)
   {
       switch (v.getId())
       {
           case R.id.Register:
                startActivity((new Intent(this,InfoActivity.class)));
                break;
           case R.id.Login:
               userLogin();
               ProgressBar.setVisibility(View.VISIBLE);
               break;
       }

   }

    private void userLogin()
   {
       String Em = EmailText.getEditText().getText().toString().trim();
       String Pass = PasswordText.getEditText().getText().toString().trim();
       if (Em.isEmpty())
       {
           EmailText.setError("saisir Email");
           EmailText.requestFocus();
           return;
       }
       if (Pass.isEmpty())
       {
           PasswordText.setError("saisir mot de passe");
           PasswordText.requestFocus();
           return;
       }

       mAuth.signInWithEmailAndPassword(Em,Pass)
               .addOnCompleteListener(new OnCompleteListener<AuthResult>()
       {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task)
           {
               if (task.isSuccessful())
               {
                   startActivity(new Intent(LoginActivity.this,MainActivity.class));
               }
               else
               {
                   //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                  // user.sendEmailVerification();
                   //Toast.makeText(LoginActivity.this,"Check your Email",Toast.LENGTH_LONG).show();
                   Toast.makeText(LoginActivity.this,"Failed to connect", Toast.LENGTH_LONG).show();
                   ProgressBar.setVisibility(View.INVISIBLE);
               }
           }
       });

   }
}
