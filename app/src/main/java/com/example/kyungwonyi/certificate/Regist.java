package com.example.kyungwonyi.certificate;

/**
 * Created by kyungwonyi on 2018. 6. 8..
 */


        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class Regist extends Activity {



    Button btnCheck;                    //ID중복확인
    Button btnRegist, btnCancel;      //가입완료, 가입취소
    Button btnBack;                     //돌아가기
    Button memberList;                  //가입자들 조회

    //가입할 계정의 정보 입력
    EditText editTextID, editTextPW, editTextName;

    DataBase_Manager memberDB;          //가입완료시 DB의 회원정보 테이블에 추가시키기 위해

    //계정 정보를 String 값으로 저장
    String str_ID, str_PW, str_Name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regist);

        memberDB = new DataBase_Manager(getApplicationContext(), "MEMBER_LIST", null, 1);


        //가입할 계정의 정보 입력
        editTextID = (EditText) findViewById(R.id.userID);
        editTextPW = (EditText) findViewById(R.id.userPW);
        editTextName = (EditText) findViewById(R.id.name);


        //ID중복확인
        btnCheck = (Button) findViewById(R.id.checkID);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ID 입력 확인
                if( editTextID.getText().toString().length() == 0 ) {
                    Toast.makeText(Regist.this, "ID를 입력하세요!", Toast.LENGTH_SHORT).show();
                    editTextID.requestFocus();
                    return;
                }
                //중복 확인
                if( memberDB.ExistOfID(editTextID.getText().toString())==1 ) {
                    Toast.makeText(Regist.this, "이미 가입한 ID입니다", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                    Toast.makeText(Regist.this, "사용 가능한 ID입니다", Toast.LENGTH_SHORT).show();
            }
        });


        //가입완료 (모든 항목을 다 입력했는지 확인해야 한다)
        btnRegist = (Button) findViewById(R.id.join_Member);
        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ID 입력 확인 - 문자열 길이 체크
                if( editTextID.getText().toString().length() == 0 ) {
                    Toast.makeText(Regist.this, "ID를 입력하세요!", Toast.LENGTH_SHORT).show();
                    editTextID.requestFocus();
                    return;
                }
                //중복 확인
                if( memberDB.ExistOfID(editTextID.getText().toString())==1 ) {
                    Toast.makeText(Regist.this, "ID 중복체크를 확인하세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                // 비밀번호 입력 확인
                if( editTextPW.getText().toString().length() == 0 ) {
                    Toast.makeText(Regist.this, "비밀번호를 입력하세요!", Toast.LENGTH_SHORT).show();
                    editTextPW.requestFocus();
                    return;
                }

                // 이름 입력 확인
                if( editTextName.getText().toString().length() == 0 ) {
                    Toast.makeText(Regist.this, "이름을 입력하세요!", Toast.LENGTH_SHORT).show();
                    editTextName.requestFocus();
                    return;
                }

                //입력한 값들을 String 변수에 저장
                str_ID = editTextID.getText().toString();
                str_PW = editTextPW.getText().toString();
                str_Name = editTextName.getText().toString();

                //(String 변수에 저장한)데이터를 DB에 삽입
                memberDB.insert("INSERT INTO MEMBER_LIST VALUES('"+str_ID+"','"+str_PW+"','"+str_Name+"',0, 0);");

                Toast.makeText(Regist.this, "사용 가능한 ID입니다", Toast.LENGTH_SHORT).show();
                //가입완료 화면 창 띄우기
                Intent intent0 = new Intent(getApplicationContext(), Main_login.class);
                startActivity(intent0);

                finish();
            }
        });


        //가입자 리스트 조회할 textView 변수 선언
        final TextView textView1 = (TextView) findViewById(R.id.result1);
        //가입자 리스트 조회
        memberList = (Button) findViewById(R.id.joined_members);
        memberList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText(memberDB.ShowMember_list());
            }
        });


        //가입 취소
        btnCancel = (Button) findViewById(R.id.join_Cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //돌아가기
        btnBack = (Button) findViewById(R.id.regist_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
