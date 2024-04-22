package com.example.chess_statistics.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chess_statistics.adapter.TournamentAdapter;
import com.example.chess_statistics.R;

public class FragmentTour extends Fragment {

    private TournamentAdapter tournamentAdapter;
    public FragmentTour() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tour, container, false);


        //top ten
        RecyclerView recyclerView = view.findViewById(R.id.rcyTour);
        //tournamentAdapter = new TournamentAdapter();
        recyclerView.setAdapter(tournamentAdapter);


        return view;


    }
}
