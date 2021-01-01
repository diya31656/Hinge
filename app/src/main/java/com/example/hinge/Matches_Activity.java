package com.example.hinge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Matches_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches_);

        initViews();

    }

    private ImageView ivmHinge;
    private ImageView ivmStar;
    private ImageView ivmHeart;
    private ImageView ivmMessaget;
    private ImageView ivmSettings;

    private void initViews() {
        ivmHinge = findViewById(R.id.ivHinge);
        ivmStar = findViewById(R.id.ivStar);
        ivmHeart = findViewById(R.id.ivHeart);
        ivmMessaget = findViewById(R.id.ivMessaget);
        ivmSettings = findViewById(R.id.ivSettings);

        settingClickListeners();
    }

    private void settingClickListeners() {
        ivmHinge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversal(DiscoverActivity.class);
            }
        });

        ivmStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversal(StandoutActivity.class);
            }
        });

        ivmHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversal(Like_you_Activity.class);
            }
        });

        ivmSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversal(SettingActivity.class);
            }
        });
    }

    private void activityTriversal(Class classname) {
        Intent intent = new Intent(Matches_Activity.this, classname);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}