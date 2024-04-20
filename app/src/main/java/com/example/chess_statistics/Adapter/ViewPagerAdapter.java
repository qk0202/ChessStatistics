package com.example.chess_statistics.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.chess_statistics.Fragment.FragmentProfile;
import com.example.chess_statistics.Fragment.FragmentRating;
import com.example.chess_statistics.Fragment.FragmentTour;
import com.example.chess_statistics.Model.Type;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<Type> types;
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior,ArrayList<Type> types) {
        super(fm, behavior);
        this.types = types;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new FragmentRating(types);
            case 1: return new FragmentTour();
            case 2: return new FragmentProfile();
            default: return new FragmentRating(types);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
