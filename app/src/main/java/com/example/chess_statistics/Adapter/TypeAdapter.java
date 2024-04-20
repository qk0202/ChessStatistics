package com.example.chess_statistics.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chess_statistics.Model.Type;
import com.example.chess_statistics.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.MyViewHolder> {


    private ArrayList<Type> types;
    private Context context;

    private OnClickItemType onClickItemType;

    public TypeAdapter(Context context,ArrayList<Type> types,OnClickItemType onClickItemType){
        this.types = types;
        this.context = context;
        this.onClickItemType = onClickItemType;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_chess, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Type type = types.get(position);
        holder.materialButton.setText(type.getName());
        holder.materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemType.clickItemType(type);
            }
        });
    }

    @Override
    public int getItemCount() {
        return types.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        MaterialButton materialButton;
        public MyViewHolder(View itemView) {
            super(itemView);

           materialButton = itemView.findViewById(R.id.type);

        }
    }

    public interface OnClickItemType{
        void clickItemType(Type type);
    }
}
