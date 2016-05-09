package com.example.oropesa.appnotas.java;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJSON {
    public static String[] names;
    public static String[] usernames;

    public static final String JSON_ARRAY = "result";
    public static final String KEY_NAME = "name";
    public static final String KEY_USERNAME = "username";

    private JSONArray users = null;

    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

    protected void parseJSON(){
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            names = new String[users.length()];
            usernames = new String[users.length()];

            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                names[i] = jo.getString(KEY_NAME);
                usernames[i] = jo.getString(KEY_USERNAME);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}