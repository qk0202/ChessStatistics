package com.example.chess_statistics.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.chess_statistics.model.Tourment;
import com.example.chess_statistics.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class TournamentAdapter extends RecyclerView.Adapter<TournamentAdapter.TourViewHolder> {

    private List<Tourment> tourMs;

    private OnClickItemTours onClickItemTours;

    public TournamentAdapter(List<Tourment> tours,OnClickItemTours onClickItemTours) {
        this.tourMs = tours;
        this.onClickItemTours = onClickItemTours;
    }

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tour, parent, false);
        return new TourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder holder, int position) {
        Tourment tours = tourMs.get(position);
        holder.tvName.setText(tours.getNameTour());
        Glide.with(holder.imageView).load(tours.getAvtTour()).into(holder.imageView);
        holder.tvLocation.setText(tours.getIpTour());
        holder.ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemTours.clickItemTours(tours);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tourMs.size();
    }

    static class TourViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;

        TextView tvLocation;

        ShapeableImageView imageView;

        LinearLayoutCompat ln;

        public TourViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvTitle);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            imageView = itemView.findViewById(R.id.imgBg);
            ln = itemView.findViewById(R.id.lnItemTour);
        }
    }

    public interface OnClickItemTours{
        void clickItemTours(Tourment tourment);
    }
}