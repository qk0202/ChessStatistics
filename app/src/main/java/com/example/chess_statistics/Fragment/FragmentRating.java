package com.example.chess_statistics.Fragment;

import android.os.Bundle;
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

import com.example.chess_statistics.R;

public class FragmentRating extends Fragment {
    public FragmentRating() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rating, container, false);

        // Tìm và gán các view
        ImageView searchIcon = view.findViewById(R.id.icSearch);
        final EditText searchEditText = view.findViewById(R.id.searchEditText);

        // Xử lý sự kiện khi ấn vào icon tìm kiếm
        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchEditText.setVisibility(View.VISIBLE);
            }
        });

        // Xử lý tìm kiếm khi người dùng nhập dữ liệu và ấn Enter
        searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    // Xử lý tìm kiếm ở đây
                    String query = searchEditText.getText().toString().trim();
                    performSearch(query);
                    return true;
                }
                return false;
            }
        });

        return view;
    }

    private void performSearch(String query) {
        // Xử lý tìm kiếm ở đây
    }
}
