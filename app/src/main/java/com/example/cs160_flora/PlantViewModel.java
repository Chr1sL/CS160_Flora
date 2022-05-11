package com.example.cs160_flora;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlantViewModel extends ViewModel {
    private MutableLiveData<String> mName = new MutableLiveData<>();
    public void setName(String name) {
        mName.setValue(name);
    }
    public LiveData<String> getName() {
        return mName;
    }

    private MutableLiveData<String> mSpecies = new MutableLiveData<>();
    public void setSpecies(String species) {
        mSpecies.setValue(species);
    }
    public LiveData<String> getSpecies() {
        return mSpecies;
    }

    private MutableLiveData<Integer> mImage = new MutableLiveData<>();
    public void setImageResource(Integer image) {
        mImage.setValue(image);
    }
    public LiveData<Integer> getImageResource() {
        return mImage;
    }
}
