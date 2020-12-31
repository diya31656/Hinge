package com.example.hinge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class verified extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verified);

        initView();
    }

    TextView mtvcreate;
    TextView tvPrefill;

    private void initView() {
        mtvcreate = findViewById(R.id.tvcreate);
        tvPrefill = findViewById(R.id.tvPrefill);

        setListeners();
    }

    private void setListeners() {
        mtvcreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversalWithAnimation(name_screen.class);
            }
        });

        tvPrefill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversalWithAnimation(name_screen.class);
            }
        });

    }

    //this function handles moving between activities
    private void activityTriversalWithAnimation(Class classname) {
        Intent intent = new Intent(verified.this, classname);
        startActivity(intent);
    }

}
