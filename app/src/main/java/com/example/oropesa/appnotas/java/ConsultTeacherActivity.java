package com.example.oropesa.appnotas.java;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.oropesa.appnotas.R;

import java.util.ArrayList;

public class ConsultTeacherActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String JSON_URL = "http://192.168.1.106:8080/appnotas/ConsultaTeacher.php";

    private Button btContulta;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_teacher);

        btContulta = (Button) findViewById(R.id.btContulta);
        btContulta.setOnClickListener(this);
        listView = (ListView) findViewById(R.id.lResult);
    }

    private void sendRequest(){
        StringRequest stringRequest = new StringRequest(JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ConsultTeacherActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String json){
        ParseJSON pj = new ParseJSON(json);
        pj.parseJSON();
        User cl = new User(this, ParseJSON.names, ParseJSON.usernames);
        listView.setAdapter(cl);
    }

    @Override
    public void onClick(View v) {
        sendRequest();
    }
}