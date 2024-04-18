package com.example.chess_statistics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editUsename, editPassword;
    private Button btnLogin;
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
            Toast.makeText(this, "Chinh Xac", Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(this, "Khong chinh xac", Toast.LENGTH_SHORT).show();
        }
    }
}