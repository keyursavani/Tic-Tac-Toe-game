package com.example.tictactoegame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameWinActivity extends AppCompatActivity {
    TextView textview1;
    ImageView imageview1;
    String win;
    Button btn1;
    String text;
    SharedPreferences ref;
    Integer wining;
    Integer loss;
    Integer draw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_win);

        textview1 = findViewById(R.id.textview1);
        imageview1 = findViewById(R.id.imageview1);
        btn1 = findViewById(R.id.btn1);

        ref = getSharedPreferences("myapp",MODE_PRIVATE);

        SharedPreferences.Editor editor = ref.edit();
        String username = ref.getString("username","username");

        wining = ref.getInt(username+"_win",0);
        loss = ref.getInt(username+"_loss",0);
        draw = ref.getInt(username+"_draw",0);

        Intent intent = getIntent();
        win = intent.getStringExtra("win");
        text = intent.getStringExtra("text");
        textview1.setText(text);
       // textview1.setText(win);

        if (text.equals("Player Two Turn")){
            textview1.setText(username+" Win");
            imageview1.setImageResource(R.drawable.win);
            wining++;
            editor.putInt(username+"_win",wining);
            editor.apply();
        }
        else if (text.equals(username+" turn")){
            textview1.setText("Player Two Win");
            imageview1.setImageResource(R.drawable.win);
            loss++;
            editor.putInt(username+"_loss",loss);
            editor.apply();
        }
        else   {
            textview1.setText("Opps No Any Win");
            imageview1.setImageResource(R.drawable.oops);
            draw++;
            editor.putInt(username+"_draw",draw);
            editor.apply();
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(GameWinActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =  getMenuInflater();
        inflater.inflate(R.menu.scor_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Intent intent = new Intent(GameWinActivity.this,ShowScoreActivity.class);

                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}