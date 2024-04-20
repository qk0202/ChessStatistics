package com.example.chess_statistics.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.chess_statistics.Model.Player;
import com.example.chess_statistics.R;

import java.util.ArrayList;

public class RatingAdapter extends RecyclerView.Adapter<RatingAdapter.MyViewHolder> {
    ArrayList<Player> player;
    Context context;

    private OnClickItemPlayer onClickListener;

    public RatingAdapter(Context context, ArrayList<Player> players, OnClickItemPlayer onClickListener) {
        this.context = context;
        this.player = players;
        this.onClickListener = onClickListener;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateData(ArrayList<Player> players) {
        this.player = players;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_player, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Player item = player.get(position);
        if (position == 0) {
            holder.imgRank.setImageResource(R.drawable.ic_rank_1);
        } else if (position == 1) {
            holder.imgRank.setImageResource(R.drawable.ic_rank_2);
        } else if (position == 2) {
            holder.imgRank.setImageResource(R.drawable.ic_rank_3);
        } else {
            holder.imgRank.setVisibility(View.GONE);
        }

        holder.tvRank.setText(String.valueOf(position + 1));
        holder.tvName.setText(item.getName());
        holder.tvPoint.setText(String.valueOf(item.getPoint()));
        Glide.with(context).load(item.getAvatar()).into(holder.avatar);
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.ClickItem(item);
            }
        });

    }


    @Override
    public int getItemCount() {
        return player.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvRank;
        TextView tvName;
        TextView tvPoint;
        ImageView avatar;
        ConstraintLayout constraintLayout;

        ImageView imgRank;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvRank = (TextView) itemView.findViewById(R.id.tvRank);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvPoint = (TextView) itemView.findViewById(R.id.tvPoint);
            avatar = itemView.findViewById(R.id.imgAvatar);
            constraintLayout = itemView.findViewById(R.id.ctlContainer);
            imgRank = itemView.findViewById(R.id.imgRank);

        }

    }

    public interface OnClickItemPlayer {
        void ClickItem(Player player);
    }
}
