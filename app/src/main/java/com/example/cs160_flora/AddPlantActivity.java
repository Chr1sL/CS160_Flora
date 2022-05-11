package com.example.cs160_flora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AddPlantActivity extends AppCompatActivity {

    ViewPager viewPager;
    int currentPage;
    private PlantViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);

        viewModel = new ViewModelProvider(this).get(PlantViewModel.class);

        viewPager = findViewById(R.id.pickupViewPager);

        ConstraintLayout nextButton = findViewById(R.id.bottomButton);
        ImageView captureButton = findViewById(R.id.captureButton);

        final AddPlantAdapter adapter = new AddPlantAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {}
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            public void onPageSelected(int position) {
                TextView bottomText = findViewById(R.id.bottomButtonText);
                nextButton.setVisibility(View.VISIBLE);
                captureButton.setVisibility(View.GONE);
                if (position == 3) {
                    bottomText.setText("Back to Plants");
                } else if (position == 2) {
                    nextButton.setVisibility(View.GONE);
                    captureButton.setVisibility(View.VISIBLE);
                }
                else {
                    bottomText.setText("Next");
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentPage = viewPager.getCurrentItem();
                if (currentPage >= 3) {
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("plantName", viewModel.getName().getValue());
                    returnIntent.putExtra("imageResource", viewModel.getImageResource().getValue());
                    returnIntent.putExtra("plantSpecies", viewModel.getSpecies().getValue());
                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();
                } else {
                    viewPager.setCurrentItem(currentPage+1, true);
                }
            }
        });

        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentPage = viewPager.getCurrentItem();
                if (currentPage == 2) {
                    viewPager.setCurrentItem(currentPage+1, true);
                }
            }
        });

        ImageView prevButton = findViewById(R.id.backIcon);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentPage = viewPager.getCurrentItem();
                if (currentPage <= 0) {
                    finish();
                } else{
                    viewPager.setCurrentItem(currentPage-1, true);
                }
            }
        });
    }
}