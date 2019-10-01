package com.lechitu.chonhinhdv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void RadioBtn (View view){
        ImageView img = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.textView);

        switch (view.getId()){
            case R.id.radioButton4:
                img.setImageDrawable(getResources().getDrawable(R.drawable.cho));
                textView.setText("Con chó");
                break;
            case R.id.radioButton3:
                img.setImageDrawable(getResources().getDrawable(R.drawable.ga));
                textView.setText("Con gà");
                break;
            case R.id.radioButton2:
                img.setImageDrawable(getResources().getDrawable(R.drawable.heo));
                textView.setText("Con heo");
                break;
            case R.id.radioButton:
                img.setImageDrawable(getResources().getDrawable(R.drawable.meo));
                textView.setText("Con mèo");
                break;

        }
    }
    public void hidenImg (View view) {
        Switch hd = findViewById(R.id.switch1);
        ImageView img = findViewById(R.id.imageView);
        if(hd.isChecked()){
            img.setVisibility(View.VISIBLE);
        }
        else {
            img.setVisibility(View.INVISIBLE);
        }
    }
}
