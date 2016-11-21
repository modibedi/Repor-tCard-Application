package com.example.ekasi.reportcardapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Student_login_menu extends AppCompatActivity {
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_menu);
        btnLogin = (Button)findViewById(R.id.lecture);


    }

    public void StartActivityLogin(View view) {
        Intent objIntent1 = new Intent(Student_login_menu.this,Login.class);
        startActivity(objIntent1);
    }

    public void StartActivityRegistration(View view) {
        Intent objIntent1 = new Intent(Student_login_menu.this,Registration.class);
        startActivity(objIntent1);
    }

}
