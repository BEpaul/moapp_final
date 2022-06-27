package edu.skku.cs.termproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    // 마지막으로 뒤로 가기 버튼을 눌렀던 시간 저장
    private long backKeyPressedTime = 0;
    // 첫 번째 뒤로 가기 버튼을 누를 때 표시
    private Toast toast;

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        // 기존 뒤로 가기 버튼의 기능을 막기 위해 주석 처리 또는 삭제

        // 마지막으로 뒤로 가기 버튼을 눌렀던 시간에 2.5초를 더해 현재 시간과 비교 후
        // 마지막으로 뒤로 가기 버튼을 눌렀던 시간이 2.5초가 지났으면 Toast 출력
        // 2500 milliseconds = 2.5 seconds
        if (System.currentTimeMillis() > backKeyPressedTime + 2500) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, "If you want to go out, Click the back button once more.", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        // 마지막으로 뒤로 가기 버튼을 눌렀던 시간에 2.5초를 더해 현재 시간과 비교 후
        // 마지막으로 뒤로 가기 버튼을 눌렀던 시간이 2.5초가 지나지 않았으면 종료
        if (System.currentTimeMillis() <= backKeyPressedTime + 2500) {
            finish();
            toast.cancel();
            toast = Toast.makeText(this,"Thank you for your use.",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    EditText IDeditText;
    EditText PWeditText;
    EditText veriPWeditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSelectActivity(View v){
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);

        IDeditText = findViewById(R.id.IDEditTextView);
        PWeditText = findViewById(R.id.CreateEditPassWord);
        veriPWeditText = findViewById(R.id.verifyEditPassWord);

        String inputID = IDeditText.getText().toString();
        String inputPW = PWeditText.getText().toString();
        String verifyPW = veriPWeditText.getText().toString();

        // 만약 비밀번호 확인이 일치한다면 진행
        if(inputPW.equals(verifyPW)){

        // 회원가입: rds 이용!!!!!!!
        OkHttpClient client = new OkHttpClient();
        DataModel data = new DataModel();

        data.setUserID(inputID);
        data.setUserPW(inputPW);

        Gson gson = new Gson();
        String json = gson.toJson(data, DataModel.class);
        HttpUrl.Builder urlBuilder1 = HttpUrl.parse("https://z7pmyr1xi0.execute-api.ap-northeast-2.amazonaws.com/dev/adduser").newBuilder();
        String url = urlBuilder1.build().toString();

        Request request = new Request.Builder().url(url).post(RequestBody.create(MediaType.parse("application/json"), json)).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                final String myResponse = response.body().string();

                Gson gson = new GsonBuilder().create();

                IsSuccess gson2 = gson.fromJson(myResponse, IsSuccess.class);

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(gson2.isSuccess() == true){

                            intent.putExtra("id", data.getUserID());
                            intent.putExtra("password", data.getUserPW());
                            startActivity(intent);
                        }
                        else if(gson2.isSuccess() == false){
                            Toast.makeText(getApplicationContext(), "This is already member information.",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        }
        // 비밀번호 확인이 일치하지 않는다면
        else{
            IDeditText.setText("");
            PWeditText.setText("");
            veriPWeditText.setText("");
            Toast.makeText(getApplicationContext(),"Passwords do not match!",Toast.LENGTH_SHORT).show();
        }


    }
}