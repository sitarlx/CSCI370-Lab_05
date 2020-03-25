package com.introtoandroid.labfive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.EventListener;

public class MainActivity extends AppCompatActivity {

    TextView val;
    EditText newName;
    Button change;
    SharedPreferences sharedPref;
    public static final String myPreference = "myPref";
    public static final String name = "nameKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val = findViewById(R.id.valueTxt);
        newName = findViewById(R.id.editName);
        change = findViewById(R.id.changeButton);
        sharedPref = getSharedPreferences(myPreference, Context.MODE_PRIVATE);
        if (sharedPref.contains(name)) {
            val.setText(sharedPref.getString(name, ""));
        }

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val.setText(newName.getText());
            }
        });
    }

    public void Submit(View v){
        String s = newName.getText().toString();
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(name, s);
        editor.commit();
    }
}
