package com.example.cs160_flora;
import android.widget.ImageView;
import java.util.Date;

public class Plant {
    public String name = "";
    public Integer image = 0;
    public String mySpecies = "";

    public Plant(String name, Integer image, String species) {
        this.name = name;
        this.image = image;
        this.mySpecies = species;
    }
}
