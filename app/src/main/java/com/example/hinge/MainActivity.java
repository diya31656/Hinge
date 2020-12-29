package com.example.hinge;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.yqritc.scalablevideoview.ScalableType;
import com.yqritc.scalablevideoview.ScalableVideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ScalableVideoView mBackgroundVideo;
    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBackgroundVideo = findViewById(R.id.videoView);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.backgroundvideo);
        try {
            mBackgroundVideo.setRawData(R.raw.backgroundvideo);
            mBackgroundVideo.setScalableType(ScalableType.CENTER_CROP);
            mBackgroundVideo.setLooping(true);
            mBackgroundVideo.prepare(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mBackgroundVideo.start();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        mBackgroundVideo.start();
    }
}