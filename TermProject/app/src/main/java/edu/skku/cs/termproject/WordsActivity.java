package edu.skku.cs.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class WordsActivity extends AppCompatActivity {
    private ArrayList<StepButton> basicWords;
    private ArrayList<StepButton> advancedWords;
    private ListView listview;
    private ListViewAdapter listViewAdapter;
    private ListViewAdapter listViewAdapter2;
    int i;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);



        TextView dicTextView= findViewById(R.id.dicTextView);
        Intent getLangIntent = getIntent();
        String StrLang = getLangIntent.getStringExtra("choice");
        dicTextView.setText(StrLang + " Word");


        //if 문
        if(StrLang.equals("Korean")){

        // basic 버튼
        Button basicButton = findViewById(R.id.basicButton);
        Button advancedButton = findViewById(R.id.advancedButton);
        listview = findViewById(R.id.dicListView);
        basicButton.setOnClickListener(view -> {

            ArrayList<String> lineArray = new ArrayList<>();
//         텍스트파일 불러오기
            try {
                InputStream is = getApplicationContext().getAssets().open("korean basic.txt");
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                String line = null;
                while((line = br.readLine()) != null){
                    lineArray.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            ArrayList<String> basicLangList = new ArrayList<>();
            ArrayList<String> basicEngList = new ArrayList<>();
            for(i = 0; i < lineArray.size(); i++) {
                String[] basicWord = lineArray.get(i).split(" ");
                basicLangList.add(basicWord[0]);
                basicEngList.add(basicWord[1]);
            }

            // list에 단어 넣기
            basicWords = new ArrayList<>();
            for(i = 0; i < lineArray.size(); i++){
                basicWords.add(new StepButton(basicLangList.get(i), basicEngList.get(i)));
            }


            listViewAdapter = new ListViewAdapter(getApplicationContext(), basicWords);
            listview.setAdapter(listViewAdapter);
        });

        // advanced 버튼
        advancedButton.setOnClickListener(view -> {
            ArrayList<String> lineArray = new ArrayList<>();
//         텍스트파일 불러오기
            try {
                InputStream is = getApplicationContext().getAssets().open("korean advanced.txt");
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                String line = null;
                while((line = br.readLine()) != null){
                    lineArray.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            ArrayList<String> advancedLangList = new ArrayList<>();
            ArrayList<String> advancedEngList = new ArrayList<>();
            for(i = 0; i < lineArray.size(); i++) {
                String[] advancedWord = lineArray.get(i).split(" ");
                advancedLangList.add(advancedWord[0]);
                advancedEngList.add(advancedWord[1]);
            }

            // list에 단어 넣기
            advancedWords = new ArrayList<>();
            for(i = 0; i < lineArray.size(); i++){
                advancedWords.add(new StepButton(advancedLangList.get(i), advancedEngList.get(i)));
            }

            listViewAdapter2 = new ListViewAdapter(getApplicationContext(), advancedWords);
            listview.setAdapter(listViewAdapter2);
        });

            // 버튼 누르면 Collins 사전으로 이동(URI)
            Button URIButton = findViewById(R.id.URIButton);
            URIButton.setOnClickListener(view -> {
                EditText editText = findViewById(R.id.searchEditText);
                String inputSearch = editText.getText().toString();
                Uri uri = Uri.parse("https://www.collinsdictionary.com/ko/dictionary/english-korean/" + inputSearch);
                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent2);
                editText.setText("");
            });

        }

        //if Japanese
        else if(StrLang.equals("Japanese")){
// basic 버튼
            Button basicButton = findViewById(R.id.basicButton);
            Button advancedButton = findViewById(R.id.advancedButton);
            listview = findViewById(R.id.dicListView);
            basicButton.setOnClickListener(view -> {

                ArrayList<String> lineArray = new ArrayList<>();
//         텍스트파일 불러오기
                try {
                    InputStream is = getApplicationContext().getAssets().open("japanese basic.txt");
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);

                    String line = null;
                    while((line = br.readLine()) != null){
                        lineArray.add(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                ArrayList<String> basicLangList = new ArrayList<>();
                ArrayList<String> basicEngList = new ArrayList<>();
                for(i = 0; i < lineArray.size(); i++) {
                    String[] basicWord = lineArray.get(i).split(" ");
                    basicLangList.add(basicWord[0]);
                    basicEngList.add(basicWord[1]);
                }

                // list에 단어 넣기
                basicWords = new ArrayList<>();
                for(i = 0; i < lineArray.size(); i++){
                    basicWords.add(new StepButton(basicLangList.get(i), basicEngList.get(i)));
                }


                listViewAdapter = new ListViewAdapter(getApplicationContext(), basicWords);
                listview.setAdapter(listViewAdapter);
            });

            // advanced 버튼
            advancedButton.setOnClickListener(view -> {
                ArrayList<String> lineArray = new ArrayList<>();
//         텍스트파일 불러오기
                try {
                    InputStream is = getApplicationContext().getAssets().open("japanese advanced.txt");
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);

                    String line = null;
                    while((line = br.readLine()) != null){
                        lineArray.add(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                ArrayList<String> advancedLangList = new ArrayList<>();
                ArrayList<String> advancedEngList = new ArrayList<>();
                for(i = 0; i < lineArray.size(); i++) {
                    String[] advancedWord = lineArray.get(i).split(" ");
                    advancedLangList.add(advancedWord[0]);
                    advancedEngList.add(advancedWord[1]);
                }

                // list에 단어 넣기
                advancedWords = new ArrayList<>();
                for(i = 0; i < lineArray.size(); i++){
                    advancedWords.add(new StepButton(advancedLangList.get(i), advancedEngList.get(i)));
                }

                listViewAdapter2 = new ListViewAdapter(getApplicationContext(), advancedWords);
                listview.setAdapter(listViewAdapter2);
            });

            // 버튼 누르면 Collins 사전으로 이동(URI)
            Button URIButton = findViewById(R.id.URIButton);
            URIButton.setOnClickListener(view -> {
                EditText editText = findViewById(R.id.searchEditText);
                String inputSearch = editText.getText().toString();
                Uri uri = Uri.parse("https://www.collinsdictionary.com/ko/dictionary/english-japanese/" + inputSearch);
                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent2);
                editText.setText("");
            });
        }

        //if French
        else if(StrLang.equals("French")){
            // basic 버튼
            Button basicButton = findViewById(R.id.basicButton);
            Button advancedButton = findViewById(R.id.advancedButton);
            listview = findViewById(R.id.dicListView);
            basicButton.setOnClickListener(view -> {

                ArrayList<String> lineArray = new ArrayList<>();
//         텍스트파일 불러오기
                try {
                    InputStream is = getApplicationContext().getAssets().open("french basic.txt");
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);

                    String line = null;
                    while((line = br.readLine()) != null){
                        lineArray.add(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                ArrayList<String> basicLangList = new ArrayList<>();
                ArrayList<String> basicEngList = new ArrayList<>();
                for(i = 0; i < lineArray.size(); i++) {
                    String[] basicWord = lineArray.get(i).split(" ");
                    basicLangList.add(basicWord[0]);
                    basicEngList.add(basicWord[1]);
                }

                // list에 단어 넣기
                basicWords = new ArrayList<>();
                for(i = 0; i < lineArray.size(); i++){
                    basicWords.add(new StepButton(basicLangList.get(i), basicEngList.get(i)));
                }


                listViewAdapter = new ListViewAdapter(getApplicationContext(), basicWords);
                listview.setAdapter(listViewAdapter);
            });

            // advanced 버튼
            advancedButton.setOnClickListener(view -> {
                ArrayList<String> lineArray = new ArrayList<>();
//         텍스트파일 불러오기
                try {
                    InputStream is = getApplicationContext().getAssets().open("french advanced.txt");
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);

                    String line = null;
                    while((line = br.readLine()) != null){
                        lineArray.add(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                ArrayList<String> advancedLangList = new ArrayList<>();
                ArrayList<String> advancedEngList = new ArrayList<>();
                for(i = 0; i < lineArray.size(); i++) {
                    String[] advancedWord = lineArray.get(i).split(" ");
                    advancedLangList.add(advancedWord[0]);
                    advancedEngList.add(advancedWord[1]);
                }

                // list에 단어 넣기
                advancedWords = new ArrayList<>();
                for(i = 0; i < lineArray.size(); i++){
                    advancedWords.add(new StepButton(advancedLangList.get(i), advancedEngList.get(i)));
                }

                listViewAdapter2 = new ListViewAdapter(getApplicationContext(), advancedWords);
                listview.setAdapter(listViewAdapter2);
            });

            // 버튼 누르면 Collins 사전으로 이동(URI)
            Button URIButton = findViewById(R.id.URIButton);
            URIButton.setOnClickListener(view -> {
                EditText editText = findViewById(R.id.searchEditText);
                String inputSearch = editText.getText().toString();
                Uri uri = Uri.parse("https://www.collinsdictionary.com/ko/dictionary/english-french/" + inputSearch);
                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent2);
                editText.setText("");
            });
        }

        //if German
        else if(StrLang.equals("German")){
            // basic 버튼
            Button basicButton = findViewById(R.id.basicButton);
            Button advancedButton = findViewById(R.id.advancedButton);
            listview = findViewById(R.id.dicListView);
            basicButton.setOnClickListener(view -> {

                ArrayList<String> lineArray = new ArrayList<>();
//         텍스트파일 불러오기
                try {
                    InputStream is = getApplicationContext().getAssets().open("german basic.txt");
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);

                    String line = null;
                    while((line = br.readLine()) != null){
                        lineArray.add(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                ArrayList<String> basicLangList = new ArrayList<>();
                ArrayList<String> basicEngList = new ArrayList<>();
                for(i = 0; i < lineArray.size(); i++) {
                    String[] basicWord = lineArray.get(i).split(" ");
                    basicLangList.add(basicWord[0]);
                    basicEngList.add(basicWord[1]);
                }

                // list에 단어 넣기
                basicWords = new ArrayList<>();
                for(i = 0; i < lineArray.size(); i++){
                    basicWords.add(new StepButton(basicLangList.get(i), basicEngList.get(i)));
                }


                listViewAdapter = new ListViewAdapter(getApplicationContext(), basicWords);
                listview.setAdapter(listViewAdapter);
            });

            // advanced 버튼
            advancedButton.setOnClickListener(view -> {
                ArrayList<String> lineArray = new ArrayList<>();
//         텍스트파일 불러오기
                try {
                    InputStream is = getApplicationContext().getAssets().open("german advanced.txt");
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);

                    String line = null;
                    while((line = br.readLine()) != null){
                        lineArray.add(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                ArrayList<String> advancedLangList = new ArrayList<>();
                ArrayList<String> advancedEngList = new ArrayList<>();
                for(i = 0; i < lineArray.size(); i++) {
                    String[] advancedWord = lineArray.get(i).split(" ");
                    advancedLangList.add(advancedWord[0]);
                    advancedEngList.add(advancedWord[1]);
                }

                // list에 단어 넣기
                advancedWords = new ArrayList<>();
                for(i = 0; i < lineArray.size(); i++){
                    advancedWords.add(new StepButton(advancedLangList.get(i), advancedEngList.get(i)));
                }

                listViewAdapter2 = new ListViewAdapter(getApplicationContext(), advancedWords);
                listview.setAdapter(listViewAdapter2);
            });

            // 버튼 누르면 Collins 사전으로 이동(URI)
            Button URIButton = findViewById(R.id.URIButton);
            URIButton.setOnClickListener(view -> {
                EditText editText = findViewById(R.id.searchEditText);
                String inputSearch = editText.getText().toString();
                Uri uri = Uri.parse("https://www.collinsdictionary.com/ko/dictionary/english-german/" + inputSearch);
                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent2);
                editText.setText("");
            });
        }



    }
}