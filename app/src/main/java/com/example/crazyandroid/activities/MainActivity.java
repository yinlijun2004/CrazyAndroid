package com.example.crazyandroid.activities;

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
            "AdapterViewFlipperActivity",
            "ArrayAdapterActivity",
            "AutoCompleteActivity",
            "BaseAdapterActivity",
            "CodeViewActivity",
            "DrawViewActivity",
            "ExpandableListActivity",
            "FrameLayoutActivity",
            "LinearLayoutActivity",
            "MainListActivity",
            "RelativeLayoutActivity",
            "SimpleAdapterActivity",
            "SpinnerActivity",
            "StackViewActivity",
            "TableLayoutActivity",
            "PreferenceActivityTest",
            "FragementTestMainActivity"
    };
    Class<?> clazzs[] = {
            AdapterViewFlipperActivity.class,
            ArrayAdapterActivity.class,
            AutoCompleteActivity.class,
            BaseAdapterActivity.class,
            CodeViewActivity.class,
            DrawViewActivity.class,
            ExpandableListActivity.class,
            FrameLayoutActivity.class,
            LinearLayoutActivity.class,
            MainListActivity.class,
            RelativeLayoutActivity.class,
            SimpleAdapterActivity.class,
            SpinnerActivity.class,
            StackViewActivity.class,
            TableLayoutActivity.class,
            PreferenceActivityTest.class,
            FragementTestMainActivity.class
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, activities);
        setListAdapter(adapter);
    }
    @Override
    public Intent intentForPosition(int position) {
        return new Intent(MainActivity.this, clazzs[position]);
    }
}
/*
public class MainActivity extends ListActivity {
    private final String[] activities = new String[] {
            "AdapterViewFlipperActivity",
            "ArrayAdapterActivity",
            "AutoCompleteActivity",
            "BaseAdapterActivity",
            "CodeViewActivity",
            "DrawViewActivity",
            "ExpandableListActivity",
            "FrameLayoutActivity",
            "LinearLayoutActivity",
            "MainListActivity",
            "RelativeLayoutActivity",
            "SimpleAdapterActivity",
            "SpinnerActivity",
            "StackViewActivity",
            "TableLayoutActivity",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, activities);
        setListAdapter(adapter);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String className = activities[i];
                try {
                    Intent intent = new Intent(MainActivity.this, Class.forName(getPackageName() + "." + className));
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
*/