package com.example.cs160_flora;
import android.os.Build;
import androidx.annotation.RequiresApi;
import java.time.LocalTime;
@RequiresApi(api = Build.VERSION_CODES.O)

public class Task {
    String name;
    Plant plant;
    String schedule;
    String frequency;
    LocalTime timeOfDay;
    boolean setReminder;
    public void createTask(String myName) {
        name = myName;
    }
    public void selectPlant(Plant myPlant) {
        plant = myPlant;
    }
    public void selectSchedule(String mSchedule) {
        schedule = mSchedule;
    }
    public void setSchedule(String mFrequency, boolean myReminder, LocalTime myTimeOfDay) {
        frequency = mFrequency;
        timeOfDay = myTimeOfDay;
        setReminder = myReminder;
    }
}
