package com.example.chess_statistics.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.chess_statistics.R;
import com.example.chess_statistics.model.MatchList;
import com.example.chess_statistics.model.Player;
import com.example.chess_statistics.model.Round;

import java.util.ArrayList;
import java.util.List;

public class MatchListAdapter extends RecyclerView.Adapter<MatchListAdapter.MatchListViewHolder> {


    private List<MatchList> matchLists;

    private ArrayList<Player> players;
    public OnClickItemMatch onClickItemMatch;

    public MatchListAdapter(List<MatchList> matchLists, OnClickItemMatch onClickItemMatch,ArrayList<Player> players) {
        this.matchLists = matchLists;
        this.onClickItemMatch = onClickItemMatch;
        this.players = players;
    }

    @NonNull
    @Override
    public MatchListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_matchlist, parent, false);
        return new MatchListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchListViewHolder holder, int position) {
        MatchList matchList = matchLists.get(position);
        String namePlayer1 = "";
        String flag1 = "";
        String namePlayer2 = "";
        String flag2 = "";
        for (Player p: players) {
            if (p.getId() == matchList.getPlayer1_id()){
                namePlayer1 = p.getName();
                flag1 = p.getFlag();
            } else if (p.getId() == matchList.getPlayer2_id()) {
                namePlayer2 = p.getName();
                flag2 = p.getFlag();
            }
        }
        holder.player1.setText(namePlayer1);
        holder.player2.setText(namePlayer2);
        Glide.with(holder.img1).load(flag1).into(holder.img1);
        Glide.with(holder.img2).load(flag2).into(holder.img2);
        holder.result1.setText(String.valueOf(matchList.getResult1()));
        holder.result2.setText(String.valueOf(matchList.getResult2()));
    }

    @Override
    public int getItemCount() {
        return matchLists.size();
    }

    static class MatchListViewHolder extends RecyclerView.ViewHolder {
        TextView player1;

        TextView player2;

        TextView result1;

        TextView result2;

        ImageView img1;

        ImageView img2;

        public MatchListViewHolder(@NonNull View itemView) {
            super(itemView);
            player1 = itemView.findViewById(R.id.player1);
            player2 = itemView.findViewById(R.id.player2);
            result1 = itemView.findViewById(R.id.result1);
            result2 = itemView.findViewById(R.id.result2);
            img1 = itemView.findViewById(R.id.flag1);
            img2 = itemView.findViewById(R.id.flag2);

        }
    }


    public interface OnClickItemMatch{
        void clickItemMatch(MatchList matchList);
    }
}
