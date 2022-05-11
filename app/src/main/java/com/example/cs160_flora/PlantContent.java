package com.example.cs160_flora;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlantContent {
    static final List<Plant> ITEMS = new ArrayList<>();

    public static void loadPlant(String name, Date date, String species) {
//        Plant newItem = new Plant();
//        newItem.name = name;
//        newItem.date = date;
//        newItem.mySpecies = species;
//        addItem(newItem);
    }

    private static void addItem(Plant item) {
        ITEMS.add(0, item);
    }
}
