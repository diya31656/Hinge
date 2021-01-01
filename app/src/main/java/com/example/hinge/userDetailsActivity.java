package com.example.hinge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hinge.data.UserDetails.Age_Activity;
import com.example.hinge.data.UserDetails.Gender_Activity;
import com.example.hinge.data.UserDetails.Name_Activity;
import com.example.hinge.data.sharedPrefNames;

public class userDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        initView();
    }

    private TextView tvmTitle;
    private ImageView ivmback;
    private TextView tvmNameTitle;
    private TextView tvmName;
    private TextView tvmGenderTitle;
    private TextView tvmGender;
    private TextView tvmAgeTitle;
    private TextView tvmAge;
    private TextView tvmEthanicity;


    private void initView() {
        tvmTitle = findViewById(R.id.tvTitle);
        ivmback = findViewById(R.id.ivback);
        tvmNameTitle = findViewById(R.id.tvNameTitle);
        tvmName = findViewById(R.id.tvName);
        tvmGenderTitle = findViewById(R.id.tvGenderTitle);
        tvmGender = findViewById(R.id.tvGender);
        tvmAgeTitle = findViewById(R.id.tvAgeTitle);
        tvmAge = findViewById(R.id.tvAge);
        tvmEthanicity = findViewById(R.id.tvEthanicity);


        setData();
        setListeners();
    }

    private void setListeners() {
        ivmback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        tvmNameTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversalWithAnimation(Name_Activity.class);
            }
        });
        tvmName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversalWithAnimation(Name_Activity.class);
            }
        });
        tvmGenderTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversalWithAnimation(Gender_Activity.class);
            }
        });

        tvmGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversalWithAnimation(Gender_Activity.class);
            }
        });
        tvmAgeTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversalWithAnimation(Age_Activity.class);
            }
        });
        tvmAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversalWithAnimation(Age_Activity.class);
            }
        });
    }

    private void setData() {
        sharedPrefNames name = new sharedPrefNames();
        tvmTitle.setText(getData(name.firstName));
        tvmName.setText(getData(name.firstName));
        tvmGender.setText(getData(name.gender));
        tvmAge.setText(getData(name.age));
        if(!getData(name.ethanicity).equals("nan")) tvmEthanicity.setText(getData(name.ethanicity));

    }

    private String getData(String key) {
        sharedPrefNames name = new sharedPrefNames();
        SharedPreferences pref = getSharedPreferences(name.SHARED_PREF_NAME, MODE_PRIVATE);
        return pref.getString(key, "nan");
    }

    private void activityTriversalWithAnimation(Class classname) {
        Intent intent = new Intent(userDetailsActivity.this, classname);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}