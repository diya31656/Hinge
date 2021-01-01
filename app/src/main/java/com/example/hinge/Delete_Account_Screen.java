package com.example.hinge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hinge.data.sharedPrefNames;

public class Delete_Account_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete__account__screen);

        initView();
    }

    private Button btnOkay;
    private TextView tvmNotnow;
    private void initView() {
        btnOkay = findViewById(R.id.button6);
        tvmNotnow = findViewById(R.id.tvNotnow);
        setListener();
    }

    private void setListener() {
        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
            }
        });

        tvmNotnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void deleteData() {
        sharedPrefNames name = new sharedPrefNames();
        getApplicationContext().getSharedPreferences(name.SHARED_PREF_NAME, MODE_PRIVATE).edit().clear().apply();
        activityTriversalWithAnimation(MainActivity.class);
    }

    private void activityTriversalWithAnimation(Class classname) {
        Intent intent = new Intent(Delete_Account_Screen.this, classname);
        startActivity(intent);
    }
}