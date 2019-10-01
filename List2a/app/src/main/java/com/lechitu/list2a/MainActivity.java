package com.lechitu.list2a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listCouses;
    ArrayList<String> couses;
    Button btn, updateBtn;
    EditText edt;
    int local;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listCouses = (ListView) findViewById(R.id.lv);
        btn = (Button) findViewById(R.id.addBtn);
        edt = (EditText) findViewById(R.id.editText);
        updateBtn = (Button) findViewById(R.id.updateBtn);
        couses = new ArrayList<>();

        final ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, couses);

        listCouses.setAdapter(adapter);

        listCouses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, couses.get(i), Toast.LENGTH_SHORT).show();
                edt.setText(couses.get(i));
                local = i;
            }
        });

        listCouses.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Removed" + couses.get(i), Toast.LENGTH_SHORT).show();
                couses.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String coursename = edt.getText().toString();
                couses.add(coursename);
                adapter.notifyDataSetChanged();
                edt.setText("");
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                couses.set(local, edt.getText().toString());
                adapter.notifyDataSetChanged();
                edt.setText("");
            }
        });
    }
}
