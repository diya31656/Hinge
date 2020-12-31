package com.example.hinge;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.broooapps.otpedittext2.OnCompleteListener;
import com.broooapps.otpedittext2.OtpEditText;
import com.example.hinge.data.sharedPrefNames;

public class otp_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_screen);

        initView();

    }

    TextView textView;
    OtpEditText otpEditText;
    ImageView ivNext;

    //this function will initialize views
    private void initView() {
        textView = findViewById(R.id.tvPhoneNumberDisplay);
        otpEditText = findViewById(R.id.etOtp);
        ivNext = findViewById(R.id.ivNext);

        setPhoneNumber();
        setListeners();
    }

    //to set phone number user entered in the first previous page
    private void setPhoneNumber() {
        sharedPrefNames name = new sharedPrefNames();
        SharedPreferences pref = getSharedPreferences(name.SHARED_PREF_NAME, MODE_PRIVATE);
        String phoneNumber = pref.getString(name.phoneNumber, "454");
        textView.setText(phoneNumber);
    }

    //this function will set listeners
    private void setListeners() {

        otpEditText.setOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(String value) {
                activityTriversalWithAnimation(verified.class);
            }
        });

        ivNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otpEditText.triggerErrorAnimation();
            }
        });

    }

    //this function handles moving between activities
    private void activityTriversalWithAnimation(Class classname) {
        Intent intent = new Intent(otp_screen.this, classname);
        startActivity(intent);
    }

}