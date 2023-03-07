package com.example.mydatabse;

import static kotlinx.coroutines.BuildersKt.launch;
import static kotlinx.coroutines.BuildersKt.withContext;
import static kotlinx.coroutines.GlobalScope.*;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

public class MyActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

       // textView = findViewById(R.id.textView);



    }

    private String makeNetworkRequest() {
        // ... code to make the network request ...
        return "Network response";
    }
}
