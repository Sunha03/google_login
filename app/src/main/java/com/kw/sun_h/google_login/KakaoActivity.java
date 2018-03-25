package com.kw.sun_h.google_login;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.kakao.auth.ErrorCode;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.auth.ErrorCode;

import static android.content.ContentValues.TAG;

public class KakaoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kakao);
        requestMe();
    }

    protected void requestMe() {
        UserManagement.requestMe(new MeResponseCallback() {

            @Override
            public void onFailure(ErrorResult errorResult) {
                String message = "failed to get user info. msg = " + errorResult;
                Log.e(TAG, message);

                ErrorCode result = ErrorCode.valueOf(errorResult.getErrorCode());
                if(result == ErrorCode.CLIENT_ERROR_CODE) {
                    finish();
                } else {
                    kakaoLoginActivity();
                }
            }

            @Override
            public void onSuccess(UserProfile result) {
                Log.e("Superdroid", "UserProfile : " + result);
                Log.e("Superdroid", "로그인 성공!");

                chooseActivity();
            }

            @Override
            public void onSessionClosed(ErrorResult errorResult) {
                kakaoLoginActivity();
            }

            @Override
            public void onNotSignedUp() {
                //카카오 회원 아닐 때
            }
        });
    }

    private void chooseActivity() {
        startActivity(new Intent(this, ChooseActivity.class));
        finish();
    }

    private void kakaoLoginActivity() {
        startActivity(new Intent(this, KakaoLoginActivity.class));
        finish();
    }
}