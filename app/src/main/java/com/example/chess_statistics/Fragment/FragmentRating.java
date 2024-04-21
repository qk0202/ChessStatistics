package com.example.chess_statistics.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chess_statistics.Adapter.RatingAdapter;
import com.example.chess_statistics.Adapter.TypeAdapter;
import com.example.chess_statistics.Model.Player;
import com.example.chess_statistics.Model.Type;
import com.example.chess_statistics.R;

import java.util.ArrayList;

public class FragmentRating extends Fragment implements RatingAdapter.OnClickItemPlayer , TypeAdapter.OnClickItemType  {

    private RatingAdapter ratingAdapter;
    private ArrayList<Type> types;

    public FragmentRating(ArrayList<Type> types) {
        this.types = types;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rating, container, false);

        //list type
        RecyclerView tcyType = view.findViewById(R.id.rcyTypeChess);
        TypeAdapter typeAdapter = new TypeAdapter(getContext(),types,this);
        tcyType.setAdapter(typeAdapter);

        //top ten
        RecyclerView recyclerView = view.findViewById(R.id.rcyPlayer);
        ratingAdapter = new RatingAdapter(getContext(), types.get(0).getPlayers(),this);
        recyclerView.setAdapter(ratingAdapter);



        return view;
    }

    private void performSearch(String query) {

    }


    @Override
    public void ClickItem(Player player) {
        Log.e("huanhuan",String.valueOf(player.getId()));
    }

    @Override
    public void clickItemType(Type type) {
        ratingAdapter.updateData(type.getPlayers());
    }
}
