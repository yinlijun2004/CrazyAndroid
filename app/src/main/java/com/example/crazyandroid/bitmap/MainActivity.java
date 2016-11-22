 package com.example.crazyandroid.bitmap;

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
            "PaintMainActivity",
            "PathMainActivity",
            "PathFontActivity",
            "DoubleDrawMainActivity",
    };
    Class<?> clazzs[] = {
            PaintMainActivity.class,
            PathMainActivity.class,
            PathFontActivity.class,
            DoubleDrawMainActivity.class,
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, activities);
        setListAdapter(adapter);
    }
    @Override
    public Intent intentForPosition(int position) {
        return new Intent(com.example.crazyandroid.bitmap.MainActivity.this, clazzs[position]);
    }
}
