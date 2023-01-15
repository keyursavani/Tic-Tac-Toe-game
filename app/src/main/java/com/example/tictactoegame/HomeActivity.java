package com.example.tictactoegame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    TextView textview1, textview2, textview3;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    int currunt_turn = 0;
    int click = 0;
    int b0, b1, b2, b3, b4, b5, b6, b7, b8,b9,b10,b11,b12,b13,b14,b15,b16,b17;
    String symbol_p1, symbol_p2;
    String firstturn;
    String symbol;
    String text;
    String username;
    SharedPreferences ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        textview1 = findViewById(R.id.textview1);
        textview2 = findViewById(R.id.textview2);
        textview3 = findViewById(R.id.textview3);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);

        ref = getSharedPreferences("myapp",MODE_PRIVATE);
        username = ref.getString("username","username");



        Intent i = getIntent();
        symbol_p1 = i.getStringExtra("symbol_p1");
        symbol_p2 = i.getStringExtra("symbol_p2");
        firstturn = i.getStringExtra("firstturn");

        symbol = i.getStringExtra("symbol");

        textview2.setText(username+" Symbol :- " + symbol_p1);
        textview3.setText("Player two Symbol :- " + symbol_p2);

        if (firstturn.equals("Player One Turn")) {
            currunt_turn = 1;
        } else {
            currunt_turn = 2;
        }
//        if (symbol_p1.equals("cricle")){
//            symbol = "cricle";
//        }
//        else{
//            symbol = "cross";
//        }
//        if (symbol_p1.equals("cricle")) {
//            player = 1;
//        } else {
//            player = 2;
//        }

        if (firstturn.equals("Player Two Turn")){
           textview1.setText(firstturn);
        }else {
            textview1.setText(username+" turn");
        }
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Log.d("One", "btn0");
                if (currunt_turn % 2 == 0) {
                    textview1.setText(username+" turn");
                }
                else {
                    textview1.setText("Player Two Turn");
                }
//                if (currunt_turn % 2 == 0) {
//                    btn0.setText("X");
//                    b0 = 1;
//                }
//                else {
//                    btn0.setText("O");
//                    b9 = 2;
//                }
//                if (player % 2 == 0) {
//                    btn0.setText("O");
//                } else {
//                    btn0.setText("X");
//                }
                if (click == 0 ) {
                    if (symbol.equals("O") && firstturn.equals("Player One Turn")) {
                        btn0.setText("O");
                        b9 = 2;
                        symbol = "X";
                    } else if (symbol.equals("O") && firstturn.equals("Player Two Turn")) {
                        btn0.setText("X");
                        b0 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player One Turn")) {
                        btn0.setText("X");
                        b0 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player Two Turn")) {
                        btn0.setText("O");
                        b9 = 2;
                        symbol = "X";
                    }
                }
                else{
                    if (symbol.equals("O") && firstturn.equals("Player One Turn")) {
                        btn0.setText("O");
                        b9 = 2;
                        symbol = "X";
                    } else if (symbol.equals("O") && firstturn.equals("Player Two Turn")) {
                        btn0.setText("O");
                        b9 = 2;
                        symbol = "X";
                    } else if (symbol.equals("X") && firstturn.equals("Player One Turn")) {
                        btn0.setText("X");
                        b0 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player Two Turn")) {
                        btn0.setText("X");
                        b0 = 1;
                        symbol = "O";
                    }
                }
                currunt_turn++;
                click++;
                winningGame();
                btn0.setEnabled(false);
//                Toast.makeText(HomeActivity.this, "clicked :- "+click, Toast.LENGTH_SHORT).show();

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currunt_turn % 2 == 0) {
                    textview1.setText(username+" turn");
                } else {
                    textview1.setText("Player Two Turn");
                }

                if (click == 0 ){
                    if (symbol.equals("O") && firstturn.equals("Player One Turn")) {
                        btn1.setText("O");
                        b10 = 2;
                        symbol = "X";
                    } else if (symbol.equals("O") && firstturn.equals("Player Two Turn")) {
                        btn1.setText("X");
                        b1 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player One Turn")) {
                        btn1.setText("X");
                        b1 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player Two Turn")) {
                        btn1.setText("O");
                        b10 = 2;
                        symbol = "X";
                    }
                }
                 else {
                    if (symbol.equals("O") && firstturn.equals("Player One Turn")) {
                        btn1.setText("O");
                        b10 = 2;
                        symbol = "X";
                    } else if (symbol.equals("O") && firstturn.equals("Player Two Turn")) {
                        btn1.setText("O");
                        b10 = 2;
                        symbol = "X";
                    } else if (symbol.equals("X") && firstturn.equals("Player One Turn")) {
                        btn1.setText("X");
                        b1 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player Two Turn")) {
                        btn1.setText("X");
                        b1 = 1;
                        symbol = "O";
                    }
                }
                currunt_turn++;
                click++;
                winningGame();
                btn1.setEnabled(false);
//                Toast.makeText(HomeActivity.this, "clicked :- "+click, Toast.LENGTH_SHORT).show();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currunt_turn % 2 == 0) {
                    textview1.setText(username+" turn");
                }
                else {
                    textview1.setText("Player Two Turn");
                }
                if (click == 0){
                    if (symbol.equals("O") && firstturn.equals("Player One Turn")) {
                        btn2.setText("O");
                        b11 = 2;
                        symbol = "X";
                    } else if (symbol.equals("O") && firstturn.equals("Player Two Turn")) {
                        btn2.setText("X");
                        b2 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player One Turn")) {
                        btn2.setText("X");
                        b2 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player Two Turn")) {
                        btn2.setText("O");
                        b11 = 2;
                        symbol = "X";
                    }
                }
                else {
                    if (symbol.equals("O") && firstturn.equals("Player One Turn")) {
                        btn2.setText("O");
                        b11 = 2;
                        symbol = "X";
                    } else if (symbol.equals("O") && firstturn.equals("Player Two Turn")) {
                        btn2.setText("O");
                        b11 = 2;
                        symbol = "X";
                    } else if (symbol.equals("X") && firstturn.equals("Player One Turn")) {
                        btn2.setText("X");
                        b2 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player Two Turn")) {
                        btn2.setText("X");
                        b2 = 1;
                        symbol = "O";
                    }
                }
                currunt_turn++;
                click++;
                winningGame();
                btn2.setEnabled(false);
//                Toast.makeText(HomeActivity.this, "clicked :- "+click, Toast.LENGTH_SHORT).show();

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currunt_turn % 2 == 0) {
                    textview1.setText(username+" turn");
                }
                else {
                    textview1.setText("Player Two Turn");
                }
                if (click == 0){
                    if (symbol.equals("O") && firstturn.equals("Player One Turn")) {
                        btn3.setText("O");
                        b12 = 2;
                        symbol = "X";
                    } else if (symbol.equals("O") && firstturn.equals("Player Two Turn")) {
                        btn3.setText("X");
                        b3 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player One Turn")) {
                        btn3.setText("X");
                        b3 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player Two Turn")) {
                        btn3.setText("O");
                        b12 = 2;
                        symbol = "X";
                    }
                }
                else {
                    if (symbol.equals("O") && firstturn.equals("Player One Turn")) {
                        btn3.setText("O");
                        b12 = 2;
                        symbol = "X";
                    } else if (symbol.equals("O") && firstturn.equals("Player Two Turn")) {
                        btn3.setText("O");
                        b12 = 2;
                        symbol = "X";
                    } else if (symbol.equals("X") && firstturn.equals("Player One Turn")) {
                        btn3.setText("X");
                        b3 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player Two Turn")) {
                        btn3.setText("X");
                        b3 = 1;
                        symbol = "O";
                    }
                }
                currunt_turn++;
                click++;
                winningGame();
                btn3.setEnabled(false);
//                Toast.makeText(HomeActivity.this, "clicked :- "+click, Toast.LENGTH_SHORT).show();

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currunt_turn % 2 == 0) {
                    textview1.setText(username+" turn");
                }
                else {
                    textview1.setText("Player Two Turn");
                }
                if (click ==0){
                    if (symbol.equals("O") && firstturn.equals("Player One Turn")) {
                        btn4.setText("O");
                        b13 = 2;
                        symbol = "X";
                    } else if (symbol.equals("O") && firstturn.equals("Player Two Turn")) {
                        btn4.setText("X");
                        b4 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player One Turn")) {
                        btn4.setText("X");
                        b4 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player Two Turn")) {
                        btn4.setText("O");
                        b13 = 2;
                        symbol = "X";
                    }
                }
                else {
                    if (symbol.equals("O") && firstturn.equals("Player One Turn")) {
                        btn4.setText("O");
                        b13 = 2;
                        symbol = "X";
                    } else if (symbol.equals("O") && firstturn.equals("Player Two Turn")) {
                        btn4.setText("O");
                        b13 = 2;
                        symbol = "X";
                    } else if (symbol.equals("X") && firstturn.equals("Player One Turn")) {
                        btn4.setText("X");
                        b4 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player Two Turn")) {
                        btn4.setText("X");
                        b4 = 1;
                        symbol = "O";
                    }
                }
                currunt_turn++;
                click++;
                winningGame();
                btn4.setEnabled(false);
//                Toast.makeText(HomeActivity.this, "clicked :- "+click, Toast.LENGTH_SHORT).show();

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currunt_turn % 2 == 0) {
                    textview1.setText(username+" turn");
                }
                else {
                    textview1.setText("Player Two Turn");
                }
                if (click == 0){
                    if (symbol.equals("O") && firstturn.equals("Player One Turn")) {
                        btn5.setText("O");
                        b14 = 2;
                        symbol = "X";
                    } else if (symbol.equals("O") && firstturn.equals("Player Two Turn")) {
                        btn5.setText("X");
                        b5 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player One Turn")) {
                        btn5.setText("X");
                        b5 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player Two Turn")) {
                        btn5.setText("O");
                        b14 = 2;
                        symbol = "X";
                    }
                }
                else {
                    if (symbol.equals("O") && firstturn.equals("Player One Turn")) {
                        btn5.setText("O");
                        b14 = 2;
                        symbol = "X";
                    } else if (symbol.equals("O") && firstturn.equals("Player Two Turn")) {
                        btn5.setText("O");
                        b14 = 2;
                        symbol = "X";
                    } else if (symbol.equals("X") && firstturn.equals("Player One Turn")) {
                        btn5.setText("X");
                        b5 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player Two Turn")) {
                        btn5.setText("X");
                        b5 = 1;
                        symbol = "O";
                    }
                }
                currunt_turn++;
                click++;
                winningGame();
                btn5.setEnabled(false);
//                Toast.makeText(HomeActivity.this, "clicked :- "+click, Toast.LENGTH_SHORT).show();

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currunt_turn % 2 == 0) {
                    textview1.setText(username+" turn");
                }
                else {
                    textview1.setText("Player Two Turn");
                }
                if (click == 0){
                    if (symbol.equals("O") && firstturn.equals("Player One Turn")) {
                        btn6.setText("O");
                        b15 = 2;
                        symbol = "X";
                    } else if (symbol.equals("O") && firstturn.equals("Player Two Turn")) {
                        btn6.setText("X");
                        b6 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player One Turn")) {
                        btn6.setText("X");
                        b6 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player Two Turn")) {
                        btn6.setText("O");
                        b15 = 2;
                        symbol = "X";
                    }
                }
                else {
                    if (symbol.equals("O") && firstturn.equals("Player One Turn")) {
                        btn6.setText("O");
                        b15 = 2;
                        symbol = "X";
                    } else if (symbol.equals("O") && firstturn.equals("Player Two Turn")) {
                        btn6.setText("O");
                        b15 = 2;
                        symbol = "X";
                    } else if (symbol.equals("X") && firstturn.equals("Player One Turn")) {
                        btn6.setText("X");
                        b6 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player Two Turn")) {
                        btn6.setText("X");
                        b6 = 1;
                        symbol = "O";
                    }
                }
                currunt_turn++;
                click++;
                winningGame();
                btn6.setEnabled(false);
//                Toast.makeText(HomeActivity.this, "clicked :- "+click, Toast.LENGTH_SHORT).show();

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currunt_turn % 2 == 0) {
                    textview1.setText(username+" turn");
                }
                else {
                    textview1.setText("Player Two Turn");
                }
                if (click == 0){
                    if (symbol.equals("O") && firstturn.equals("Player One Turn")) {
                        btn7.setText("O");
                        b16 = 2;
                        symbol = "X";
                    } else if (symbol.equals("O") && firstturn.equals("Player Two Turn")) {
                        btn7.setText("X");
                        b7 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player One Turn")) {
                        btn7.setText("X");
                        b7 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player Two Turn")) {
                        btn7.setText("O");
                        b16 = 2;
                        symbol = "X";
                    }
                }
                else {
                    if (symbol.equals("O") && firstturn.equals("Player One Turn")) {
                        btn7.setText("O");
                        b16 = 2;
                        symbol = "X";
                    } else if (symbol.equals("O") && firstturn.equals("Player Two Turn")) {
                        btn7.setText("O");
                        b16 = 2;
                        symbol = "X";
                    } else if (symbol.equals("X") && firstturn.equals("Player One Turn")) {
                        btn7.setText("X");
                        b7 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player Two Turn")) {
                        btn7.setText("X");
                        b7 = 1;
                        symbol = "O";
                    }
                }
                currunt_turn++;
                click++;
                winningGame();
                btn7.setEnabled(false);
//                Toast.makeText(HomeActivity.this, "clicked :- "+click, Toast.LENGTH_SHORT).show();

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currunt_turn % 2 == 0) {
                    textview1.setText(username+" turn");
                }
                else {
                    textview1.setText("Player Two Turn");
                }
                if (click == 0){
                    if (symbol.equals("O") && firstturn.equals("Player One Turn")) {
                        btn8.setText("O");
                        b17 = 2;
                        symbol = "X";
                    } else if (symbol.equals("O") && firstturn.equals("Player Two Turn")) {
                        btn8.setText("X");
                        b8 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player One Turn")) {
                        btn8.setText("X");
                        b8 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player Two Turn")) {
                        btn8.setText("O");
                        b17 = 2;
                        symbol = "X";
                    }
                }
                else {
                    if (symbol.equals("O") && firstturn.equals("Player One Turn")) {
                        btn8.setText("O");
                        b17 = 2;
                        symbol = "X";
                    } else if (symbol.equals("O") && firstturn.equals("Player Two Turn")) {
                        btn8.setText("O");
                        b17 = 2;
                        symbol = "X";
                    } else if (symbol.equals("X") && firstturn.equals("Player One Turn")) {
                        btn8.setText("X");
                        b8 = 1;
                        symbol = "O";
                    } else if (symbol.equals("X") && firstturn.equals("Player Two Turn")) {
                        btn8.setText("X");
                        b8 = 1;
                        symbol = "O";
                    }
                }
                currunt_turn++;
                click++;
                winningGame();
                btn8.setEnabled(false);
             //   Toast.makeText(HomeActivity.this, "clicked :- "+click, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void winningGame() {
            if ((b9 == 2) && (b10 == 2) && (b11 == 2)) {
                Intent i1 = new Intent(HomeActivity.this, GameWinActivity.class);
                text = textview1.getText().toString();
                i1.putExtra("text",text);

                ref.edit().putString("username",username).apply();

                startActivity(i1);
                finish();
            } else if ((b12 == 2) && (b13 == 2) && (b14 == 2)) {
                Intent i2 = new Intent(HomeActivity.this, GameWinActivity.class);
                text = textview1.getText().toString();
                i2.putExtra("text",text);

                ref.edit().putString("username",username).apply();

                startActivity(i2);
                finish();
            } else if ((b15 == 2) && (b16 == 2) && (b17 == 2)) {
                Intent i3 = new Intent(HomeActivity.this, GameWinActivity.class);
                text = textview1.getText().toString();
                i3.putExtra("text",text);

                ref.edit().putString("username",username).apply();

                startActivity(i3);
                finish();
            } else if ((b9 == 2) && (b13 == 2) && (b17 == 2)) {
                Intent i4 = new Intent(HomeActivity.this, GameWinActivity.class);
                text = textview1.getText().toString();
                i4.putExtra("text",text);

                ref.edit().putString("username",username).apply();

                startActivity(i4);
                finish();
            } else if ((b11 == 2) && (b13 == 2) && (b15 == 2)) {
                Intent i5 = new Intent(HomeActivity.this, GameWinActivity.class);
                text = textview1.getText().toString();
                i5.putExtra("text",text);

                ref.edit().putString("username",username).apply();

                startActivity(i5);
                finish();
            } else if ((b9 == 2) && (b12 == 2) && (b15 == 2)) {
                Intent i6 = new Intent(HomeActivity.this, GameWinActivity.class);
                text = textview1.getText().toString();
                i6.putExtra("text",text);

                ref.edit().putString("username",username).apply();

                startActivity(i6);
                finish();
            } else if ((b10 == 2) && (b13 == 2) && (b16 == 2)) {
                Intent i7 = new Intent(HomeActivity.this, GameWinActivity.class);
                text = textview1.getText().toString();
                i7.putExtra("text",text);

                ref.edit().putString("username",username).apply();

                startActivity(i7);
                finish();
            } else if ((b11 == 2) && (b14 == 2) && (b17 == 2)) {
                Intent i8 = new Intent(HomeActivity.this, GameWinActivity.class);
                text = textview1.getText().toString();
                i8.putExtra("text",text);

                ref.edit().putString("username",username).apply();

                startActivity(i8);
                finish();
            }

            else if ((b0 == 1) && (b1 == 1) && (b2 == 1)) {
                Intent i9 = new Intent(HomeActivity.this, GameWinActivity.class);
                text = textview1.getText().toString();
                i9.putExtra("text",text);

                ref.edit().putString("username",username).apply();

                startActivity(i9);
                finish();
            } else if ((b3 == 1) && (b4 == 1) && (b5 == 1)) {
                Intent i10 = new Intent(HomeActivity.this, GameWinActivity.class);
                text = textview1.getText().toString();
                i10.putExtra("text",text);

                ref.edit().putString("username",username).apply();

                startActivity(i10);
                finish();
            } else if ((b6 == 1) && (b7 == 1) && (b8 == 1)) {
                Intent i11 = new Intent(HomeActivity.this, GameWinActivity.class);
                text = textview1.getText().toString();
                i11.putExtra("text",text);

                ref.edit().putString("username",username).apply();

                startActivity(i11);
                finish();
            } else if ((b0 == 1) && (b3 == 1) && (b6 == 1)) {
                Intent i12 = new Intent(HomeActivity.this, GameWinActivity.class);
                text = textview1.getText().toString();
                i12.putExtra("text",text);

                ref.edit().putString("username",username).apply();

                startActivity(i12);
                finish();
            } else if ((b1 == 1) && (b4 == 1) && (b7 == 1)) {
                Intent i13 = new Intent(HomeActivity.this, GameWinActivity.class);
                text = textview1.getText().toString();
                i13.putExtra("text",text);

                ref.edit().putString("username",username).apply();

                startActivity(i13);
                finish();
            } else if ((b2 == 1) && (b5 == 1) && (b8 == 1)) {
                Intent i14 = new Intent(HomeActivity.this, GameWinActivity.class);
                text = textview1.getText().toString();
                i14.putExtra("text",text);

                ref.edit().putString("username",username).apply();

                startActivity(i14);
                finish();
            } else if ((b0 == 1) && (b4 == 1) && (b8 == 1)) {
                Intent i15 = new Intent(HomeActivity.this, GameWinActivity.class);
                text = textview1.getText().toString();
                i15.putExtra("text",text);

                ref.edit().putString("username",username).apply();

                startActivity(i15);
                finish();
            } else if ((b2 == 1) && (b4 == 1) && (b6 == 1)) {
                Intent i16 = new Intent(HomeActivity.this, GameWinActivity.class);
                text = textview1.getText().toString();

                ref.edit().putString("username",username).apply();

                i16.putExtra("text",text);
                startActivity(i16);
                finish();
            }
            else if (click == 9) {
                 Intent i17 = new Intent(HomeActivity.this,GameWinActivity.class);
                textview1.setText("No Any Win");
                text = textview1.getText().toString();
                 i17.putExtra("text",text);
                startActivity(i17);
                finish();
            }
    }
}