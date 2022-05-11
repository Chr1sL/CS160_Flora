package com.example.cs160_flora;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class TaskViewModel extends ViewModel {
    private MutableLiveData<String> taskName = new MutableLiveData<>();
    public void setTask(String task) {
        taskName.setValue(task);
    }
    public LiveData<String> getTask() {
        return taskName;
    }
}