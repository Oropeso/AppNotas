package com.example.oropesa.appnotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecretaryAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secretary_area);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");


        TextView tvWelcomeMsg = (TextView) findViewById(R.id.tvWelcomeMsg);


        // Display user details
        String message ="Bienvenido " + name;
        tvWelcomeMsg.setText(message);

    }
}
