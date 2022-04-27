package com.example.cs160_flora;
import android.os.Build;
import androidx.annotation.RequiresApi;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Task {
    public static List<Task> allTasks = new ArrayList<Task>();
    String name;
    String plant;
    String schedule;
    String frequency;
    String timeOfDay;
    boolean setReminder;

    public Task(String myName, String myPlant, String mSchedule, String mFrequency, boolean myReminder, String myTimeOfDay) {
        name = myName;
        plant = myPlant;
        schedule = mSchedule;
        frequency = mFrequency;
        timeOfDay = myTimeOfDay;
        setReminder = myReminder;
    }
}
