package com.example.cs160_flora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class AddTaskActivity extends AppCompatActivity {

    ViewPager viewPager;
    int currentPage;
    private TaskViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        viewModel = ViewModelProviders.of(this).get(TaskViewModel.class);

        viewPager = findViewById(R.id.pickupViewPager);

        final AddTaskAdapter adapter = new AddTaskAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {}
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            public void onPageSelected(int position) {
                TextView bottomText = findViewById(R.id.bottomButtonText);
                if (position == 2) {
                    bottomText.setText("Submit Task");
                } else {
                    bottomText.setText("Next");
                }
            }
        });

        ConstraintLayout nextButton = findViewById(R.id.bottomButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentPage = viewPager.getCurrentItem();
                if (currentPage >= 2) {
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("taskName", viewModel.getTask().getValue());
                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();
                } else{
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