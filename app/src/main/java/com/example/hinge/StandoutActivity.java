package com.example.hinge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class StandoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standout);

        initViews();
    }

    ImageView ivmhingeStandoutScreen;

    private void initViews() {
        ivmhingeStandoutScreen = findViewById(R.id.ivhingeStandoutScreen);

        settingClickListeners();
    }

    private void settingClickListeners() {
        ivmhingeStandoutScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversal(DiscoverActivity.class);
            }
        });
    }

    private void activityTriversal(Class classname) {
        Intent intent = new Intent(StandoutActivity.this, classname);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}