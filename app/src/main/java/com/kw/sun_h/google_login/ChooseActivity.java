package com.kw.sun_h.google_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
    }

    public void myClick(View v) {
        Intent goIntent = null;

        if(v.getId() == R.id.google) {
            goIntent = new Intent(this, MainActivity.class);
        }
        else if(v.getId() == R.id.kakao) {
            goIntent = new Intent(this, KakaoActivity.class);
        }
        else if(v.getId() == R.id.naver_map) {
            goIntent = new Intent(this, NaverMapActivity.class);
        }

        startActivity(goIntent);
    }
}
