package com.example.hinge;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hinge.data.sharedPrefNames;

import java.time.LocalDate;
import java.time.Period;

public class DOB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_o_b);

        intiview();
    }

    DatePicker datepicker;
    TextView mtvage;
    ImageView mivNext;

    private void intiview() {

        datepicker = findViewById(R.id.datepicker);
        mtvage = findViewById(R.id.tvage);
        mivNext = findViewById(R.id.ivNext);

        setListeners();
    }

    int age;

    private void setListeners() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            datepicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    LocalDate today = LocalDate.now();
                    LocalDate currentdate = LocalDate.of(year, 1, dayOfMonth);
                    Period period = Period.between(currentdate, today);
                    mtvage.setText("Age " + period.getYears());
                    age = year;
                }
            });
        }

        mivNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                activityTriversalWithAnimation(DiscoverActivity.class);
            }
        });

    }

    //to save data int shared pref
    private void saveData() {
        sharedPrefNames name = new sharedPrefNames();
        SharedPreferences pref = getSharedPreferences(name.SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(name.age, Integer.toString(age));
        editor.apply();
    }

    //this function handles moving between activities
    private void activityTriversalWithAnimation(Class classname) {
        Intent intent = new Intent(DOB.this, classname);
        startActivity(intent);
    }

}