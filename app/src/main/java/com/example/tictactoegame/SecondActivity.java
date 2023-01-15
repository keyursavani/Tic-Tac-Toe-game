package com.example.tictactoegame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
Button buttonnext;
RadioGroup radiogroup;
RadioButton radioobutton1,radiobutton2;
    SharedPreferences ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().hide();
        buttonnext = findViewById(R.id.buttonnext);
        radiogroup = findViewById(R.id.radiogroup);
        radioobutton1 = findViewById(R.id.radiobutton1);
        radiobutton2 = findViewById(R.id.radiobutton2);

        ref = getSharedPreferences("myapp",MODE_PRIVATE);

        String username = ref.getString("username","username");

        buttonnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (radiogroup.getCheckedRadioButtonId()== radioobutton1.getId()){
                    Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                     intent.putExtra("symbol_p1","O");
                     intent.putExtra("symbol_p2","X");
                     intent.putExtra("symbol","O");

                    ref.edit().putString("username",username).apply();

                    startActivity(intent);
                }
                else if(radiogroup.getCheckedRadioButtonId() == radiobutton2.getId()){
                    Intent i = new Intent(SecondActivity.this,ThirdActivity.class);
                    i.putExtra("symbol_p1","X");
                    i.putExtra("symbol_p2","O");
                    i.putExtra("symbol","X");

                    ref.edit().putString("username",username).apply();

                    startActivity(i);
                }
                else{
                    Toast.makeText(SecondActivity.this, "Please Select Your Symbol", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}