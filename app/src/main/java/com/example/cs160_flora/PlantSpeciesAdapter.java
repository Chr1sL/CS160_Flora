package com.example.cs160_flora;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.List;

public class PlantSpeciesAdapter extends RecyclerView.Adapter<PlantSpeciesAdapter.ViewHolder>{
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public ImageView selectedOverlay;
        public ImageView checked;
        public ConstraintLayout plantCardView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            nameTextView = itemView.findViewById(R.id.plant_name);
            plantCardView = itemView.findViewById(R.id.plant_card);
            selectedOverlay = itemView.findViewById(R.id.selected_overlay);
            checked = itemView.findViewById(R.id.checked);
        }
    }

    // Store a member variable for the contacts
    private List<String> mArray;
    private Context mContext;

    // Pass in the contact array into the constructor
    public PlantSpeciesAdapter(List<String> array, Context c) {
        mContext = c;
        mArray = array;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public PlantSpeciesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View treeView = inflater.inflate(R.layout.item_plant, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(treeView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(PlantSpeciesAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        TextView name_tv = holder.nameTextView;
        name_tv.setText(mArray.get(position));
        switch(position) {
            case 0:
                holder.plantCardView.setBackgroundResource(R.drawable.plant0);
                break;
            case 1:
                holder.plantCardView.setBackgroundResource(R.drawable.plant1);
                break;
            case 2:
                holder.plantCardView.setBackgroundResource(R.drawable.plant2);
                break;
            case 3:
                holder.plantCardView.setBackgroundResource(R.drawable.plant3);
                break;
            case 4:
                holder.plantCardView.setBackgroundResource(R.drawable.plant4);
                break;
            default:
                break;
        }
        holder.plantCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(mContext.getClass().getSimpleName());
                if(mContext instanceof Inventory){
                    Intent intent = new Intent(mContext, viewPlant.class);
                    mContext.startActivity(intent);
                } else {
                    if(holder.checked.getVisibility() == View.GONE) {
                        holder.checked.setVisibility(View.VISIBLE);
                        holder.selectedOverlay.setVisibility(View.VISIBLE);
                    } else {
                        holder.checked.setVisibility(View.GONE);
                        holder.selectedOverlay.setVisibility(View.GONE);
                    }
                }

            }
        });
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mArray.size();
    }

}

