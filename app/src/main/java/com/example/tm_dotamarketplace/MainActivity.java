package com.example.tm_dotamarketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Model.User;

public class MainActivity extends AppCompatActivity {

    Button btnRegisterLogin;

    private boolean cekData(String username, String password) {
        for (User user : User.arrayUser) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etUsername = findViewById(R.id.etUsernameLogin);
        final EditText etPassword = findViewById(R.id.etPasswordLogin);
        final Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (username.equals("")) {
                    Toast.makeText(MainActivity.this, "Fullname must be filled!", Toast.LENGTH_SHORT);
                } else if (password.equals("")) {
                    Toast.makeText(MainActivity.this, "Password must be filled!", Toast.LENGTH_SHORT);
                } else if (!cekData(username, password)) {
                    Toast.makeText(MainActivity.this, "Username and password are incorrect", Toast.LENGTH_SHORT);
                } else {
                    startActivity(new Intent(MainActivity.this, MainForm.class));
                }
            }
        });
        btnRegisterLogin = findViewById(R.id.btnRegisterLogin); {
            btnRegisterLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, RegisterPage.class));
                }

            });

        }
    }
}