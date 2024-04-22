package com.example.chess_statistics.controler.tour;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chess_statistics.PlayerDatabaseHelper;
import com.example.chess_statistics.R;
import com.example.chess_statistics.adapter.MatchListAdapter;
import com.example.chess_statistics.adapter.RoundAdapter;
import com.example.chess_statistics.model.MatchList;
import com.example.chess_statistics.model.Player;
import com.example.chess_statistics.model.Round;

import java.util.ArrayList;

public class MatchlistActivity extends AppCompatActivity implements MatchListAdapter.OnClickItemMatch {

    private MatchListAdapter matchListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matchlist_activity);
        ImageView icReturn = findViewById(R.id.icReturn);

        Integer idRound = getIntent().getIntExtra("idRound", 1);
        PlayerDatabaseHelper playerDatabaseHelper = new PlayerDatabaseHelper(this);

        ArrayList<MatchList> matchLists = playerDatabaseHelper.filterMatchList(idRound.toString());
        ArrayList<Player> players = playerDatabaseHelper.getAllPlayers();

        //top ten
        RecyclerView recyclerView = findViewById(R.id.rcyMatchlist);
        matchListAdapter = new MatchListAdapter(matchLists, this, players);
        recyclerView.setAdapter(matchListAdapter);

        icReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void clickItemMatch(MatchList matchList) {

    }
}

