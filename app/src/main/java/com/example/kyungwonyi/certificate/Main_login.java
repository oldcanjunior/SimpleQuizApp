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
import android.widget.Toast;

public class Main_login extends Activity {

    Button btnLogin;                    //로그인
    Button btnRegist;                   //회원가입
    Button btnQuit;                     //회원탈퇴
    EditText inputID, inputPW;          //ID, 비밀번호 입력
    DataBase_Manager memberDB;          //ID, 비밀번호 확인을 위해
    View quit_member;                   //quit_member 레이아웃을 inflate 하기 위해 호출
    EditText delete_iD, delete_PW;     //회원탈퇴 다이얼로그에 ID, 비밀번호 입력


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_login);

        memberDB = new DataBase_Manager(getApplicationContext(), "MEMBER_LIST", null, 1);



        //로그인 할 ID, 비밀번호 입력
        inputID = (EditText) findViewById(R.id.input_ID);
        inputPW = (EditText) findViewById(R.id.input_PW);


        //로그인
        btnLogin = (Button) findViewById(R.id.login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ID, 비밀번호 입력 확인
                if( inputID.getText().toString().length() == 0 || inputPW.getText().toString().length() == 0) {
                    Toast.makeText(Main_login.this, "ID, 비밀번호를 입력하세요!", Toast.LENGTH_SHORT).show();
                    inputID.requestFocus();
                    return;
                }
                // 가입한 ID 인지 확인
                else if( memberDB.ExistOfID(inputID.getText().toString())!=1 ) {
                    Toast.makeText(Main_login.this, "존재하지 않는 ID입니다", Toast.LENGTH_SHORT).show();
                    inputID.requestFocus();
                    return;
                }
                // 비밀번호 체크
                else if( memberDB.CheckPW(inputID.getText().toString(),inputPW.getText().toString())!=1 ) {
                    Toast.makeText(Main_login.this, "잘못된 비밀번호입니다", Toast.LENGTH_SHORT).show();
                    inputPW.requestFocus();
                    return;
                }

                //제대로 입력하면 로그인 완료 Toast 출력
                Toast.makeText(Main_login.this, memberDB.getID(inputID.getText().toString()) + "님 환영합니다."
                        , Toast.LENGTH_SHORT).show();


                //로그인 ID를 내장 메모리 파일에 쓰기
                //Main_lobby 액티비티에서 받아온다
                /*try
                {       //Current_login.txt로 파일을 쓰기 모드로 한다
                    FileOutputStream outFs = openFileOutput("Current_login.txt",
                            Context.MODE_PRIVATE);
                    String str = inputID.getText().toString();
                    outFs.write(str.getBytes());    //byte[]형으로 변경
                    outFs.close();
                }
                catch (IOException e)
                {    }
*/
                //메인 화면 띄우기
                Intent intent0 = new Intent(getApplicationContext(), TitleActivity.class);
                startActivity(intent0);

                finish();
            }
        });

        //회원가입
        btnRegist = (Button) findViewById(R.id.gotoRegist);
        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Regist.class);
                startActivity(intent1);
            }
        });

        //회원탈퇴
        /*btnQuit = (Button) findViewById(R.id.quit_member);
        btnQuit.setOnClickListener(new View.OnClickListener() {
            //다이얼로그 창 띄우기
            @Override
            public void onClick(View v) {

                //AlertDialog.Builder 선언
                AlertDialog.Builder dia = new AlertDialog.Builder(Main_login.this);

                //View 변수에 quit_member 레이아웃을 inflate 한다
                quit_member = (View) View.inflate(Main_login.this, R.layout.quit_member, null);

                dia.setTitle("회원탈퇴");
                dia.setView(quit_member);

                //취소 버튼 설정
                dia.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                //탈퇴 버튼 설정
                dia.setPositiveButton("회원탈퇴", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //지우려는 계정의 ID와 비밀번호
                        delete_iD = (EditText) quit_member.findViewById(R.id.input_delete_id);
                        delete_PW = (EditText) quit_member.findViewById(R.id.input_delete_passwd);

                        // ID, 비밀번호 입력 확인
                        if( delete_iD.getText().toString().length() == 0 || delete_PW.getText().toString().length() == 0) {
                            Toast.makeText(Main_login.this, "ID, 비밀번호를 입력하세요!", Toast.LENGTH_SHORT).show();
                            delete_iD.requestFocus();
                            return;
                        }
                        // 가입한 ID인지 확인
                        else if( memberDB.ExistOfID(delete_iD.getText().toString())!=1 ) {
                            Toast.makeText(Main_login.this, "존재하지 않는 ID입니다", Toast.LENGTH_SHORT).show();
                            delete_iD.requestFocus();
                            return;
                        }
                        // 비밀번호 체크
                        else if( memberDB.CheckPW(delete_iD.getText().toString(),delete_PW.getText().toString())!=1 ) {
                            Toast.makeText(Main_login.this, "잘못된 비밀번호입니다", Toast.LENGTH_SHORT).show();
                            delete_PW.requestFocus();
                            return;
                        }

                        //탈퇴 처리
                        memberDB.Delete_Member(delete_iD.getText().toString());
                        Toast.makeText(Main_login.this, "탈퇴 처리 되었습니다", Toast.LENGTH_SHORT).show();

                        dialog.dismiss();
                    }
                });
                dia.show();

            }
        });


        login_Image = (ImageView) findViewById(R.id.login_image);
*/


    }
}
