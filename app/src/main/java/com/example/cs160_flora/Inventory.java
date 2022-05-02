package com.example.cs160_flora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Arrays;
import java.util.List;

public class Inventory extends AppCompatActivity implements plantFragment.OnListFragmentInteractionListener {

    List<String> plants = Arrays.asList("Pink Anthurium", "Dieffenbachia", "Haworthia", "Spider Plant", "Montserra Deliciosa");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        ImageButton homeBtn = (ImageButton) findViewById(R.id.homeButton);
        ImageButton taskBtn = (ImageButton) findViewById(R.id.taskButton);
        ImageButton addBtn = (ImageButton) findViewById(R.id.addButton);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Inventory.this, MainActivity.class);
                startActivity(intent);
            }
        });

        taskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Change once task screen is created
                Intent intent = new Intent(Inventory.this, Inventory.class);
                startActivity(intent);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Change once add plant screen is created
                Intent intent = new Intent(Inventory.this, AddPlantActivity.class);
                startActivity(intent);
            }
        });

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView myTreesList = findViewById(R.id.plantsList);
        PlantSpeciesAdapter adapter = new PlantSpeciesAdapter(plants, Inventory.this);
        myTreesList.setAdapter(adapter);
        myTreesList.setLayoutManager(new GridLayoutManager(Inventory.this, 3));
    }

//    @Override
//    public void onListFragmentInteraction(DummyContent.DummyItem item) {
//    }
}