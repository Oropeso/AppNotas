package com.example.oropesa.appnotas.database;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Oropesa on 19/04/2016.
 */
public class ConsultRequestTeacher extends StringRequest {
    //private static final String LOGIN_REQUEST_URL = "http://damnotas.site88.net/Login.php";
    //private static final String LOGIN_REQUEST_URL = "http://appnotas.ddns.net:8080/Login.php";
    private static final String LOGIN_REQUEST_URL = "http://192.168.1.106:8080/appnotas/ConsultaTeacher.php";
    private Map<String, String> params;

    public ConsultRequestTeacher(Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}