package com.example.cs160_flora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;

public class CreateTaskThree extends AppCompatActivity {
    Spinner schedule;
    Spinner frequency;
    Spinner time;
    Switch reminder;
    Button createTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task_three);
        schedule = findViewById(R.id.spinner);
        frequency = findViewById(R.id.spinner2);
        time = findViewById(R.id.spinner3);
        reminder = findViewById(R.id.switch1);
        createTask = findViewById(R.id.button);

        createTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taskSchedule = schedule.getSelectedItem().toString();
                String taskFreq = frequency.getSelectedItem().toString();
                String taskTime = time.getSelectedItem().toString();
                boolean taskReminder =  reminder.isChecked();
                String[] args = (String[]) getIntent().getSerializableExtra("Args");
                String name = args[0];
                String plant = args[1];
                Task task = new Task(name, plant, taskSchedule, taskFreq, taskReminder, taskTime);
                Task.allTasks.add(task);
            }
        });
    }
}