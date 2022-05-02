package com.example.cs160_flora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton gardenBtn = (ImageButton) findViewById(R.id.gardenButton);
        ImageButton taskBtn = (ImageButton) findViewById(R.id.taskButton);

        gardenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Inventory.class);
                startActivity(intent);
            }
        });

        taskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Change once task screen is created
                Intent intent = new Intent(MainActivity.this, TaskList.class);
                startActivity(intent);
            }
        });
    }
}