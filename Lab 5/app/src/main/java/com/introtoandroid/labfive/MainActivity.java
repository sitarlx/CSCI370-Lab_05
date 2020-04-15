package com.introtoandroid.labfive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.EventListener;

public class MainActivity extends AppCompatActivity {

    private TextView val;
    private EditText newName;
    private Button change;

    private SharedPreferences myPreference;
    private SharedPreferences.Editor myEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val = findViewById(R.id.valueTxt);
        newName = findViewById(R.id.editName);
        change = findViewById(R.id.changeButton);

        myPreference = PreferenceManager.getDefaultSharedPreferences(this);
        myEditor = myPreference.edit();

        myEditor.putString("key", newName.getText().toString());
        myEditor.commit();

        myPreference.getString("key", "");

        checkSharedPreferences();

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val.setText(newName.getText());
                myEditor.putString(getString(R.string.val), val.getText().toString());
                myEditor.commit();
            }
        });
    }

    private void checkSharedPreferences(){
        String savedName = myPreference.getString(getString(R.string.val), "");
        val.setText(savedName);
    }

}
