package com.example.crazyandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ArrayAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);
        ListView list1 = (ListView)findViewById(R.id.list1);
        ListView list2 = (ListView)findViewById(R.id.list2);
        String[] arr1 = {"SunWuKong", "ZhuBaJie", "NiuMoWang"};
        String[] arr2 = {"JAVA", "Hibernate", "Spring", "Android"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.array_item, arr1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.checked_item, R.id.TextView, arr2);
        list1.setAdapter(adapter1);
        list2.setAdapter(adapter2);
    }
}
