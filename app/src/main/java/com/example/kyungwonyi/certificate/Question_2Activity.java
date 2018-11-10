package com.example.kyungwonyi.certificate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Question_2Activity extends AppCompatActivity {

    DataBase_Manager Quiz_List, Check_ans;
    Button btnCheck;
    TextView ansView1,ansView2,ansView3,ansView4,ansView5,ansView6,ansView7,ansView8,ansView9,ansView10;

    ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_2);
        Quiz_List = new DataBase_Manager(getApplicationContext(), "QUIZ_List", null, 1);
        Check_ans = new DataBase_Manager(getApplicationContext(), "Check_ans", null, 1);

        ansView1 = (TextView)findViewById(R.id.textView5);
        ansView1.setText(Integer.toString(Quiz_List.Show_list(1)));
        ansView2 = (TextView)findViewById(R.id.textView8);
        ansView2.setText(Integer.toString(Quiz_List.Show_list(2)));
        ansView3 = (TextView)findViewById(R.id.textView11);
        ansView3.setText(Integer.toString(Quiz_List.Show_list(3)));
        ansView4 = (TextView)findViewById(R.id.textView14);
        ansView4.setText(Integer.toString(Quiz_List.Show_list(4)));
        ansView5 = (TextView)findViewById(R.id.textView17);
        ansView5.setText(Integer.toString(Quiz_List.Show_list(5)));
        ansView6 = (TextView)findViewById(R.id.textView20);
        ansView6.setText(Integer.toString(Quiz_List.Show_list(6)));
        ansView7 = (TextView)findViewById(R.id.textView23);
        ansView7.setText(Integer.toString(Quiz_List.Show_list(7)));
        ansView8 = (TextView)findViewById(R.id.textView26);
        ansView8.setText(Integer.toString(Quiz_List.Show_list(8)));
        ansView9 = (TextView)findViewById(R.id.textView29);
        ansView9.setText(Integer.toString(Quiz_List.Show_list(9)));
        ansView10 = (TextView)findViewById(R.id.textView32);
        ansView10.setText(Integer.toString(Quiz_List.Show_list(10)));
        }



    public void gotitle(View v) {
        Intent intent_Input = new Intent(getApplicationContext(), TitleActivity.class);
        startActivity(intent_Input);
    }


    public void explanation(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cdn.steemitimages.com/DQmZyWfdd2M56S1Vi1jQxQyymzqixVFw3TRN1TY2umHBZMF/a1.png"));
        startActivity(browserIntent);

    }

    public void explanation2(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cdn.steemitimages.com/DQmSawYDrUNjoDoHqeBbRSMsp2jw2ipfD73w4n6q5wB1WTY/a2.png"));
        startActivity(browserIntent);
    }

    public void explanation3(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cdn.steemitimages.com/DQmNps9pXcuDhTdnfNbqBGNpBAwiJZReXaUxACX5GFuuRju/a3.png"));
        startActivity(browserIntent);

    }
    public void explanation4(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cdn.steemitimages.com/DQmV9knwNqSXnH9X8nm6tYKD8bLaGrE7kQtxqKm6n2Z8jhy/a4.png"));
        startActivity(browserIntent);

    }
    public void explanation5(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cdn.steemitimages.com/DQmXJV6BtU1Kh81RV7DJ21oEuahPGQoMNkKdPszJBnFd5KG/a5.png"));
        startActivity(browserIntent);

    }
    public void explanation6(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cdn.steemitimages.com/DQmXYAHd7XV14uHxEeD1PaZhBmuuG9xouCgc9HdjxmqySPE/a6.png"));
        startActivity(browserIntent);

    }
    public void explanation7(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cdn.steemitimages.com/DQmZnMg5TkxNzJjzBgmUbd48m4VJyzkzccViKNGm5b6z5Ei/a7.png"));
        startActivity(browserIntent);

    }
    public void explanation8(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cdn.steemitimages.com/DQmUhALtECwN5YHoWbykXTeu335aeBkagoggTjYmEQBBC1Y/a8.png"));
        startActivity(browserIntent);

    }
    public void explanation9(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cdn.steemitimages.com/DQmUyTZPaz1U2smLWPjTZN8wNcUiP179gTVoVd6VrjFth1L/a9.png"));
        startActivity(browserIntent);

    }
    public void explanation10(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cdn.steemitimages.com/DQmQJ9k7jgcfLpA7Em17BtsaNrhbftyMnSANgYdptmSovjG/a10.png"));
        startActivity(browserIntent);

    }
}
