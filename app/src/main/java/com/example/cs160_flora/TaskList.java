package com.example.cs160_flora;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TaskList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        ImageButton addTaskBtn = (ImageButton) findViewById(R.id.addButton);
        ImageButton homeBtn = (ImageButton) findViewById(R.id.homeButton);
        ImageButton taskBtn = (ImageButton) findViewById(R.id.taskButton);
        ImageButton addBtn = (ImageButton) findViewById(R.id.addButton);

        addTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TaskList.this, CreateTaskOne.class);
                startActivity(intent);
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TaskList.this, MainActivity.class);
                startActivity(intent);
            }
        });

        taskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Change once task screen is created
                Intent intent = new Intent(TaskList.this, Inventory.class);
                startActivity(intent);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Change once add plant screen is created
                Intent intent = new Intent(TaskList.this, Inventory.class);
                startActivity(intent);
            }
        });
}}
