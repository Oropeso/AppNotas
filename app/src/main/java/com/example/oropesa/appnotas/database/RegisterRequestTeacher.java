package com.example.oropesa.appnotas.database;

import android.app.NotificationManager;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class RegisterRequestTeacher extends StringRequest {
    //private static final String REGISTER_REQUEST_URL = "http://damnotas.site88.net/Register.php";
    //private static final String REGISTER_REQUEST_URL = "http://10.0.2.2:8080/appnotas/Register.php"; //Referencia a localhost
    //private static final String REGISTER_REQUEST_URL = "http://192.168.1.106:8080/appnotas/Register.php"; //local
    private static final String REGISTER_REQUEST_URL = "http://192.168.1.106:8080/appnotas/RegisterTeacher.php";

    private Map<String, String> params;

    public RegisterRequestTeacher(String username, String name, String password, String type, Response.Listener<String> listener) {
        super(Request.Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        if((username.isEmpty() || name.isEmpty() || password.isEmpty()) || type.isEmpty()){
           //Crear mensaje de alerta (No context)
        }else{
            params.put("username", username);
            params.put("name", name);
            params.put("password", password);
            params.put("type", type.toLowerCase());
        }

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}