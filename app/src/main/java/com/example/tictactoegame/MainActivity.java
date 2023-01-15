package com.example.tictactoegame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button buttonnext,buttonlogout;
    SharedPreferences ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        buttonnext = findViewById(R.id.buttonnext);
        buttonlogout = findViewById(R.id.buttonlogout);
        ref = getSharedPreferences("myapp",MODE_PRIVATE);

        String username = ref.getString("username","username");

        buttonnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                ref.edit().putString("username",username).apply();
                startActivity(intent);
            }
        });

        buttonlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                ref.edit().putBoolean("login",false).apply();
                startActivity(intent);
                finish();
            }
        });
    }
}