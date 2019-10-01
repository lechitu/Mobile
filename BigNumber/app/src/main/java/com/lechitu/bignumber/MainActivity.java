package com.lechitu.bignumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void buttonClick (View v){
        Button bt1 = findViewById(R.id.button);
        Button bt2 = findViewById(R.id.button2);

        int value1 = Integer.parseInt(bt1.getText().toString());
        int value2 = Integer.parseInt(bt2.getText().toString());

        TextView point = findViewById(R.id.textView2);

        Context context =getApplicationContext();
        CharSequence text_s = "Success", text_f = "False";

        Random random = new Random();
        boolean check;

        if (R.id.button == v.getId()){
            if (checkValue(value1, value2)){
                check = true;
            }
            else {
                check = false;
            }

        }else {
            if (checkValue(value2, value1)){
                check = true;
            }
            else {
                check = false;
            }
        }

        if (check){
            i++;
            point.setText("Point: "+i);
            Toast.makeText(context, text_s, Toast.LENGTH_SHORT).show();
        } else {
            i--;
            point.setText("Point: "+i);
            Toast.makeText(context, text_f, Toast.LENGTH_SHORT).show();
        }

        bt1.setText(String.valueOf(random.nextInt(200)));
        bt2.setText(String.valueOf(random.nextInt(200)));
    }

    private boolean checkValue(int a, int b) {
        if (a>b) return true;
        else return false;
    }
}
