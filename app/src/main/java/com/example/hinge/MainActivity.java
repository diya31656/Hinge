package com.example.hinge;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.yqritc.scalablevideoview.ScalableType;
import com.yqritc.scalablevideoview.ScalableVideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ScalableVideoView mBackgroundVideo;
    private TextView mTvTermsofService;
    private TextView mTvPrivacyPolicy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initviews();

        Intent intent = new Intent(MainActivity.this,DiscoverActivity.class);
        startActivity(intent);

        mTvTermsofService.setOnClickListener(v -> urlOpner("https://hinge.co/terms.html"));
        mTvPrivacyPolicy.setOnClickListener(v -> urlOpner("https://hinge.co/privacy.html"));

    }

    //this function will initialise views
    private void initviews() {
        mBackgroundVideo = findViewById(R.id.videoView);
        mTvTermsofService = findViewById(R.id.tvTermsofService);
        mTvPrivacyPolicy = findViewById(R.id.tvPrivacyPolicy);
        backgroundVideo();
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
}