package com.example.cs160_flora;
import android.os.Build;

import androidx.annotation.RequiresApi;
import java.time.LocalTime;


@RequiresApi(api = Build.VERSION_CODES.O)
public class Task {
    String name = "";
    Plant plant = new Plant();
    String schedule = "";
    String frequency = "";
    LocalTime timeOfDay = LocalTime.now();
    boolean setReminder = true;

    public static void createTask(String name, Plant plant, String schedule, String frequency, boolean reminder, LocalTime timeOfDay) {
        Task newTask = new Task();
        newTask.name = name;
        newTask. plant = plant;
        newTask.schedule = schedule;
        newTask.frequency = frequency;
        newTask.timeOfDay = timeOfDay;
        newTask.setReminder = reminder;
    }


}
