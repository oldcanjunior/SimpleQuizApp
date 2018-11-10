package com.example.kyungwonyi.certificate;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBase_Manager extends SQLiteOpenHelper
{       //생성자 정의
    public DataBase_Manager(Context context, String table_name,
                            SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, table_name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //회원, 주문내역 테이블 생성
        db.execSQL("CREATE TABLE MEMBER_LIST( iD CHAR(30) PRIMARY KEY, " +
                "passwd CHAR(30), name CHAR(20), score INT(10),count INT(10));");
        db.execSQL("CREATE TABLE QUIZ_List (row_id INT ,answer INT(10))" );

        db.execSQL("CREATE TABLE Check_ans(correct CHAR(5))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer)
    {     }


    //최종 결과확인 창 출력
    /*public String result_score(){
        SQLiteDatabase db = getReadableDatabase();
        String data = "";
        int i = 1;

        Cursor cursor = db.rawQuery("SELECT * FROM Checkans",null);
    }*/
    public void insert_answer() {
        // 읽고 쓰기가 가능하게 DB 열기

        SQLiteDatabase db = getWritableDatabase();
        // DB에 입력한 값으로 행 추가
        db.execSQL("INSERT INTO QUIZ_List VALUES(1,4);");
        db.execSQL("INSERT INTO QUIZ_List VALUES(2,5);");
        db.execSQL("INSERT INTO QUIZ_List VALUES(3,6);");
        db.execSQL("INSERT INTO QUIZ_List VALUES(4,7);");
        db.execSQL("INSERT INTO QUIZ_List VALUES(5,8);");
        db.execSQL("INSERT INTO QUIZ_List VALUES(6,4);");
        db.execSQL("INSERT INTO QUIZ_List VALUES(7,4);");
        db.execSQL("INSERT INTO QUIZ_List VALUES(8,4);");
        db.execSQL("INSERT INTO QUIZ_List VALUES(9,4);");
        db.execSQL("INSERT INTO QUIZ_List VALUES(10,4);");

        db.close();
    }

    //입력받은 값으로 행 추가(회원가입, 주문내역)
    public void insert(String _query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }
    //가입자들 정보 출력
    public String ShowMember_list() {
        SQLiteDatabase db = getReadableDatabase();
        String data = "";
        int i = 1;

        //cursor 변수를 통해 행을 돌아가면서 탐색
        Cursor cursor = db.rawQuery("SELECT * FROM QUIZ_List", null);
        while(cursor.moveToNext()) {
            //data에 탐색한 행의 데이터 저장
            data += i + "번 회원 - ID : "
                    + cursor.getString(0)
                     + " / 이름 : "
                    + cursor.getString(1)
                    /*+ " / 점수 : "
                    + cursor.getString(3)
                    + " / 회차 : "
                    + cursor.getString(4)*/
                    + "\n";
            i++;
        }
        return data;    //저장한 데이터 반환
    }

    //주문내역 출력 - 가입자 정보 출력과 유사
    /*public String Show_Recent_del() {
        SQLiteDatabase db = getReadableDatabase();
        String data = "";
        int i = 1;

        Cursor cursor = db.rawQuery("SELECT * FROM RECENT_DEL", null);
        while(cursor.moveToNext()) {

            data += i+ "번째 가게 이름 : "
                    + cursor.getString(0)
                    + "\n";
            i++;
        }
        return data;
    }*/

    /*//주문내역 전체삭제
    public void Delete_RecentDel()
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM RECENT_DEL;");
        db.close();
    }*/


    //ID중복 체크(회원가입, 탈퇴, 로그인 모두 사용)
    public int ExistOfID(String regist_ID) {
        SQLiteDatabase db = getReadableDatabase();
        String data = "";
        int P = 0;

        Cursor cursor = db.rawQuery("SELECT iD FROM MEMBER_LIST", null);
        while(cursor.moveToNext()) {
            data = cursor.getString(0);
            //전달받은 ID가 DB 내에 있다면 P가 1이 된다
            if(regist_ID.equals(data))
                P++;
        }
        return P;   //P가 1일 경우 이미 가입한 ID
    }


    //로그인 - ID에 해당하는 비밀번호 체크
    public int CheckPW(String login_ID, String login_PW) {
        SQLiteDatabase db = getReadableDatabase();
        String data_id, data_pw = "";
        int P = 0;

        Cursor cursor = db.rawQuery("SELECT * FROM MEMBER_LIST", null);
        while(cursor.moveToNext()) {
            data_id = cursor.getString(0);
            data_pw = cursor.getString(1);
            //전달받은 ID와 비밀번호가 DB 내에 있는지, 같은 행에 있는지 확인
            if(login_ID.equals(data_id) && login_PW.equals(data_pw))
            {
                P++;
            }
        }
        return P;   //P가 0일 경우 비밀번호를 잘못 입력한 것이다
    }

    //ID추출
    public String getID(String login_ID)
    {
        SQLiteDatabase db = getReadableDatabase();
        String data,total = "";

        Cursor cursor = db.rawQuery("SELECT iD FROM MEMBER_LIST", null);
        while(cursor.moveToNext()) {
            data = cursor.getString(0);
            if(login_ID.equals(data))
            {
                total = cursor.getString(0);
                break;
            }
        }
        return total;   //전달받은 ID가 DB에 있을 경우 ID값 반환
    }


    //회원정보수정
    /*public void Modify_myInfo(String login_ID, String login_PW, String login_PH, String login_Mail)
    {
        //Edit_myInfo 액티비티에서 전달받은 ID에 해당하는 비밀번호, 전화번호, 이메일 업데이트
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE MEMBER_LIST SET passwd = '" + login_PW + "', " +
                "phone =  '" + login_PH + "', " +
                "email = '" + login_Mail + "' " +
                "WHERE iD = '" + login_ID + "';");
        db.close();
    }*/


    public void Delete_ans(String login_ID)
    {
        //Main_login 액티비티에서 ID, 비밀번호 검사 후
        //통과 시 ID만 넘겨받아 해당 데이터를 삭제한다
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM Checkans ;");
        db.close();
    }

    public int Check_answer(String insert_ans) {
        SQLiteDatabase db = getReadableDatabase();
        String data_ans = "";
        int P = 0;

        Cursor cursor = db.rawQuery("SELECT * FROM Quiz_List", null);
        while(cursor.moveToNext()) {

            data_ans = cursor.getString(1);
            //전달받은 ID와 비밀번호가 DB 내에 있는지, 같은 행에 있는지 확인
            if(insert_ans.equals(data_ans))
            {
                P++;
            }
        }
        return P;   //P가 0일 경우 비밀번호를 잘못 입력한 것이다
    }

    public void Modify_score(int login_ID, int login_PW)
    {
        //Edit_myInfo 액티비티에서 전달받은 ID에 해당하는 비밀번호, 전화번호, 이메일 업데이트
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE MEMBER_LIST SET score = '" + login_ID + "', " +
                " count = '" + (login_PW+1) + "';");
        db.close();
    }
    /*public String getScore(int login_ID)
    {
        SQLiteDatabase db = getReadableDatabase();
        String data,total = "";

        Cursor cursor = db.rawQuery("SELECT iD FROM MEMBER_LIST", null);
        while(cursor.moveToNext()) {
            data = cursor.getString(0);

                total = cursor.getString(0);
                break;

        }
        return total;   //전달받은 ID가 DB에 있을 경우 ID값 반환
    }*/

    public int Show_list(int k) {
        SQLiteDatabase db = getReadableDatabase();
        int data=0;
        int i = k;

        //cursor 변수를 통해 행을 돌아가면서 탐색
        Cursor cursor = db.rawQuery("SELECT answer FROM QUIZ_List WHERE row_id='" + i + "';",null);

        while(cursor.moveToNext()) {
            //data에 탐색한 행의 데이터 저장
            data = cursor.getInt(0);
        }
        return data;    //저장한 데이터 반환
    }

}