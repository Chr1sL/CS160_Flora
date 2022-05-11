package com.example.cs160_flora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class viewPlant extends AppCompatActivity {

    String plantName;
    String plantSpecies;
    Map<String, Integer> hm = new HashMap<String, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_plant);
        setUpMap();

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            plantName = extras.getString("plantName");
            plantSpecies = extras.getString("plantSpecies");
        }

        TextView plantName_tv = findViewById(R.id.viewPlantName);
        plantName_tv.setText(plantName);
        TextView plantSpecies_tv = findViewById(R.id.viewPlantSpecies);
        plantSpecies_tv.setText(plantSpecies);

        ImageView plantImage = findViewById(R.id.plantImage);
        plantImage.setBackgroundResource(hm.get(plantSpecies));

        ImageView backButton = findViewById(R.id.backIcon);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setUpMap() {
        hm.put("Pink Anthurium", R.drawable.plant0);
        hm.put("Dieffenbachia", R.drawable.plant1);
        hm.put("Haworthia", R.drawable.plant2);
        hm.put("Spider Plant", R.drawable.plant3);
        hm.put("Montserra Deliciosa", R.drawable.plant4);
    }
}