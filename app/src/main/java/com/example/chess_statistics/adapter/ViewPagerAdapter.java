package com.example.chess_statistics.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.chess_statistics.PlayerDatabaseHelper;
import com.example.chess_statistics.fragment.FragmentProfile;
import com.example.chess_statistics.fragment.FragmentRating;
import com.example.chess_statistics.fragment.FragmentTour;
import com.example.chess_statistics.model.Round;
import com.example.chess_statistics.model.Tourment;
import com.example.chess_statistics.model.Type;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<Type> types;
    ArrayList<Tourment> tourments;
    PlayerDatabaseHelper playerDatabaseHelper;
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior,ArrayList<Type> types,ArrayList<Tourment> tourments,PlayerDatabaseHelper playerDatabaseHelper) {
        super(fm, behavior);
        this.types = types;
        this.tourments = tourments;
        this.playerDatabaseHelper = playerDatabaseHelper;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new FragmentRating(types,playerDatabaseHelper);
            case 1: return new FragmentTour(tourments);
            case 2: return new FragmentProfile();
            default: return new FragmentRating(types,playerDatabaseHelper);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
