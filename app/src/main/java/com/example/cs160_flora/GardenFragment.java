package com.example.cs160_flora;

import android.app.Activity;
import android.content.Intent;
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
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GardenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GardenFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    List<Plant> inventory = new ArrayList<Plant>();
    private InventoryViewModel viewModel;


    public GardenFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GardenFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GardenFragment newInstance(String param1, String param2) {
        GardenFragment fragment = new GardenFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_garden, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(InventoryViewModel.class);
        inventory = viewModel.getPlants().getValue();
        if (inventory == null) {
            viewModel.populate();
            inventory = viewModel.getPlants().getValue();
        }
        viewModel.getPlants().observe(getViewLifecycleOwner(), new Observer<List<Plant>>() {
            @Override
            public void onChanged(@Nullable List<Plant> p) {
                inventory = p;
                setupRecyclerView();
            }
        });

        ImageView addBtn = view.findViewById(R.id.addButton);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Change once add plant screen is created
                Intent intent = new Intent(getActivity(), AddPlantActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        ImageView exploreBtn = view.findViewById(R.id.exploreButton);
        exploreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Change once add plant screen is created
                Intent intent = new Intent(getActivity(), ExploreActivity.class);
                startActivity(intent);
            }
        });
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView myTreesList = getView().findViewById(R.id.plantsList);
        PlantSpeciesAdapter adapter = new PlantSpeciesAdapter(inventory, getActivity(), new OnImageClickListener() {
            @Override
            public void onImageClick(String plantSpecies) {
            }
        });
        myTreesList.setAdapter(adapter);
        myTreesList.setLayoutManager(new GridLayoutManager(getActivity(), 3));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String plantName=data.getStringExtra("plantName");
                Integer imageResource=data.getIntExtra("imageResource",0);
                String plantSpecies=data.getStringExtra("plantSpecies");
                List<Plant> update = viewModel.getPlants().getValue();
                update.add(new Plant(plantName, imageResource, plantSpecies));
                viewModel.setPlants(update);
                System.out.println(viewModel.getPlants().getValue());
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                // Write your code if there's no result
            }
        }
    }
}