package com.example.tm_dotamarketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Transaction_History extends AppCompatActivity {

    ListView history = findViewById(R.id.lvHistory);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction__history);
    }


}