package com.example.hinge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hinge.data.sharedPrefNames;

public class ethnicity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ethnicity);

        initView();
    }

    TextView tvAmerican;
    TextView tveast;
    TextView tvmiddle;
    TextView tvsouth;
    TextView tvother;
    TextView tvaAfrican;
    TextView tvhispanic;
    TextView tvpacific;
    TextView tvwhite;
    TextView tvprefer;

    private void initView() {
        tvAmerican = findViewById(R.id.tvAmerican);
        tveast = findViewById(R.id.tveast);
        tvmiddle = findViewById(R.id.tvmiddle);
        tvsouth = findViewById(R.id.tvsouth);
        tvaAfrican = findViewById(R.id.tvaAfrican);
        tvhispanic = findViewById(R.id.tvhispanic);
        tvpacific = findViewById(R.id.tvpacific);
        tvwhite = findViewById(R.id.tvwhite);
        tvprefer = findViewById(R.id.tvprefer);
        tvother = findViewById(R.id.tvother);

        setListeners();
    }

    private void setListeners() {
        tvAmerican.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData("American Indian");
                activityTriversalWithAnimation(DiscoverActivity.class);
            }
        });
        tveast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData("East Asian");
                activityTriversalWithAnimation(DiscoverActivity.class);
            }
        });
        tvmiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData("Middle Eastern");
                activityTriversalWithAnimation(DiscoverActivity.class);
            }
        });
        tvsouth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData("South Asian");
                activityTriversalWithAnimation(DiscoverActivity.class);
            }
        });
        tvother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData("other");
                activityTriversalWithAnimation(DiscoverActivity.class);
            }
        });
        tvaAfrican.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData("African Descent");
                activityTriversalWithAnimation(DiscoverActivity.class);
            }
        });
        tvhispanic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData("Hispanic");
                activityTriversalWithAnimation(DiscoverActivity.class);
            }
        });
        tvpacific.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData("Pacific Islander");
                activityTriversalWithAnimation(DiscoverActivity.class);
            }
        });
        tvwhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData("Caucasian");
                activityTriversalWithAnimation(DiscoverActivity.class);
            }
        });
        tvprefer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData("Prefer Not to Say");
                activityTriversalWithAnimation(DiscoverActivity.class);
            }
        });
    }

    private void saveData(String value) {
        sharedPrefNames name = new sharedPrefNames();
        SharedPreferences pref = getSharedPreferences(name.SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(name.ethanicity, value);
        editor.apply();
    }
    private void activityTriversalWithAnimation(Class classname) {
        Intent intent = new Intent(ethnicity.this, classname);
        startActivity(intent);
    }

}