package com.example.kyungwonyi.certificate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by kyungwonyi on 2018. 6. 11..
 */

public class Question_1Activity extends AppCompatActivity {

    DataBase_Manager Quiz_List,Check_ans,memberDB;

    EditText answer;

    ImageView imageView;
    Button button01;
    String imgURL1 = "https://cdn.steemitimages.com/DQmUPCQLDQXXaH2sCSqrKS1o76afqA9ryt9hXnjQVkBMQQi/q1.png";
    String imgURL2 = "https://cdn.steemitimages.com/DQmQrzoDMGqqU8Boa9CJpajsbW44BupCgMgqtjmgzA7aKWM/q2.png";
    String imgURL3 = "https://cdn.steemitimages.com/DQmR3L1MuYFy8rzsLbvboMPjvNSF1k7S6pAeFDCntLGbUaK/q3.png";
    String imgURL4 = "https://cdn.steemitimages.com/DQmQQfTZWrucufPbFyVar1kL3fS8ZQtbYH85uKALARgMj58/q4.png";
    String imgURL5 = "https://cdn.steemitimages.com/DQmUvWfYhmEEvZx1Uv3mSfsfx2fTS81yo2qQaReoFM7ioRi/q5.png";
    String imgURL6 = "https://cdn.steemitimages.com/DQmeYMnThK3VhvvzRS7ozn6GkmvKpfwZ6qFgzN9ppk9rZpJ/q6.png";
    String imgURL7 = "https://cdn.steemitimages.com/DQmczHmp2qebXDbrPA4RhKam9AyFzcaZPQ829Yq4rKUoLnK/q7.png";
    String imgURL8 = "https://cdn.steemitimages.com/DQmYkw9AD5G1ZygKhku8DgWXbP7DqPj7uJeTqzrWFTCVYZy/q8.png";
    String imgURL9 = "https://cdn.steemitimages.com/DQmRT4yPGe9DSnnYRtmJf6aLg85xKsr42QdNacNp4yoT72e/q9.png";
    String imgURL10 = "https://cdn.steemitimages.com/DQmdMWzddfgDXinwFnvDAqbzYcPZ4qqbU6Kk4mmnh3gDBC3/q10.png";


    int k = 2;
    int s = 0;
    int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_1);

        Quiz_List = new DataBase_Manager(getApplicationContext(),"QUIZ_List", null, 1);
        Check_ans = new DataBase_Manager(getApplicationContext(),"Check_ans", null, 1);
        memberDB = new DataBase_Manager(getApplicationContext(),"MEMBER_LIST", null, 1);

        answer = (EditText) findViewById(R.id.editText);
        imageView = (ImageView) findViewById(R.id.imageView);
        button01 = (Button) findViewById(R.id.button);

        Picasso.get()
                .load(imgURL1)
                .into(imageView);



    }

    public void next(View v) {
        Quiz_List.insert_answer();

        if (k == 2) {
            Picasso.get()
                    .load(imgURL2)
                    .into(imageView);

            Toast.makeText(getApplicationContext(), "2번째 문제", Toast.LENGTH_LONG).show();

            /*if( Quiz_List.Check_answer(answer.getText().toString())!=1 ){ //wrong

                Check_ans.insert("INSERT INTO Check_ans VALUES('X');");

            }
            else{
                Check_ans.insert("INSERT INTO Check_ans VALUES('O');");
                s = s + 1;

            }*/

        }

        if (k == 3) {
            Picasso.get()
                    .load(imgURL3)
                    .into(imageView);
            Toast.makeText(getApplicationContext(), "3번째 문제", Toast.LENGTH_LONG).show();

            /*if( Quiz_List.Check_answer(answer.getText().toString())!=1 ){ //wrong

                Check_ans.insert("INSERT INTO Check_ans VALUES('X');");
            }
            else{
                Check_ans.insert("INSERT INTO Check_ans VALUES('O');");
                s += 1;
            }*/
        }

        if (k == 4) {
            Picasso.get()
                    .load(imgURL4)
                    .into(imageView);
            Toast.makeText(getApplicationContext(), "4번째 문제", Toast.LENGTH_LONG).show();

            /*if( Quiz_List.Check_answer(answer.getText().toString())!=1 ){ //wrong

                Check_ans.insert("INSERT INTO Check_ans VALUES('X');");
            }
            else{
                Check_ans.insert("INSERT INTO Check_ans VALUES('O');");
                s += 1;
            }*/
        }

        if (k == 5) {
            Picasso.get()
                    .load(imgURL5)
                    .into(imageView);
            Toast.makeText(getApplicationContext(), "5번째 문제", Toast.LENGTH_LONG).show();

            /*if( Quiz_List.Check_answer(answer.getText().toString())!=1 ){ //wrong

                Check_ans.insert("INSERT INTO Check_ans VALUES('X');");
            }
            else{
                Check_ans.insert("INSERT INTO Check_ans VALUES('O');");
                s += 1;
            }*/
        }

        if (k == 6) {
            Picasso.get()
                    .load(imgURL6)
                    .into(imageView);
            Toast.makeText(getApplicationContext(), "6번째 문제", Toast.LENGTH_LONG).show();

            /*if( Quiz_List.Check_answer(answer.getText().toString())!=1 ){ //wrong

                Check_ans.insert("INSERT INTO Check_ans VALUES('X');");
            }
            else{
                Check_ans.insert("INSERT INTO Check_ans VALUES('O');");
                s += 1;
            }*/
        }

        if (k == 7) {
            Picasso.get()
                    .load(imgURL7)
                    .into(imageView);
            Toast.makeText(getApplicationContext(), "7번째 문제", Toast.LENGTH_LONG).show();

            /*if( Quiz_List.Check_answer(answer.getText().toString())!=1 ){ //wrong

                Check_ans.insert("INSERT INTO Check_ans VALUES('X');");
            }
            else{
                Check_ans.insert("INSERT INTO Check_ans VALUES('O');");
               s += 1;
            }*/
            answer.setText(null);
        }

        if (k == 8) {
            Picasso.get()
                    .load(imgURL8)
                    .into(imageView);
            Toast.makeText(getApplicationContext(), "8번째 문제", Toast.LENGTH_LONG).show();

            /*if( Quiz_List.Check_answer(answer.getText().toString())!=1 ){ //wrong

                Check_ans.insert("INSERT INTO Check_ans VALUES('X');");
            }
            else{
                Check_ans.insert("INSERT INTO Check_ans VALUES('O');");
                s += 1;
            }*/
        }


        if (k == 9) {
            Picasso.get()
                    .load(imgURL9)
                    .into(imageView);
            Toast.makeText(getApplicationContext(), "9번째 문제", Toast.LENGTH_LONG).show();

            /*if( Quiz_List.Check_answer(answer.getText().toString())!=1 ){ //wrong

                Check_ans.insert("INSERT INTO Check_ans VALUES('X');");
            }
            else{
                Check_ans.insert("INSERT INTO Check_ans VALUES('O');");
                s += 1;
            }*/
        }

        if (k == 10) {
            Picasso.get()
                    .load(imgURL10)
                    .into(imageView);
            Toast.makeText(getApplicationContext(), "마지막 문제", Toast.LENGTH_LONG).show();

            /*if( Quiz_List.Check_answer(answer.getText().toString())!=1 ){ //wrong

                Check_ans.insert("INSERT INTO Check_ans VALUES('X');");
            }
            else{
                Check_ans.insert("INSERT INTO Check_ans VALUES('O');");
                s += 1;
            }*/
        }

        if (k == 11) {

            /*if( Quiz_List.Check_answer(answer.getText().toString())!=1 ){ //wrong

                Check_ans.insert("INSERT INTO Check_ans VALUES('X');");
            }
            else{
                Check_ans.insert("INSERT INTO Check_ans VALUES('O');");
                s += 1;
                s = s + 10;
                memberDB.Modify_score(s,n);
            }
            s = s + 10;
            memberDB.Modify_score(s,n);
*/
            Toast.makeText(getApplicationContext(), "수고하셨습니다", Toast.LENGTH_LONG).show();
            Intent intent_Input = new Intent(getApplicationContext(), Question_2Activity.class);
            startActivity(intent_Input);



        }


        k++;

    }
}
