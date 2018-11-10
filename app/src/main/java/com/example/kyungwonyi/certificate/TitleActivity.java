package com.example.kyungwonyi.certificate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class TitleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title);
    }


    public void goQues(View v) {
        Toast.makeText(getApplicationContext(), "문제풀러가기", Toast.LENGTH_LONG).show();
        Intent intent_Input = new Intent(getApplicationContext(), Question_1Activity.class);
        startActivity(intent_Input);
    }

    public void goDate(View v) {
        Toast.makeText(getApplicationContext(), "수험날짜보기", Toast.LENGTH_LONG).show();
        Intent intent_Input = new Intent(getApplicationContext(), TestdateActivity.class);
        startActivity(intent_Input);
    }

    public void goScore(View v) {
        Toast.makeText(getApplicationContext(), "성적보기", Toast.LENGTH_LONG).show();
        Intent intent_Input = new Intent(getApplicationContext(), ScoreActivity.class);
        startActivity(intent_Input);

    }

    public void goLoc(View v) {
        Toast.makeText(getApplicationContext(), "수험장위치보기", Toast.LENGTH_LONG).show();
        Intent intent_Input = new Intent(getApplicationContext(), LocationActivity.class);
        startActivity(intent_Input);
    }
}
