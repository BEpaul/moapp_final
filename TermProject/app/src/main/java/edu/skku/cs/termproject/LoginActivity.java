package edu.skku.cs.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(view -> {
            EditText editTextID = findViewById(R.id.editTextTextPersonName);
            EditText editTextPW = findViewById(R.id.editTextTextPassword);
            String StrID = editTextID.getText().toString();
            String StrPW = editTextPW.getText().toString();

            Intent intent2 = getIntent();
            String getID = intent2.getExtras().getString("id");
            String getPW = intent2.getExtras().getString("password");

            if(StrID.equals(getID) && StrPW.equals(getPW)){
                Intent intent = new Intent(LoginActivity.this, SelectActivity.class);
                intent.putExtra("Pname",StrID);
                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
            else{
                editTextID.setText("");
                editTextPW.setText("");
                Toast.makeText(getApplicationContext(), "Failed",Toast.LENGTH_SHORT).show();
            }


        });








    }
}