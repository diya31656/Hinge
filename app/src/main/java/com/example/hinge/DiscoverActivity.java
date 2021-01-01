package com.example.hinge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hinge.data.Matches;
import com.example.hinge.data.People;

public class DiscoverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);

        initView();

    }

    TextView tvmName;
    TextView tvmTitleImage1;
    TextView tvmTitleImage2;
    TextView tvmTitleImage3;
    TextView tvmTitleImage4;
    TextView tvmTitleImage5;
    TextView tvmTitleImage6;
    TextView tvmTextContentTitle1;
    TextView tvmTextContentTitle2;
    TextView tvmTextContentTitle3;
    TextView tvmTextContent1;
    TextView tvmTextContent2;
    TextView tvmTextContent3;
    ImageView tivUserImage1;
    ImageView tivUserImage2;
    ImageView tivUserImage3;
    ImageView tivUserImage4;
    ImageView tivUserImage5;
    ImageView tivUserImage6;
    ImageView ivmDecline;
    TextView tvmAge;
    TextView tvmGender;
    TextView tvmHeight;
    TextView tvmLocation;
    TextView tvmEthanicity;
    TextView tvmEducation;
    TextView tvmReligion;
    TextView tvmCountry;
    ImageView ivmLike1;
    ImageView ivmLike2;
    ImageView ivmLike3;
    ImageView ivmLike4;
    ImageView ivmLike5;
    ImageView ivmLike6;
    ImageView ivmLike7;
    ImageView ivmLike8;
    ImageView ivmLike9;
    ImageView ivmStarDiscoverScreen;
    ImageView ivmHeartDiscoverScreen;
    ImageView ivmMessagetDiscoverScreen;
    ImageView ivmSettingsDiscoverScreen;

    private void initView() {
        tvmName = findViewById(R.id.tvName_discover);
        ivmDecline = findViewById(R.id.ivDecline1);
        tvmTitleImage1 = findViewById(R.id.tvTitleImage1);
        tvmTitleImage2 = findViewById(R.id.tvTitleImage2);
        tvmTitleImage3 = findViewById(R.id.tvTitleImage3);
        tvmTitleImage4 = findViewById(R.id.tvTitleImage4);
        tvmTitleImage5 = findViewById(R.id.tvTitleImage5);
        tvmTitleImage6 = findViewById(R.id.tvTitleImage6);
        tivUserImage1 = findViewById(R.id.ivUserImage1);
        tivUserImage2 = findViewById(R.id.ivUserImage2);
        tivUserImage3 = findViewById(R.id.ivUserImage3);
        tivUserImage4 = findViewById(R.id.ivUserImage4);
        tivUserImage5 = findViewById(R.id.ivUserImage5);
        tivUserImage6 = findViewById(R.id.ivUserImage6);
        tvmTextContentTitle1 = findViewById(R.id.tvTextContentTitle1);
        tvmTextContentTitle2 = findViewById(R.id.tvTextContentTitle2);
        tvmTextContentTitle3 = findViewById(R.id.tvTextContentTitle3);
        tvmTextContent1 = findViewById(R.id.tvTextContent1);
        tvmTextContent2 = findViewById(R.id.tvTextContent2);
        tvmTextContent3 = findViewById(R.id.tvTextContent3);
        tvmAge = findViewById(R.id.tvAge);
        tvmGender = findViewById(R.id.tvGender);
        tvmHeight = findViewById(R.id.tvHeight);
        tvmLocation = findViewById(R.id.tvLocation);
        tvmEthanicity = findViewById(R.id.tvEthanicity);
        tvmEducation = findViewById(R.id.tvEducation);
        tvmReligion = findViewById(R.id.tvReligion);
        tvmCountry = findViewById(R.id.tvCountry);
        ivmLike1 = findViewById(R.id.ivLike1);
        ivmLike2 = findViewById(R.id.ivLike2);
        ivmLike3 = findViewById(R.id.ivLike3);
        ivmLike4 = findViewById(R.id.ivLike4);
        ivmLike5 = findViewById(R.id.ivLike5);
        ivmLike6 = findViewById(R.id.ivLike6);
        ivmLike7 = findViewById(R.id.ivLike7);
        ivmLike8 = findViewById(R.id.ivLike8);
        ivmLike9 = findViewById(R.id.ivLike9);
        ivmStarDiscoverScreen = findViewById(R.id.ivStar);
        ivmHeartDiscoverScreen = findViewById(R.id.ivHeart);
        ivmMessagetDiscoverScreen = findViewById(R.id.ivMessaget);
        ivmSettingsDiscoverScreen = findViewById(R.id.ivSettings);


        settingClickListeners();
    }

    private void settingClickListeners() {
        ivmDecline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePersonInScreen();
            }
        });
        ivmLike1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePersonInScreen();
            }
        });
        ivmLike2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePersonInScreen();
            }
        });
        ivmLike3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePersonInScreen();
            }
        });
        ivmLike4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePersonInScreen();
            }
        });
        ivmLike5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePersonInScreen();
            }
        });
        ivmLike6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePersonInScreen();
            }
        });
        ivmLike7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePersonInScreen();
            }
        });
        ivmLike8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePersonInScreen();
            }
        });
        ivmLike9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePersonInScreen();
            }
        });
        ivmStarDiscoverScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversal(StandoutActivity.class);
            }
        });
        ivmHeartDiscoverScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversal(Like_you_Activity.class);
            }
        });

        ivmMessagetDiscoverScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversal(Matches_Activity.class);
            }
        });

        ivmSettingsDiscoverScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversal(SettingActivity.class);
            }
        });


    }

    int currentPerson = 1;
    People people = new People();

    private void changePersonInScreen() {

        if (currentPerson == 0) {
            setPerson(people.getLisa());
            currentPerson++;
        } else if (currentPerson == 1) {
            setPerson(people.getTzuyu());
            currentPerson = 0;
        }
    }

    private void setPerson(Matches match) {
        tvmName.setText(match.getName());
        String[] titlesImage = match.getImageTitles();
        tvmTitleImage1.setText(titlesImage[0]);
        tvmTitleImage2.setText(titlesImage[1]);
        tvmTitleImage3.setText(titlesImage[2]);
        tvmTitleImage4.setText(titlesImage[3]);
        tvmTitleImage5.setText(titlesImage[4]);
        tvmTitleImage6.setText(titlesImage[5]);

        int[] images = match.getImages();
        tivUserImage1.setImageResource(images[0]);
        tivUserImage2.setImageResource(images[1]);
        tivUserImage3.setImageResource(images[2]);
        tivUserImage4.setImageResource(images[3]);
        tivUserImage5.setImageResource(images[4]);
        tivUserImage6.setImageResource(images[5]);

        String[] contentTitle = match.getTextContentTitles();
        tvmTextContentTitle1.setText(contentTitle[0]);
        tvmTextContentTitle2.setText(contentTitle[1]);
        tvmTextContentTitle3.setText(contentTitle[2]);

        String[] content = match.getTextContent();
        tvmTextContent1.setText(content[0]);
        tvmTextContent2.setText(content[1]);
        tvmTextContent3.setText(content[2]);
        String ageStr = Integer.toString(match.getAge());
        tvmAge.setText(ageStr);
        tvmGender.setText(match.getGender());
        tvmHeight.setText(match.getHeight());
        tvmLocation.setText(match.getLocation());
        tvmEthanicity.setText(match.getEthnicity());
        tvmEducation.setText(match.getEducation());
        tvmReligion.setText(match.getReligion());
        tvmCountry.setText(match.getCountry());
    }

    private void activityTriversal(Class classname) {
        Intent intent = new Intent(DiscoverActivity.this, classname);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

}
