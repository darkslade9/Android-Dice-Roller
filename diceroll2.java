package com.example.lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class diceroll2 extends AppCompatActivity {
    String text;
    TextView textreceived;
    Button roll;
    double roll_num, usr_num;
    int[] photos = {R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3, R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6};

    ImageView image;

    Integer maxclicks = 3; Integer currentnumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diceroll2);
        roll = findViewById(R.id.roll);
        text = getIntent().getExtras().getString("Text");
        textreceived = findViewById(R.id.t2);
        textreceived.setText("Welcome "+text);
        image = findViewById(R.id.dice);

        Random x = new Random();
        int j = x.nextInt(6);
        usr_num = j+1;

        Random ran = new Random();



        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentnumber == maxclicks) {
                    roll.setEnabled(false);
                    textreceived.setText("Better luck next time!");
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(diceroll2.this,MainActivity.class);
                            startActivity(intent);
                        }
                    }, 5000);

                }
                else {
                    currentnumber = currentnumber + 1;
                }
                int k = ran.nextInt(6);
                roll_num = k+1;
                image.setImageResource(photos[k]);
                if (roll_num == usr_num){
                    textreceived.setText("Congratulations! You won the game!");
                    roll.setEnabled(false);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(diceroll2.this,MainActivity.class);
                            startActivity(intent);
                        }
                    }, 5000);
                }

            }
        });


    }
}