package com.example.cs160_flora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Inventory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        ImageButton homeBtn = (ImageButton) findViewById(R.id.homeButton);
        ImageButton taskBtn = (ImageButton) findViewById(R.id.taskButton);
        ImageButton addBtn = (ImageButton) findViewById(R.id.addButton);
        ImageButton viewPlantBtn = (ImageButton) findViewById(R.id.plant1);

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
                Intent intent = new Intent(Inventory.this, Inventory.class);
                startActivity(intent);
            }
        });

        viewPlantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Inventory.this, viewPlant.class);
                startActivity(intent);
            }
        });
    }
}