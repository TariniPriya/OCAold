package com.example.oca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class Food extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        // Create an adapter that returns a fragment for each of the two primary sections of the activity
        FoodPageAdapter pagerAdapter = new FoodPageAdapter(getSupportFragmentManager());

        // Set the adapter onto the ViewPager
        viewPager.setAdapter(pagerAdapter);
        getSupportActionBar().setTitle("Food to Eat");
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                String title = "";
                switch (position) {
                    case 0:
                        title = "Food to Eat";
                        break;
                    case 1:
                        title = "Food to Avoid";
                        break;
                }
                getSupportActionBar().setTitle(title);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

            // Other methods of ViewPager.OnPageChangeListener can be left empty or implemented as needed
        });


        // Attach the ViewPager to the TabLayout
        tabLayout.setupWithViewPager(viewPager);
    }
}