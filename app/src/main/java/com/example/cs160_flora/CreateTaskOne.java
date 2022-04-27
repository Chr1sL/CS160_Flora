package com.example.cs160_flora;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CreateTaskOne extends AppCompatActivity {

    TextView back;
    TextView nameField;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task_one);
        back = findViewById(R.id.textView);
        next = findViewById(R.id.button);
        next.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                nameField = findViewById(R.id.textView4);
                String taskName = nameField.getText().toString();
                Intent intent = new Intent(getApplicationContext(), CreateTaskTwo.class);
                intent.putExtra("Name", taskName);
                startActivity(intent);
            }});
    }
}