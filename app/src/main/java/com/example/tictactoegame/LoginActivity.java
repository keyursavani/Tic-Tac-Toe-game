package com.example.tictactoegame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    Button button1;
    EditText edittext1,edittext2;
    TextView textview2;
    SharedPreferences ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        button1 = findViewById(R.id.button1);
        edittext1 = findViewById(R.id.edittext1);
        edittext2 = findViewById(R.id.edittext2);
        textview2 = findViewById(R.id.textview2);

        ref = getSharedPreferences("myapp",MODE_PRIVATE);

        String username = ref.getString("username","username");
        String password = ref.getString("password","password");

        boolean ckeck = ref.getBoolean("login",false);
        if (ckeck){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (edittext1.getText().toString().length() == 0) {
//                    edittext1.setError("User Name is require!");
//                }
//                else if(edittext2.getText().toString().length() == 0){
//                    edittext2.setError("Password is require!");
//                }
//                else {

                     if (username.equals(edittext1.getText().toString()) && password.equals(edittext2.getText().toString())) {
                         ref.edit().putBoolean("login",true).apply();
                         Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                         ref.edit().putString("username",username).apply();

                         startActivity(intent);
                         finish();
                     }
                     else{
                         Toast.makeText(LoginActivity.this, "Invalid UserName and Password", Toast.LENGTH_SHORT).show();
                     }
            }
        });
        textview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SingUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}