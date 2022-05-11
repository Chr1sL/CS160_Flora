package com.example.cs160_flora;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TaskSpeciesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TaskSpeciesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    List<Plant> plants;

    public TaskSpeciesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TaskSpeciesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TaskSpeciesFragment newInstance(String param1, String param2) {
        TaskSpeciesFragment fragment = new TaskSpeciesFragment();
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
        return inflater.inflate(R.layout.fragment_task_species, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView myTreesList = getView().findViewById(R.id.plantsList);
        PlantSpeciesAdapter adapter = new PlantSpeciesAdapter(plants, getActivity(), new OnImageClickListener() {
            @Override
            public void onImageClick(String plantSpecies) {

            }
        });
        myTreesList.setAdapter(adapter);
        myTreesList.setLayoutManager(new GridLayoutManager(getActivity(), 3));
    }
}