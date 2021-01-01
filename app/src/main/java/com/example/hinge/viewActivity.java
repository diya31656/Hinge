package com.example.hinge;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hinge.data.Matches;
import com.example.hinge.data.People;
import com.example.hinge.data.sharedPrefNames;

public class viewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

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
    TextView tvmAge;
    TextView tvmGender;
    TextView tvmHeight;
    TextView tvmLocation;
    TextView tvmEthanicity;
    TextView tvmEducation;
    TextView tvmReligion;
    TextView tvmCountry;
    TextView tvmEdit;
    ImageView ivmback;

    private void initView() {
        tvmName = findViewById(R.id.tvTitle);
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
        ivmback = findViewById(R.id.ivback);
        tvmEdit = findViewById(R.id.textView6);

        setPerson();
        setListeners();
    }

    private void setListeners() {
        ivmback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tvmEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityTriversal(userDetailsActivity.class);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void setPerson() {

        sharedPrefNames name = new sharedPrefNames();
        SharedPreferences pref = getSharedPreferences(name.SHARED_PREF_NAME, MODE_PRIVATE);

        People people = new People();
        Matches match = people.getUser();
        tvmName.setText(pref.getString(name.firstName, "454"));
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
        tvmAge.setText(pref.getString(name.age, "20"));
        tvmGender.setText(pref.getString(name.gender, "Man"));
        tvmHeight.setText(pref.getString(name.height, "5 6"));
        tvmLocation.setText(pref.getString(name.location, "Bangalore"));
        tvmEthanicity.setText(pref.getString(name.ethanicity, "South asia"));
        tvmEducation.setText(pref.getString(name.education, "Masai"));
        tvmReligion.setText(pref.getString(name.religion, "something"));
        tvmCountry.setText(pref.getString(name.country, "India"));
    }

    private void activityTriversal(Class classname) {
        Intent intent = new Intent(viewActivity.this, classname);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }


}