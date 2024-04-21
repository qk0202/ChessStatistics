package com.example.chess_statistics.Fragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chess_statistics.Adapter.RatingAdapter;
import com.example.chess_statistics.Adapter.TournamentAdapter;
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
