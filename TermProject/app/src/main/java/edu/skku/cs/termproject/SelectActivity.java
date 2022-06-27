package edu.skku.cs.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

public class SelectActivity extends AppCompatActivity {
    private TextView helloTextView;
    private Button koreaButton;
    private Button japaneseButton;
    private Button frenchButton;
    private Button germanButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        //시간 지나면 별점 창
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SelectActivity.this, RateActivity.class);
                startActivity(intent);
            }
        }, 60000);

        // 받는 Intent
        Intent Gintent = getIntent();
        String getUserName = Gintent.getStringExtra("Pname");
        helloTextView = findViewById(R.id.helloTextView);
        helloTextView.setText("hello, " + getUserName + "!");

        koreaButton = findViewById(R.id.koreanButton);
        japaneseButton = findViewById(R.id.japaneseButton);
        frenchButton = findViewById(R.id.frenchButton);
        germanButton = findViewById(R.id.germanButton);
        Intent intent2 = new Intent(SelectActivity.this, WordsActivity.class);
        // 한국어 버튼 클릭
        koreaButton.setOnClickListener(view -> {
            intent2.putExtra("choice", "Korean");
            startActivity(intent2);
        });

        // 일어 버튼 클릭
        japaneseButton.setOnClickListener(view -> {
            intent2.putExtra("choice", "Japanese");
            startActivity(intent2);
        });

        // 불어 버튼 클릭
        frenchButton.setOnClickListener(view -> {
            intent2.putExtra("choice", "French");
            startActivity(intent2);
        });

        // 독어 버튼 클릭
        germanButton.setOnClickListener(view -> {
            intent2.putExtra("choice", "German");
            startActivity(intent2);
        });
    }
}