package com.example.crazyandroid.activities;
import com.example.crazyandroid.R;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class DrawViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_view);

        final DrawView drawView = new DrawView(this);
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.activity_draw_view);
        layout.addView(drawView);
        drawView.setMinimumHeight(500);
        drawView.setMinimumWidth(300);
    }
}
