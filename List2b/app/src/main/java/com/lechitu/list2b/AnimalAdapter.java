package com.lechitu.list2b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AnimalAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Animal> animalList;

    public AnimalAdapter(Context context, int layout, List<Animal> animalList) {
        this.context = context;
        this.layout = layout;
        this.animalList = animalList;
    }

    @Override
    public int getCount() {
        return animalList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        TextView txtTen = (TextView) view.findViewById(R.id.nameAnimal);
        TextView txtMota = (TextView) view.findViewById(R.id.textView2);
        ImageView imgHinh = (ImageView) view.findViewById(R.id.imageView);

        Animal animal = animalList.get(i);
        txtTen.setText(animal.getTen());
        txtMota.setText(animal.getMota());
        imgHinh.setImageResource(animal.getHinh());


        return view;
    }
}
