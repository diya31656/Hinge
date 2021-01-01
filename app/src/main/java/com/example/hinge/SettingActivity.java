package com.example.hinge;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hinge.data.sharedPrefNames;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initView();

    }

    private ImageView ivmHinge;
    private ImageView ivmStar;
    private ImageView ivmHeart;
    private ImageView ivmMessaget;
    private TextView tvmHelpCenter;
    private TextView tvmName;
    private TextView tvmAccount;

    private void initView() {

        ivmHinge = findViewById(R.id.ivHinge);
        ivmStar = findViewById(R.id.ivStar);
        ivmHeart = findViewById(R.id.ivHeart);
        ivmMessaget = findViewById(R.id.ivMessaget);
        tvmHelpCenter = findViewById(R.id.tvHelpCenter);
        tvmName = findViewById(R.id.tvName);
        tvmAccount = findViewById(R.id.tvAccount);

        setDataNanme();
        settingClickListeners();

    }

    private void setDataNanme() {
        sharedPrefNames name = new sharedPrefNames();
        SharedPreferences pref = getSharedPreferences(name.SHARED_PREF_NAME, MODE_PRIVATE);
        String firstname = pref.getString(name.firstName, "Nipun");
        tvmName.setText(firstname);
    }

    private void settingClickListeners() {

        ivmHinge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversal(DiscoverActivity.class);
            }
        });

        ivmHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversal(Like_you_Activity.class);
            }
        });

        ivmMessaget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversal(Matches_Activity.class);
            }
        });

        ivmStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversal(StandoutActivity.class);
            }
        });

        tvmHelpCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urlOpner("https://hingeapp.zendesk.com/hc/en-us");
            }
        });

        tvmAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversal(AccountActivity.class);
            }
        });
    }

    private void activityTriversal(Class classname) {
        Intent intent = new Intent(SettingActivity.this, classname);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
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