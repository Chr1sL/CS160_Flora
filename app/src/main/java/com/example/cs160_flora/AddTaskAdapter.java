package com.example.cs160_flora;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class AddTaskAdapter extends FragmentStatePagerAdapter {
    private Context myContext;
    public AddTaskAdapter(Context context, FragmentManager fm) {
        super(fm);
        myContext = context;
    }
    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:;
                return new TaskNameFragment();
            case 1:
                return new TaskSpeciesFragment();
            case 2:
                return new TaskScheduleFragment();
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return 3;
    }
}
