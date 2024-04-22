package com.example.chess_statistics.controler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chess_statistics.PlayerDatabaseHelper;
import com.example.chess_statistics.R;
import com.example.chess_statistics.model.User;

public class MainActivity extends AppCompatActivity {
    private EditText editUsename, editPassword;
    private Button btnLogin;

    private PlayerDatabaseHelper playerDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUsename = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickLogin();
            }
        });
    }

    private void clickLogin() {
        String strUsername = editUsename.getText().toString().trim();
        String strPassword = editPassword.getText().toString().trim();
        User user = new User(strUsername, strPassword);
        if(user.isValidEmail() && user.isVaildPassword()) {
            Intent intent = new Intent(MainActivity.this, FActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Email PassWord Fail", Toast.LENGTH_SHORT).show();
        }
    }
}
