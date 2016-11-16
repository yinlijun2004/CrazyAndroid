package com.example.crazyandroid.activities;
import com.example.crazyandroid.R;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SpinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        String[] arr = {"SunWuKong", "ZhuBaJie", "TangSeng"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, arr);
        spinner.setAdapter(adapter);
    }
}
