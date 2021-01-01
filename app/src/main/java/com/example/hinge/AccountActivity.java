package com.example.hinge;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hinge.data.sharedPrefNames;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        initview();
    }

    private TextView etmPhoneNumberDisplay;
    private TextView etmEmailDisplay;
    private TextView tvmPrivacyPolicy;
    private TextView tvmTermsofService;
    private TextView tvmsafeDating;
    private TextView tvmLicenses;
    private TextView tvLogout;
    private TextView tvmDelete;

    private void initview() {
        etmPhoneNumberDisplay = findViewById(R.id.etPhoneNumberDisplay);
        etmEmailDisplay = findViewById(R.id.etEmailDisplay);
        tvmPrivacyPolicy = findViewById(R.id.tvPrivacyPolicy);
        tvmTermsofService = findViewById(R.id.tvTermsofService);
        tvmsafeDating = findViewById(R.id.tvsafeDating);
        tvmLicenses = findViewById(R.id.tvLicenses);
        tvLogout = findViewById(R.id.tvLogout);
        tvmDelete = findViewById(R.id.tvDelete);

        setData();
        setListeners();
    }

    private void setListeners() {
        tvmPrivacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urlOpner("https://hinge.co/privacy.html");
            }
        });

        tvmTermsofService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urlOpner("https://hinge.co/terms.html");
            }
        });
        tvmsafeDating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urlOpner("https://hingeapp.zendesk.com/hc/en-us/articles/360007194774-Safe-Dating-Advice");
            }
        });
        tvmLicenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urlOpner("https://hingeapp.zendesk.com/hc/en-us/articles/360013413034-Android-Open-Source-Software");
            }
        });
        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
            }
        });
        tvmDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
            }
        });
    }

    private void urlOpner(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void setData() {
        sharedPrefNames name = new sharedPrefNames();
        etmPhoneNumberDisplay.setText(getData("+91 "+name.phoneNumber));
        etmEmailDisplay.setText(getData(name.email));
    }

    private String getData(String key) {
        sharedPrefNames name = new sharedPrefNames();
        SharedPreferences pref = getSharedPreferences(name.SHARED_PREF_NAME, MODE_PRIVATE);
        return pref.getString(key, "nan");
    }

    private void deleteData() {
        sharedPrefNames name = new sharedPrefNames();
        getApplicationContext().getSharedPreferences(name.SHARED_PREF_NAME, MODE_PRIVATE).edit().clear().apply();
        activityTriversalWithAnimation(MainActivity.class);
    }

    private void activityTriversalWithAnimation(Class classname) {
        Intent intent = new Intent(AccountActivity.this, classname);
        startActivity(intent);
    }

}