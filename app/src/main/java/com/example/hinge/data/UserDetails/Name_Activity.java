package com.example.hinge.data.UserDetails;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hinge.R;
import com.example.hinge.data.sharedPrefNames;

public class Name_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_);
        initView();
    }

    EditText etmFirstName;
    EditText etmLastName;
    ImageView ivmBack;

    private void initView() {
        etmFirstName = findViewById(R.id.etFirstName);
        etmLastName = findViewById(R.id.etLastName);
        ivmBack = findViewById(R.id.ivBack);
        setData();
        setListeners();
    }

    private void setListeners() {
        ivmBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setData() {
        sharedPrefNames name = new sharedPrefNames();
        etmFirstName.setText(getData(name.firstName));
        etmLastName.setText(getData(name.lastName));
    }

    private String getData(String key) {
        sharedPrefNames name = new sharedPrefNames();
        SharedPreferences pref = getSharedPreferences(name.SHARED_PREF_NAME, MODE_PRIVATE);
        return pref.getString(key, "nan");
    }

    private void saveData() {
        sharedPrefNames name = new sharedPrefNames();
        SharedPreferences pref = getSharedPreferences(name.SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(name.firstName, etmFirstName.getText().toString());
        editor.putString(name.lastName, etmLastName.getText().toString());
        editor.apply();
    }

    @Override
    public void onBackPressed() {
        saveData();
        super.onBackPressed();
    }
}