package com.example.cs160_flora;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inventory extends AppCompatActivity {

    List<String> plants = Arrays.asList("Pink Anthurium", "Dieffenbachia", "Haworthia", "Spider Plant", "Montserra Deliciosa");
    List<Plant> inventory = new ArrayList<Plant>();
    private InventoryViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        viewModel = ViewModelProviders.of(this).get(InventoryViewModel.class);
        inventory = viewModel.getPlants().getValue();
        if (inventory == null) {
            viewModel.populate();
            inventory = viewModel.getPlants().getValue();
        }
        viewModel.getPlants().observe(this, new Observer<List<Plant>>() {
            @Override
            public void onChanged(@Nullable List<Plant> p) {
                inventory = p;
                setupRecyclerView();
            }
        });

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
                startActivityForResult(intent, 1);
            }
        });

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView myTreesList = findViewById(R.id.plantsList);
        PlantSpeciesAdapter adapter = new PlantSpeciesAdapter(inventory, Inventory.this, new OnImageClickListener() {
            @Override
            public void onImageClick(String plantSpecies) {
            }
        });
        myTreesList.setAdapter(adapter);
        myTreesList.setLayoutManager(new GridLayoutManager(Inventory.this, 3));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String plantName=data.getStringExtra("plantName");
                Integer imageResource=data.getIntExtra("imageResource",0);
                String plantSpecies=data.getStringExtra("plantSpecies");
                List<Plant> update = viewModel.getPlants().getValue();
                update.add(new Plant(plantName, imageResource, plantSpecies));
                viewModel.setPlants(update);
                System.out.println(viewModel.getPlants().getValue());
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                // Write your code if there's no result
            }
        }
    }

    //    @Override
//    public void onListFragmentInteraction(DummyContent.DummyItem item) {
//    }
}