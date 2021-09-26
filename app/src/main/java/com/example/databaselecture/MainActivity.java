package com.example.databaselecture;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name, password;
    Button save, display;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.et_username);
        password = (EditText) findViewById(R.id.et_password);
        save = (Button) findViewById(R.id.btn_save);
        display = (Button) findViewById(R.id.btn_display);
        sharedPreferences = getSharedPreferences("myinfo", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        save.setOnClickListener(this);
        display.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                editor.putString("name", name.getText().toString());
                editor.putString("pass", password.getText().toString());
                editor.commit();
                Toast.makeText(getApplicationContext(), "SUSSESSFULL", Toast.LENGTH_LONG).show();

                break;
            case R.id.btn_display:
                SharedPreferences mshare = getSharedPreferences("myinfo", MODE_PRIVATE);
                String text = mshare.getString("name", "sorry");
                String text1 = mshare.getString("pass", "sorry");
                name.setText(text);
                password.setText(text1);

                break;
        }
    }
}
