package com.lechitu.list2b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listAnimal;
    ArrayList<Animal> arrayAnimal;
    AnimalAdapter adapter;
    private void Anhxa(){
        listAnimal = (ListView) findViewById(R.id.listAnimal);
        arrayAnimal = new ArrayList<>();

        arrayAnimal.add(new Animal("Chó", "Vật nuôi, 4 chi, thú cưng,giữ nhà, hiền lành", R.drawable.cho));
        arrayAnimal.add(new Animal("Mèo", "Vật nuôi, 4 chi, thú cưng, bắt chuột, hiền lành", R.drawable.meo));
        arrayAnimal.add(new Animal("Gà", "Vật nuôi, 2 chi, lấy thịt", R.drawable.ga));
        arrayAnimal.add(new Animal("Heo", "Vật nuôi, 4 chi, lấy thịt", R.drawable.heo));
        arrayAnimal.add(new Animal("Cá heo", "Sống dưới nước, hiền lành, dễ gần", R.drawable.caheo));
        arrayAnimal.add(new Animal("Chim cánh cụt", "Sống nơi lạnh giá, trên cạn, dưới nước", R.drawable.chimcanhcut));
        arrayAnimal.add(new Animal("Gấu trúc", "Hoang dã, ăn lá cây, hiền lành", R.drawable.gautruc));
        arrayAnimal.add(new Animal("Hổ", "Hoang dã, ăn thịt, nguy hiểm", R.drawable.ho));
        arrayAnimal.add(new Animal("Khỉ", "Hoang dã, leo trèo, ăn trái cây, khá nguy hiểm", R.drawable.khi));
        arrayAnimal.add(new Animal("Ngựa", "Hoang dã, có thể làm vật cưỡi, ăn cỏ", R.drawable.ngua));
        arrayAnimal.add(new Animal("Vịt", "Vật nuôi, lấy thịt", R.drawable.vit));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        adapter = new AnimalAdapter(MainActivity.this, R.layout.activity_animal_line, arrayAnimal);
        listAnimal.setAdapter(adapter);
    }


}
