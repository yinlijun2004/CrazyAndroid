package com.example.crazyandroid;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

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