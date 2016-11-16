package com.example.crazyandroid.activities;

import com.example.crazyandroid.R;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class BaseAdapterActivity extends Activity {
    ListView myList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter);
        myList = (ListView)findViewById(R.id.mylist);
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return 40;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                LinearLayout line = new LinearLayout(BaseAdapterActivity.this);
                line.setOrientation(LinearLayout.VERTICAL);
                ImageView image = new ImageView(BaseAdapterActivity.this);
                image.setImageResource(android.R.drawable.ic_btn_speak_now);
                TextView text = new TextView(BaseAdapterActivity.this);
                text.setText("NUM." + i + " Item");
                text.setTextColor(Color.RED);
                line.addView(image);
                line.addView(text);
                return line;
            }
        };
        myList.setAdapter(adapter);
    }
}
