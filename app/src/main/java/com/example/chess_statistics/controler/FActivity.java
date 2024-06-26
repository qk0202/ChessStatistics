package com.example.chess_statistics.controler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.chess_statistics.adapter.ViewPagerAdapter;
import com.example.chess_statistics.model.Tourment;
import com.example.chess_statistics.model.Type;
import com.example.chess_statistics.PlayerDatabaseHelper;
import com.example.chess_statistics.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class FActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;

    private PlayerDatabaseHelper playerDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f_activity);
        viewPager = findViewById(R.id.viewPager);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        playerDatabaseHelper = new PlayerDatabaseHelper(this);
        ViewPagerAdapter Adapter = new ViewPagerAdapter(getSupportFragmentManager(), 3,
                playerDatabaseHelper.getAllType(), getListTours(),playerDatabaseHelper);


        viewPager.setAdapter(Adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.mRating).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.mTour).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.mProfile).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.mRating) {
                    viewPager.setCurrentItem(0);
                } else if (id == R.id.mTour) {
                    viewPager.setCurrentItem(1);
                } else if (id == R.id.mProfile) {
                    viewPager.setCurrentItem(2);
                }
                return true;
            }

        });

    }

    private ArrayList<Tourment> getListTours() {
        return playerDatabaseHelper.tournament();
    }
}
