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

public class name_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_screen);

        initView();
    }

    ImageView mivNext;
    EditText metFirstName;
    EditText metLastName;

    boolean isButtonEnabled = false;

    private void initView() {

        mivNext = findViewById(R.id.ivNext);
        metFirstName = findViewById(R.id.etFirstName);
        metLastName = findViewById(R.id.etLastName);

        setListeners();
    }

    private void setListeners() {

        mivNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isButtonEnabled) {
                    saveData();
                    activityTriversalWithAnimation(email_screen.class);
                } else {
                    metFirstName.setError("Please enter valid name");
                }
            }
        });

        metFirstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() < 3) {
                    isButtonEnabled = false;
                    mivNext.setImageResource(R.drawable.phone_next_white);
                } else {
                    isButtonEnabled = true;
                    mivNext.setImageResource(R.drawable.phone_next_black);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    //this function handles moving between activities
    private void activityTriversalWithAnimation(Class classname) {
        Intent intent = new Intent(name_screen.this, classname);
        startActivity(intent);
    }


    //to save data int shared pref
    private void saveData() {
        sharedPrefNames name = new sharedPrefNames();
        SharedPreferences pref = getSharedPreferences(name.SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(name.firstName, metFirstName.getText().toString());
        if (!metLastName.getText().toString().isEmpty()) {
            editor.putString(name.lastName, metLastName.getText().toString());
        }

        editor.apply();

    }

}