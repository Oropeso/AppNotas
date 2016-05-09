package com.example.oropesa.appnotas.java;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.oropesa.appnotas.R;

import org.json.JSONException;
import org.json.JSONObject;

public class User extends ArrayAdapter<String> {
    private String[] names;
    private String[] usernames;
    private Activity context;

    public User(Activity context, String[] names, String[] usernames) {
        super(context, R.layout.list_view_layout, names);
        this.context = context;
        this.names = names;
        this.usernames = usernames;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_view_layout, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewUsername = (TextView) listViewItem.findViewById(R.id.textViewUsername);

        textViewName.setText(names[position]);
        textViewUsername.setText(usernames[position]);
        return listViewItem;
    }
}
