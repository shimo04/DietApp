package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity
{
    private TextView LogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogOut = (TextView)findViewById(R.id.Logout);
        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });
    }
}