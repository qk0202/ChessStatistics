package com.example.chess_statistics.controler.tour;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chess_statistics.PlayerDatabaseHelper;
import com.example.chess_statistics.adapter.RoundAdapter;
import com.example.chess_statistics.R;
import com.example.chess_statistics.model.Round;
import com.example.chess_statistics.model.Tourment;
import com.example.chess_statistics.model.Type;

import java.util.ArrayList;

public class RoundActivity extends AppCompatActivity implements RoundAdapter.OnClickItemRound {

    private RoundAdapter roundAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round_activity);
        ImageView icReturn = findViewById(R.id.icReturn);
        Integer idTour = getIntent().getIntExtra("idTour",1);
        PlayerDatabaseHelper playerDatabaseHelper = new PlayerDatabaseHelper(this);
        ArrayList<Round> rounds = playerDatabaseHelper.filterRound(idTour.toString());

        //top ten
        RecyclerView recyclerView = findViewById(R.id.rcyRound);
        roundAdapter = new RoundAdapter(rounds,this);
        recyclerView.setAdapter(roundAdapter);

        icReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    public void clickItemRound(Round round) {
        Intent mIntent = new Intent(this, MatchlistActivity.class);
        mIntent.putExtra("idRound", round.getId());
        startActivity(mIntent);
    }
}

