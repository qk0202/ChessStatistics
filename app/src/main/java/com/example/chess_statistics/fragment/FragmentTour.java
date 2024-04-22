package com.example.chess_statistics.fragment;

import android.content.Intent;
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
import com.example.chess_statistics.controler.MainActivity;
import com.example.chess_statistics.controler.tour.RoundActivity;
import com.example.chess_statistics.model.Tourment;

import java.util.ArrayList;

public class FragmentTour extends Fragment implements TournamentAdapter.OnClickItemTours {

    private TournamentAdapter tournamentAdapter;
    private ArrayList<Tourment> tourments;
    public FragmentTour(ArrayList<Tourment> tourments) {
        this.tourments = tourments;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tour, container, false);


        //top ten
        RecyclerView recyclerView = view.findViewById(R.id.rcyTour);
        tournamentAdapter = new TournamentAdapter(tourments,this);
        recyclerView.setAdapter(tournamentAdapter);

        return view;


    }

    @Override
    public void clickItemTours(Tourment tourment) {
        Intent mIntent = new Intent(getContext(), RoundActivity.class);
        mIntent.putExtra("idTour", tourment.getTour_id());
        getActivity().startActivity(mIntent);
    }
}
