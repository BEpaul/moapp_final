package edu.skku.cs.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class RateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(),"Thank you for rating!",Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}