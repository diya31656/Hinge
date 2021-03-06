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

public class email_screen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_screen);

        initview();
    }

    EditText metEmail;
    ImageView ivmNext;

    private void initview() {
        metEmail = findViewById(R.id.etEmail);
        ivmNext = findViewById(R.id.ivNext);

        setListeners();
    }

    boolean isButtonEnabled = false;

    private void setListeners() {

        metEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().contains("@")) {
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

        ivmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isButtonEnabled) {
                    saveData();
                    activityTriversalWithAnimation(DOB.class);
                } else {
                    metEmail.setError("Enter valid Email address");
                }
            }
        });
    }

    private void saveData() {
        sharedPrefNames name = new sharedPrefNames();
        SharedPreferences pref = getSharedPreferences(name.SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(name.email, metEmail.getText().toString());
        editor.apply();
    }

    //this function handles moving between activities
    private void activityTriversalWithAnimation(Class classname) {
        Intent intent = new Intent(email_screen.this, classname);
        startActivity(intent);
    }

}