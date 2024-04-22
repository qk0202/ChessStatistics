package com.example.chess_statistics.controler.profile;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chess_statistics.adapter.PlayerAdapter;
import com.example.chess_statistics.model.Player;
import com.example.chess_statistics.R;

import java.util.ArrayList;
import java.util.List;

public class ResultsearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchresult_activity);

        // Khởi tạo danh sách người chơi (giả sử)
        List<Player> players = new ArrayList<>();
        Player player1 = new Player();
        player1.setName("Quang Khai");
        player1.setId(1);
        players.add(player1);

        Player player2 = new Player();
        player2.setName("Nam Phu");
        player2.setId(2);
        players.add(player2);

        // Tham chiếu đến RecyclerView trong layout
        RecyclerView recyclerView = findViewById(R.id.rcyPlayer);
        // Tạo adapter và đặt adapter cho RecyclerView
        PlayerAdapter adapter = new PlayerAdapter(players);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Lấy tham chiếu của ImageView icReturn từ layout
        ImageView icReturn = findViewById(R.id.icReturn);

        // Đặt sự kiện click cho ImageView icReturn
        icReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
