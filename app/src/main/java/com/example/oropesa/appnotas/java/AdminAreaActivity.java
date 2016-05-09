package com.example.oropesa.appnotas.java;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.oropesa.appnotas.R;

public class AdminAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_area);

        final Button btAgregar = (Button) findViewById(R.id.btAgregar);
        final Button btConsultar = (Button) findViewById(R.id.btConsultar);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        TextView tvWelcomeMsg = (TextView) findViewById(R.id.tvWelcomeMsg);
        String message ="Bienvenido " + name;
        tvWelcomeMsg.setText(message);

        btAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog mensajeLogin = ProgressDialog.show(AdminAreaActivity.this, "", "Procesando...", true);
                mensajeLogin.show();
                Intent registerIntent = new Intent(AdminAreaActivity.this, RegisterTeacherActivity.class);
                AdminAreaActivity.this.startActivity(registerIntent);
            }
        });

        btConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog mensajeLogin = ProgressDialog.show(AdminAreaActivity.this, "", "Procesando...", true);
                mensajeLogin.show();
                Intent consultIntent = new Intent(AdminAreaActivity.this, ConsultTeacherActivity.class);
                AdminAreaActivity.this.startActivity(consultIntent);
            }
        });

    }
}
