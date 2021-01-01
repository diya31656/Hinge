package com.example.hinge;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hinge.data.sharedPrefNames;
import com.yqritc.scalablevideoview.ScalableType;
import com.yqritc.scalablevideoview.ScalableVideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        check();
        initviews();


        Intent intent = new Intent(MainActivity.this,Learn_more_Activity.class);
        startActivity(intent);



        mTvTermsofService.setOnClickListener(v -> urlOpner("https://hinge.co/terms.html"));
        mTvPrivacyPolicy.setOnClickListener(v -> urlOpner("https://hinge.co/privacy.html"));


    }

    private void check() {
        sharedPrefNames name = new sharedPrefNames();
        SharedPreferences pref = getSharedPreferences(name.SHARED_PREF_NAME, MODE_PRIVATE);
        String phoneNumber = pref.getString(name.firstName, "12791");
        if(!phoneNumber.equals("12791")){
            activityTriversalWithAnimation(DiscoverActivity.class);
        }

    }

    private ScalableVideoView mBackgroundVideo;
    private TextView mTvTermsofService;
    private TextView mTvPrivacyPolicy;
    private TextView mtvPhone;
    private Button mbtn_facebook;

    //this function will initialise views
    private void initviews() {
        mBackgroundVideo = findViewById(R.id.videoView);
        mTvTermsofService = findViewById(R.id.tvTermsofService);
        mTvPrivacyPolicy = findViewById(R.id.tvPrivacyPolicy);
        mtvPhone = findViewById(R.id.tvPhone);
        mbtn_facebook = findViewById(R.id.btn_facebook);

        backgroundVideo();
        settingClickListeners();
    }

    private void settingClickListeners() {
        mTvTermsofService.setOnClickListener(v -> urlOpner("https://hinge.co/terms.html"));
        mTvPrivacyPolicy.setOnClickListener(v -> urlOpner("https://hinge.co/privacy.html"));

        mtvPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversalWithAnimation(phone_num.class);
            }
        });

        mbtn_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversalWithAnimation(phone_num.class);
            }
        });
    }

    //this function is responsible for the background video
    private void backgroundVideo() {
        try {
            mBackgroundVideo.setRawData(R.raw.backgroundvideo);
            mBackgroundVideo.setScalableType(ScalableType.CENTER_CROP);
            mBackgroundVideo.setLooping(true);
            mBackgroundVideo.prepare(mp -> mBackgroundVideo.start());

        } catch (IOException e) {
            e.printStackTrace();
            //ignore
        }
    }

    //this function is responsible for opening urls
    private void urlOpner(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    //this function handles moving between activities
    private void activityTriversalWithAnimation(Class classname) {
        Intent intent = new Intent(MainActivity.this, classname);
        startActivity(intent);
    }
}