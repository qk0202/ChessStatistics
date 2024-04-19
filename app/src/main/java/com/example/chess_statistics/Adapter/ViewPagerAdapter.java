package com.example.chess_statistics.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.chess_statistics.Fragment.FragmentProfile;
import com.example.chess_statistics.Fragment.FragmentRating;
import com.example.chess_statistics.Fragment.FragmentTour;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {

        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new FragmentRating();
            case 1: return new FragmentTour();
            case 2: return new FragmentProfile();
            default: return new FragmentRating();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
