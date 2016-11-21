package com.example.ekasi.reportcardapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {
Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = (Button)findViewById(R.id.login);


btnLogin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent objIntent1 = new Intent(Login.this,Details.class);
        startActivity(objIntent1);
    }
});
    }






}
