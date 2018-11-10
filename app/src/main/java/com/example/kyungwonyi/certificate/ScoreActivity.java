package com.example.kyungwonyi.certificate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreActivity extends AppCompatActivity {

    //돌아가기
    Button memberList;
    DataBase_Manager memberDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);

        //memberDB = new DataBase_Manager(getApplicationContext(), "MEMBER_LIST", null, 1);
        memberDB = new DataBase_Manager(getApplicationContext(), "QUIZ_List", null, 1);


        //가입자 리스트 조회할 textView 변수 선언
        final TextView textView1 = (TextView) findViewById(R.id.result1);
        //가입자 리스트 조회
        memberList = (Button) findViewById(R.id.joined_members);
        memberList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "성적조회", Toast.LENGTH_LONG).show();
                textView1.setText(memberDB.ShowMember_list());
            }
        });

    }
}

