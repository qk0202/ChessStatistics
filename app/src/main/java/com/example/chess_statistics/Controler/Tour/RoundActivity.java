package com.example.chess_statistics.Controler.Tour;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chess_statistics.Adapter.RatingAdapter;
import com.example.chess_statistics.Adapter.RoundAdapter;
import com.example.chess_statistics.R;

public class RoundActivity extends AppCompatActivity {

    private RoundAdapter roundAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round_activity);
        ImageView icReturn = findViewById(R.id.icReturn);


        //top ten
        RecyclerView recyclerView = findViewById(R.id.rcyRound);
        //roundAdapter = new RoundAdapter();
        recyclerView.setAdapter(roundAdapter);

        icReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

