package com.example.oropesa.appnotas;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AdminAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_area);

        final TextView tvRegisterTeacherLink = (TextView) findViewById(R.id.tvRegisterTeacherLink);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        TextView tvWelcomeMsg = (TextView) findViewById(R.id.tvWelcomeMsg);
        String message ="Bienvenido " + name;
        tvWelcomeMsg.setText(message);

        tvRegisterTeacherLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog mensajeLogin = ProgressDialog.show(AdminAreaActivity.this, "", "Procesando...", true);
                mensajeLogin.show();
                Intent registerIntent = new Intent(AdminAreaActivity.this, RegisterTeacherActivity.class);
                AdminAreaActivity.this.startActivity(registerIntent);
            }
        });

    }
}
