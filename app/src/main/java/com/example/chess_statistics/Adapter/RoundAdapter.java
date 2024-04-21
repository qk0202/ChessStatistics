package com.example.chess_statistics.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.chess_statistics.Model.Round;
import com.example.chess_statistics.Model.Tourment;
import com.example.chess_statistics.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class RoundAdapter extends RecyclerView.Adapter<RoundAdapter.RoundViewHolder> {


    private List<Round> rounds;

    public RoundAdapter(List<Round> rounds) {
        this.rounds = rounds;
    }

    @NonNull
    @Override
    public RoundViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_round, parent, false);
        return new RoundViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoundViewHolder holder, int position) {
        Round round = rounds.get(position);
        holder.tvName.setText(round.getNameRound());

        holder.ctl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return rounds.size();
    }

    static class RoundViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;

        TextView tvDate;

        ConstraintLayout ctl;

        public RoundViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.nameRound);
            tvDate = itemView.findViewById(R.id.date);
            ctl = itemView.findViewById(R.id.ctlRound);
        }
    }
}
