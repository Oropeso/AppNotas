package com.example.oropesa.appnotas.java;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.oropesa.appnotas.R;
import com.example.oropesa.appnotas.database.RegisterRequestTeacher;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterTeacherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_teacher);

        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bRegister = (Button) findViewById(R.id.bRegister);

        final Spinner spTipo = (Spinner) findViewById(R.id.spTipo);
        spTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                Toast.makeText(adapterView.getContext(),
                        "Has seleccionado: " + adapterView.getItemAtPosition(position).toString(),
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = etName.getText().toString();
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();
                final String type = spTipo.getSelectedItem().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success && !(username.isEmpty() || name.isEmpty() || password.isEmpty()) || type.isEmpty()) {
                                ProgressDialog mensajeLogin = ProgressDialog.show(RegisterTeacherActivity.this, "", "Procesando...", true);
                                mensajeLogin.show();
                                Intent loginIntent = new Intent(RegisterTeacherActivity.this, AdminAreaActivity.class);
                                RegisterTeacherActivity.this.startActivity(loginIntent);
                                finish();

                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterTeacherActivity.this);
                                builder.setMessage("Error al registrarse")
                                        .setNegativeButton("Reintentar", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequestTeacher registerRequest = new RegisterRequestTeacher(username, name, password, type, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterTeacherActivity.this);
                queue.add(registerRequest);
            }
        });
    }
}