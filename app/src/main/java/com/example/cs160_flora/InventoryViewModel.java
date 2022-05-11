package com.example.cs160_flora;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InventoryViewModel extends ViewModel {
    private MutableLiveData<List<Plant>> inventory = new MutableLiveData<>();
    public void setPlants(List<Plant> newPlants) {
        inventory.setValue(newPlants);
    }
    public LiveData<List<Plant>> getPlants() {
        return inventory;
    }
    public void populate() {
        List<Plant> newPlants = new ArrayList<Plant>();
        newPlants.add(new Plant("Jack O'Lantern", R.drawable.plant0, "Pink Anthurium"));
        newPlants.add(new Plant("Bruno Mars", R.drawable.plant1, "Dieffenbachia"));
        inventory.setValue(newPlants);
    }
}