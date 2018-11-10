package com.example.kyungwonyi.certificate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class TestdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testdate);
    }

    public void goTitle(View v) {
        Toast.makeText(getApplicationContext(), "메인메뉴로", Toast.LENGTH_LONG).show();
        Intent intent_Input = new Intent(getApplicationContext(), TitleActivity.class);
        startActivity(intent_Input);
    }


}
