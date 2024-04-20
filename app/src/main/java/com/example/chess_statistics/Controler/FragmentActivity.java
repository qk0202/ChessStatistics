package com.example.chess_statistics.Controler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.chess_statistics.Adapter.ViewPagerAdapter;
import com.example.chess_statistics.Model.Type;
import com.example.chess_statistics.PlayerDatabaseHelper;
import com.example.chess_statistics.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class FragmentActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;

    private PlayerDatabaseHelper playerDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);
        viewPager = findViewById(R.id.viewPager);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        playerDatabaseHelper = new PlayerDatabaseHelper(this);
        ViewPagerAdapter Adapter = new ViewPagerAdapter(getSupportFragmentManager(), 3, arrayList());


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
    private ArrayList<Type> arrayList(){
        ArrayList<Type> a = new ArrayList<Type>();
        a.add(new Type(1,"Blitz",playerDatabaseHelper.getAllPlayers()));
        a.add(new Type(2,"Class",null));
        return  a;
    }
}
