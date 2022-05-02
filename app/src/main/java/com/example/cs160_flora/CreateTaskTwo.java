package com.example.cs160_flora;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class CreateTaskTwo extends AppCompatActivity {

    TableLayout plants;
    Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task_two);
        plants = findViewById(R.id.tableLayout);
        Plant[] plantList = new Plant[10]; // put plant list
        int plantSize = 0; // size of plants list
        int rows = 3;
        int cols = 0;
        if (plantSize > 3) {
            cols = (int) Math.ceil(plantSize/3);
        } else {
            cols = 1;
            rows = plantSize;
        }
        for (int i = 0; i < cols; i++) {
            TableRow tableRow = new TableRow(this);
            for (int j = 0; j < rows; j++) {
                Plant currPlant = plantList[(i*3)+j];

                ImageView plantImage = currPlant.image;
                TextView plantName = new TextView(this);
                plantName.setText(currPlant.name);
                TextView specie = new TextView(this);
                specie.setText(currPlant.mySpecies);

                TableLayout plantCell = new TableLayout(this);
                plantCell.addView(plantImage);
                plantCell.addView(plantName);
                plantCell.addView(specie);

                tableRow.addView(plantCell);

                plantCell.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(View view) {
                        String name = (String) getIntent().getSerializableExtra("Name");
                        String[] intents = new String[]{name, currPlant.name};
                        Intent intent = new Intent(getApplicationContext(), CreateTaskThree.class);
                        intent.putExtra("Args", intents);
                        startActivity(intent);
                    }
                });

                next = findViewById(R.id.button);
                next.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), CreateTaskThree.class);
                        startActivity(intent);
                    }});
            }
        }

    }
}