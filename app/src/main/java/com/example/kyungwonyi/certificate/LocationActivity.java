package com.example.kyungwonyi.certificate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class LocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location);
    }


    public void goToMap01(View v) {
        Toast.makeText(getApplicationContext(), "지도 보기", Toast.LENGTH_LONG).show();

        Uri map = Uri.parse("geo:37.327095 , 126.844164 ?q=Human Resources Development Service of Korea Seoul Regional HQ");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, map);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void goToMap02(View v) {
        Toast.makeText(getApplicationContext(), "지도 보기", Toast.LENGTH_LONG).show();

        Uri map = Uri.parse("geo:37.327095 , 126.844164 ?q=한국산업인력공단부산지역본부");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, map);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void goToMap03(View v) {
        Toast.makeText(getApplicationContext(), "지도 보기", Toast.LENGTH_LONG).show();

        Uri map = Uri.parse("geo:37.327095 , 126.844164 ?q=한국산업인력공단중부지역본부");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, map);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void goToMap04(View v) {
        Toast.makeText(getApplicationContext(), "지도 보기", Toast.LENGTH_LONG).show();

        Uri map = Uri.parse("geo:37.327095 , 126.844164 ?q=대구광역시 달서구 성서공단로 213(갈산동)");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, map);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void goToMap05(View v) {
        Toast.makeText(getApplicationContext(), "지도 보기", Toast.LENGTH_LONG).show();

        Uri map = Uri.parse("geo:37.327095 , 126.844164 ?q=광주광역시 북구 첨단벤처로 82(대촌동)");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, map);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }



}
