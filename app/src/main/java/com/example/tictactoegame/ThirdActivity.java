package com.example.tictactoegame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ThirdActivity extends AppCompatActivity {
    TextView textview4,textview5,textview6;
    Button button1,button2,button3;
    int click = 0;
    int random1,random2;
    String turn,turn2;
    SharedPreferences ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        getSupportActionBar().hide();

        textview4 = findViewById(R.id.textview4);
        textview5 = findViewById(R.id.textview5);
        textview6 = findViewById(R.id.textview6);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        ref = getSharedPreferences("myapp",MODE_PRIVATE);
        String username = ref.getString("username","username");


        Intent i = getIntent();

        String symbol_p1 = i.getStringExtra("symbol_p1");
        String symbol_p2 = i.getStringExtra("symbol_p2");
        String symbol = i.getStringExtra("symbol");

      //  Toast.makeText(ThirdActivity.this, "symbol :- "+symbol, Toast.LENGTH_SHORT).show();


      //  Toast.makeText(ThirdActivity.this, ""+symbol_p1+symbol_p2, Toast.LENGTH_SHORT).show();


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                random1 = new Random().nextInt(100);
                textview4.setText(""+random1);
                click++;
                button1.setEnabled(false);
                if (click == 2){
                    if(random1 > random2){
                        textview6.setText("First Turn :- "+username+"'s turn");
                        turn = "Player One Turn";
                      //  turn2 = username;
                    }
                    else{
                        textview6.setText("First Turn :- Player Two's turn");
                        turn = "Player Two Turn";;
                    }
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                random2 = new Random().nextInt(100);
                textview5.setText(""+random2);
                click++;
                button2.setEnabled(false);
                if (click == 2){
                    if(random1 > random2){
                        textview6.setText("First Turn :- "+username+"'s turn");
                        turn = "Player One Turn";
                      //  turn2 = username;
                    }
                    else{
                        textview6.setText("First Turn :- Player Two's turn");
                        turn = "Player Two Turn";
                    }
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(click == 2) {
                    Intent intent = new Intent(ThirdActivity.this, HomeActivity.class);
                    intent.putExtra("symbol_p1", symbol_p1);
                    intent.putExtra("symbol_p2", symbol_p2);
                    intent.putExtra("firstturn", turn);
                    intent.putExtra("symbol", symbol);
                   // intent.putExtra("turn2",turn2);

                    ref.edit().putString("username",username).apply();

                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(ThirdActivity.this, "Plese select both button", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}