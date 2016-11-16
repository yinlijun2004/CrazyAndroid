package com.example.crazyandroid.activities;
import com.example.crazyandroid.R;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.StackView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StackViewActivity extends AppCompatActivity {
    StackView stackView;
    int[] imageIds = new int[] {
            android.R.drawable.ic_btn_speak_now, android.R.drawable.ic_delete, android.R.drawable.ic_dialog_alert, android.R.drawable.ic_dialog_dialer,
            android.R.drawable.ic_dialog_email, android.R.drawable.ic_dialog_info, android.R.drawable.ic_dialog_map, android.R.drawable.ic_input_add,
            android.R.drawable.ic_input_delete, android.R.drawable.ic_input_get, android.R.drawable.ic_lock_idle_alarm, android.R.drawable.ic_lock_idle_low_battery
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_view);
        stackView = (StackView)findViewById(R.id.stack_view);
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for(int i = 0; i < imageIds.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("image", imageIds[i]);
            listItems.add(item);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems, R.layout.cell, new String[] {"image"}, new int[] {R.id.image1});
        stackView.setAdapter(simpleAdapter);
    }

    public void next(View v) {
        stackView.showNext();
    }
    public void prev(View v) {
        stackView.showPrevious();
    }
}
