package com.example.chess_statistics.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chess_statistics.model.Round;
import com.example.chess_statistics.R;
import com.example.chess_statistics.model.Tourment;

import java.util.List;

public class RoundAdapter extends RecyclerView.Adapter<RoundAdapter.RoundViewHolder> {


    private List<Round> rounds;
    public OnClickItemRound onClickItemRound;

    public RoundAdapter(List<Round> rounds,OnClickItemRound onClickItemRound) {
        this.rounds = rounds;
        this.onClickItemRound = onClickItemRound;
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
        holder.tvName.setText(round.getName_Round());

        holder.ctl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemRound.clickItemRound(round);
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


    public interface OnClickItemRound{
        void clickItemRound(Round round);
    }
}
