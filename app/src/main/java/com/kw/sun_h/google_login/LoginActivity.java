package com.kw.sun_h.google_login;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class LoginActivity extends Activity {
    TextView loginID = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginID = (TextView) findViewById(R.id.login_id);

        //Intent로 사용자 아이디 불러오기
        Intent nameIntent = getIntent();
        String name = nameIntent.getStringExtra("NAME");

        loginID.setText(name);
    }

    //로그아웃 버튼 클릭 시 로그아웃
    public void mClick(View v) {
        if (v.getId() == R.id.logout) {
            if (MainActivity.mGoogleApiClient != null && MainActivity.mGoogleApiClient.isConnected()) {
                //Auth.GoogleSIgnInApi.signOut(mGoogleApiClient);
                //mGoogleApiClient.disconnect();
                MainActivity.mGoogleApiClient.clearDefaultAccountAndReconnect().setResultCallback(new ResultCallback<Status>() {

                    @Override
                    public void onResult(@NonNull Status status) {
                        MainActivity.mGoogleApiClient.disconnect();
                    }
                });
            }
        }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
