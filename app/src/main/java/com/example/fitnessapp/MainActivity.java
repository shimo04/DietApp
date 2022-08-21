package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView LogOut;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef,ref;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11;
    private String np,age,sex,poids,taille,objPoids,objSem,act,plan,email,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = findViewById(R.id.text1);
        txt2 = findViewById(R.id.text2);
        txt3 = findViewById(R.id.text3);
        txt4 = findViewById(R.id.text4);
        txt5 = findViewById(R.id.text5);
        txt6 = findViewById(R.id.text6);
        txt7 = findViewById(R.id.text7);
        txt8 = findViewById(R.id.text8);
        txt9 = findViewById(R.id.text9);
        txt10 = findViewById(R.id.text10);
        txt11 = findViewById(R.id.text11);

        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference();
        ref = mRef.child("Users");

        ref.child(mAuth.getCurrentUser().getUid().toString()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                                                                @Override
                                                                                public void onComplete(@NonNull Task<DataSnapshot> task)
                                                                                {
                                                                                    if(task.isSuccessful())
                                                                                    {
                                                                                        if(task.getResult().exists())
                                                                                        {
                                                                                            DataSnapshot dataSnapshot = task.getResult();
                                                                                            np = String.valueOf(dataSnapshot.child("NomPrenom").getValue());
                                                                                            age = String.valueOf(dataSnapshot.child("Age").getValue());
                                                                                            sex = String.valueOf(dataSnapshot.child("Sex").getValue());
                                                                                            poids = String.valueOf(dataSnapshot.child("Poids").getValue());
                                                                                            taille = String.valueOf(dataSnapshot.child("Taille").getValue());
                                                                                            objPoids = String.valueOf(dataSnapshot.child("ObjectifPoids").getValue());
                                                                                            objSem = String.valueOf(dataSnapshot.child("ObjectifSemaines").getValue());
                                                                                            act = String.valueOf(dataSnapshot.child("ActivitePhysique").getValue());
                                                                                            plan = String.valueOf(dataSnapshot.child("Plan").getValue());
                                                                                            email = String.valueOf(dataSnapshot.child("Email").getValue());
                                                                                            pass = String.valueOf(dataSnapshot.child("Pass").getValue());

                                                                                            txt1.setText("Nom et Prenom : "+np.toString());
                                                                                            txt2.setText("Age : "+age.toString()+" ans");
                                                                                            txt3.setText("Sex : "+sex.toString());
                                                                                            txt4.setText("Poids : "+poids.toString()+" kg");
                                                                                            txt5.setText("Taile : "+taille.toString()+" cm");
                                                                                            txt6.setText("Objectif Poids : "+objPoids.toString()+" kg");
                                                                                            txt7.setText("En : "+objSem.toString()+" semaines");
                                                                                            txt8.setText("Activité physique : "+act.toString());
                                                                                            txt9.setText("Programme choisi : "+plan.toString());
                                                                                            txt10.setText("Emai: : "+email.toString());
                                                                                            txt11.setText("Mot de passe : "+pass.toString());
                                                                                        }
                                                                                        else
                                                                                        {
                                                                                            Toast.makeText(MainActivity.this,"does not exist", Toast.LENGTH_SHORT).show();

                                                                                        }
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        Toast.makeText(MainActivity.this,"failed", Toast.LENGTH_SHORT).show();
                                                                                    }
                                                                                }
                                                                            }
        );




        LogOut = (TextView)findViewById(R.id.Logout);
        LogOut.setOnClickListener(this) ;


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        navigationView = (NavigationView) findViewById(R.id.nav);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.menu_Open,R.string.menu_Close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId())
                {
                    case R.id.home:
                        Log.i("HomeDreamer","Home is not clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.home2:
                        Log.i("HomedDreamer","Home is not clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.home3:
                        Log.i("HomeDreameer","Home is not clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.home4:
                        Log.i("HomeDrteamer","Home is not clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.home5:
                        Log.i("HomeDrepamer","Home is not clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
        {return true;}

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v)
    {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(MainActivity.this,LoginActivity.class));
    }
}
