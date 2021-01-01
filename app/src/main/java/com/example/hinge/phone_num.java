package com.example.hinge;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hinge.data.sharedPrefNames;

public class phone_num extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_num);

        initView();
    }

    EditText etmPhoneNumber;
    ImageView ivmNext;

    //this function is responsible for initializing views
    private void initView() {
        etmPhoneNumber = findViewById(R.id.etPhoneNumber);
        ivmNext = findViewById(R.id.ivNext);

        setClicklistener();
    }

    private void setClicklistener() {

        ivmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isButtonEnabled) {
                    saveData();
                    activityTriversalWithAnimation(otp_screen.class);
                } else {
                    etmPhoneNumber.setError("Enter valid Phone number");
                }
            }
        });

        setTextChangeListener();
    }

    //to save data int shared pref
    private void saveData() {
        sharedPrefNames name = new sharedPrefNames();
        SharedPreferences pref = getSharedPreferences(name.SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(name.phoneNumber, etmPhoneNumber.getText().toString());
        editor.apply();
    }


    boolean isButtonEnabled = false;

    //this function monitors the edittext for changes
    private void setTextChangeListener() {
        etmPhoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() < 10 || s.toString().trim().length()>10) {
                    isButtonEnabled = false;
                    ivmNext.setImageResource(R.drawable.phone_next_white);
                } else {
                    isButtonEnabled = true;
                    ivmNext.setImageResource(R.drawable.phone_next_black);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    //this function handles moving between activities
    private void activityTriversalWithAnimation(Class classname) {
        Intent intent = new Intent(phone_num.this, classname);
        startActivity(intent);
    }
}
