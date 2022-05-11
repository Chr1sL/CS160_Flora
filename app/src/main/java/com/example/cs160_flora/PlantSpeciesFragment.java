package com.example.cs160_flora;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlantSpeciesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlantSpeciesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private PlantViewModel viewModel;
    private InventoryViewModel inventoryViewModel;

    List<Plant> plants;
    Map<String, Integer> hm = new HashMap<String, Integer>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PlantSpeciesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlantSpeciesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlantSpeciesFragment newInstance(String param1, String param2) {
        PlantSpeciesFragment fragment = new PlantSpeciesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        viewModel = ViewModelProviders.of(requireActivity()).get(PlantViewModel.class);
        inventoryViewModel = ViewModelProviders.of(this).get(InventoryViewModel.class);

        setUpMap();

        plants = new ArrayList<Plant>();
        plants.add(new Plant("Pink Anthurium", R.drawable.plant0, "Pink Anthurium"));
        plants.add(new Plant("Dieffenbachia", R.drawable.plant1, "Dieffenbachia"));
        plants.add(new Plant("Haworthia", R.drawable.plant2, "Haworthia"));
        plants.add(new Plant("Spider Plant", R.drawable.plant3, "Spider Plant"));
        plants.add(new Plant("Montserra Deliciosa", R.drawable.plant4, "Montserra Deliciosa"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plant_species, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView();
    }

    OnImageClickListener listener = new OnImageClickListener() {
        @Override
        public void onImageClick(String plantSpecies) {
            viewModel.setSpecies(plantSpecies);
            viewModel.setImageResource(hm.get(plantSpecies));
        }

    };

    private void setupRecyclerView() {
        RecyclerView myTreesList = getView().findViewById(R.id.plantsList);
        PlantSpeciesAdapter adapter = new PlantSpeciesAdapter(plants, getActivity(), listener);
        myTreesList.setAdapter(adapter);
        myTreesList.setLayoutManager(new GridLayoutManager(getActivity(), 3));
    }

    private void setUpMap() {
        hm.put("Pink Anthurium", R.drawable.plant0);
        hm.put("Dieffenbachia", R.drawable.plant1);
        hm.put("Haworthia", R.drawable.plant2);
        hm.put("Spider Plant", R.drawable.plant3);
        hm.put("Montserra Deliciosa", R.drawable.plant4);
    }
}