package com.example.chess_statistics.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.chess_statistics.Controler.Profile.ResultsearchActivity;
import com.example.chess_statistics.R;

public class FragmentProfile extends Fragment {
    public FragmentProfile() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        final ImageView imageViewSearch = view.findViewById(R.id.imageViewSearch);
        final EditText editTextSearch = view.findViewById(R.id.editTextSearch);
        final Button buttonSearch = view.findViewById(R.id.btnSearch);

        // Xử lý khi người dùng nhấn Enter trên bàn phím ảo
        editTextSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch(editTextSearch.getText().toString());
                    return true;
                }
                return false;
            }
        });

        // Xử lý khi người dùng nhấn vào biểu tượng tìm kiếm
        imageViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ẩn ImageView và hiện EditText và Button
                imageViewSearch.setVisibility(View.GONE);
                editTextSearch.setVisibility(View.VISIBLE);
                buttonSearch.setVisibility(View.VISIBLE);

                // Hiển thị bàn phím ảo khi EditText được hiển thị
                editTextSearch.requestFocus();
            }
        });

        // Xử lý khi người dùng nhấn nút tìm kiếm
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch(editTextSearch.getText().toString());
            }
        });
        return view;
    }

    // Phương thức thực hiện hành động tìm kiếm
    private void performSearch(String query) {
        // Thực hiện hành động tìm kiếm ở đây
        // Ví dụ: Log.d("SearchQuery", query);

        // Gọi phương thức để mở màn hình kết quả tìm kiếm
        openSearchResult(query);
    }

    // Phương thức để mở màn hình kết quả tìm kiếm
    private void openSearchResult(String query) {
        // Tạo một Intent để chuyển từ FragmentProfile sang SearchResultActivity (hoặc Fragment)
        Intent intent = new Intent(getActivity(), ResultsearchActivity.class);
        // Truyền dữ liệu tìm kiếm qua Intent
        intent.putExtra("search_query", query);
        startActivity(intent);
    }
}
