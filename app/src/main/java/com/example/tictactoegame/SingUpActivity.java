package com.example.tictactoegame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SingUpActivity extends AppCompatActivity {

    EditText edittext1, edittext2, edittext3, edittext4;
    Button button1;
    SharedPreferences ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        getSupportActionBar().hide();

        edittext1 = findViewById(R.id.edittext1);
        edittext2 = findViewById(R.id.edittext2);
        edittext3 = findViewById(R.id.edittext3);
        edittext4 = findViewById(R.id.edittext4);
        button1 = findViewById(R.id.button1);

        ref = getSharedPreferences("myapp",MODE_PRIVATE);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edittext1.getText().toString().length() == 0) {
                    edittext1.setError("Fild is require!");
                } else if (edittext2.getText().toString().length() == 0) {
                    edittext2.setError("Fild is require!");
                } else if (edittext3.getText().toString().length() == 0) {
                    edittext3.setError("Fild is require!");
                } else if (edittext4.getText().toString().length() == 0) {
                    edittext4.setError("Fild is require!");
                } else {

                    Intent intent = new Intent(SingUpActivity.this, LoginActivity.class);

                    String fullname = edittext1.getText().toString();
                    String username = edittext2.getText().toString();
                    String email = edittext3.getText().toString();
                    String password = edittext4.getText().toString();

                    ref.edit().putString("fullname", fullname).apply();
                    ref.edit().putString("username", username).apply();
                    ref.edit().putString("email", email).apply();
                    ref.edit().putString("password", password).apply();
                    ref.edit().putBoolean("login",true).apply();

//                    Toast.makeText(SingUpActivity.this, ""+username+password, Toast.LENGTH_SHORT).show();

                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SingUpActivity.this,LoginActivity.class);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        finish();
        startActivity(intent);
    }
}