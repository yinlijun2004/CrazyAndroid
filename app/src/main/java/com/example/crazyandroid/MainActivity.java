package com.example.crazyandroid;

import android.app.Activity;
import android.os.Bundle;

import android.app.LauncherActivity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends LauncherActivity {
    private final String[] activities = {
            ".activities",
            ".bitmap"
    };
    Class<?> clazzs[] = {
            com.example.crazyandroid.activities.MainActivity.class,
            com.example.crazyandroid.bitmap.MainActivity.class
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, activities);
        setListAdapter(adapter);
    }
    @Override
    public Intent intentForPosition(int position) {
        return new Intent(com.example.crazyandroid.MainActivity.this, clazzs[position]);
    }
}
