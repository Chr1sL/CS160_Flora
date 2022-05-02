package com.example.cs160_flora;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class AddPlantAdapter extends FragmentStatePagerAdapter {
    private Context myContext;
    public AddPlantAdapter(Context context, FragmentManager fm) {
        super(fm);
        myContext = context;
    }
    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:;
                return new PlantNameFragment();
            case 1:
                return new PlantSpeciesFragment();
            case 2:
                return new PlantCameraFragment();
            case 3:
                return new PlantConfirmFragment();
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return 4;
    }
}
