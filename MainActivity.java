package com.example.lab;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button start;
    EditText name_val;
    TextView res;
    ImageView pic;
    String n;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.start);
        name_val = findViewById(R.id.name);
        res = findViewById(R.id.name);
        pic = findViewById(R.id.dice);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n = name_val.getText().toString();
                Intent intent = new Intent(MainActivity.this,diceroll2.class);
                intent.putExtra("Text", n);
                startActivity(intent);
            }
        });
    }
}