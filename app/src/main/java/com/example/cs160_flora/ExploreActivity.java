package com.example.cs160_flora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ExploreActivity extends AppCompatActivity {

    List<Plant> plants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_plant);

        plants = new ArrayList<Plant>();
        plants.add(new Plant("Pink Anthurium", R.drawable.plant0, "Pink Anthurium"));
        plants.add(new Plant("Dieffenbachia", R.drawable.plant1, "Dieffenbachia"));
        plants.add(new Plant("Haworthia", R.drawable.plant2, "Haworthia"));
        plants.add(new Plant("Spider Plant", R.drawable.plant3, "Spider Plant"));
        plants.add(new Plant("Montserra Deliciosa", R.drawable.plant4, "Montserra Deliciosa"));

        ImageView backButton = findViewById(R.id.backIcon);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView myTreesList = findViewById(R.id.plantsList);
        PlantSpeciesAdapter adapter = new PlantSpeciesAdapter(plants, this, new OnImageClickListener() {
            @Override
            public void onImageClick(String plantSpecies) {
            }
        });
        myTreesList.setAdapter(adapter);
        myTreesList.setLayoutManager(new GridLayoutManager(this, 3));
    }
}