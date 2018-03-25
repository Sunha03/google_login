package com.kw.sun_h.google_login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapView;

public class NaverMapActivity extends NMapActivity {
    private NMapView mMapView;
    private final String CLIENT_ID = "IF0DFznGgA8DK4mf2sAo";    //내 Client ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naver_map);

        //네이버 지도 표시
        mMapView = new NMapView(this);
        setContentView(mMapView);
        mMapView.setClientId(CLIENT_ID);    //Client ID 값 설정
        mMapView.setClickable(true);
        mMapView.setEnabled(true);
        mMapView.setFocusable(true);
        mMapView.setFocusableInTouchMode(true);
        mMapView.requestFocus();

        //오버레이 아이템
        //mMapViewerResourceProvider = new NMapViewerResourceProvider(this);

    }
}
