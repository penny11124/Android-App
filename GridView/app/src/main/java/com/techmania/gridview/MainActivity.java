package com.techmania.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView girdView;
    ArrayList<String> text = new ArrayList<>();
    ArrayList<Integer> image = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        girdView = findViewById(R.id.gridView);
        fillArray();
        GridAdapter adapter = new GridAdapter(this,text,image);
        girdView.setAdapter(adapter);

        girdView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"You selected "+text.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void fillArray(){
        text.add("Butterfly");
        text.add("Cat");
        text.add("Flower");
        text.add("Hippo");
        text.add("Monkey");
        text.add("Mushroom");
        text.add("Panda");
        text.add("Rabbit");
        text.add("Raccoon");

        image.add(R.drawable.butterfly);
        image.add(R.drawable.cat);
        image.add(R.drawable.flower);
        image.add(R.drawable.hippo);
        image.add(R.drawable.monkey);
        image.add(R.drawable.mushroom);
        image.add(R.drawable.panda);
        image.add(R.drawable.rabbit);
        image.add(R.drawable.raccoon);
    }
}