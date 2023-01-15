package com.example.tictactoegame;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowScoreActivity extends AppCompatActivity {
    TextView textview1,textview2,textview3;
    SharedPreferences ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);
        getSupportActionBar().hide();

        ref = getSharedPreferences("myapp",MODE_PRIVATE);

        String username = ref.getString("username","username");

        int win =ref.getInt(username+"_win",0);
        int loss =ref.getInt(username+"_loss",0);
        int draw =ref.getInt(username+"_draw",0);


        textview1 = findViewById(R.id.textview1);
        textview2 = findViewById(R.id.textview2);
        textview3 = findViewById(R.id.textview3);

        textview1.setText("win game by "+username+""+" :- " +win);
        textview2.setText("loss game by "+username+""+ " :- "+loss);
        textview3.setText("Total draw game "+"" + " :- "+draw);

    }
}