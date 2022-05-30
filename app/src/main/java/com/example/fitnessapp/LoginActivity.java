package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity
{
    EditText Email,Password;
    Button Login;
    TextView Register,ForgottenPass;

    FirebaseAuth Auth;
    DatabaseReference reference;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = findViewById(R.id.IdEmail);
        Password = findViewById(R.id.IdPassword);
        Login = findViewById(R.id.BtnLogin);
        Register = findViewById(R.id.IdRegister);
        ForgottenPass = findViewById(R.id.IdForgottenPass);

        Auth = FirebaseAuth.getInstance();
        //Login.setOnClickListener(new View.OnClickListener()
        //                               {
                                  //         @Override
          //                                 public void onClick (View view)
           //                            {
          //                                 startActivity(new Intent(LoginActivity.this,MainActivity.class));
          //                             }

            //                           }

            //                   );

        Login.setOnClickListener(new View.OnClickListener()
                                           {
                                            @Override
                                            public void onClick (View view)
                                            {
                                                ProgressDialog pd = new ProgressDialog(LoginActivity.this);
                                                pd.setMessage("please wait");
                                                pd.show();

                                                String strEmail = Email.getText().toString();
                                                String strPass = Password.getText().toString();
                                                if(TextUtils.isEmpty(strEmail) || TextUtils.isEmpty(strPass))
                                                   {Toast.makeText(LoginActivity.this, "all feilds are required", Toast.LENGTH_SHORT).show();}
                                                else
                                                   {
                                                      Auth.signInWithEmailAndPassword(strEmail,strPass).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>()
                                                     {
                                                         @Override
                                                         public void onComplete(@NonNull Task<AuthResult> task)
                                                         {
                                                             if (task.isSuccessful())
                                                             {
                                                                 DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users").child(Auth.getCurrentUser().getUid());
                                                                 reference.addValueEventListener(new ValueEventListener()
                                                                     {
                                                                     @Override
                                                                     public void onDataChange(@NonNull DataSnapshot snapshot)
                                                                     {
                                                                         pd.dismiss();
                                                                         Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                                                         intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                                         startActivity(intent);
                                                                         finish();
                                                                     }

                                                                     @Override
                                                                     public void onCancelled(@NonNull DatabaseError error)
                                                                     {
                                                                         pd.dismiss();
                                                                     }
                                                                 });
                                                             }
                                                             else
                                                             {
                                                                 pd.dismiss();
                                                                 Toast.makeText(LoginActivity.this,"Authentification failed", Toast.LENGTH_SHORT).show();
                                                             }
                                                         }
                                                     }
                                             );
                                         }
                                     }

                                 }

        );

    }

}