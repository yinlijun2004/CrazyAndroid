package com.example.crazyandroid.activities;
import com.example.crazyandroid.R;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MixViewActivity extends AppCompatActivity {
    final int[] imageIds = {
            android.R.drawable.ic_btn_speak_now, android.R.drawable.ic_delete, android.R.drawable.ic_dialog_alert, android.R.drawable.ic_dialog_dialer,
            android.R.drawable.ic_dialog_email, android.R.drawable.ic_dialog_info, android.R.drawable.ic_dialog_map, android.R.drawable.ic_input_add,
            android.R.drawable.ic_input_delete, android.R.drawable.ic_input_get, android.R.drawable.ic_lock_idle_alarm, android.R.drawable.ic_lock_idle_low_battery
    };
    private int currentImage = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mix_view);
        LinearLayout root = (LinearLayout)findViewById(R.id.root);
        final ImageView imageView = new ImageView(this);
        root.addView(imageView);
        imageView.setImageResource(imageIds[0]);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(imageIds[++currentImage % imageIds.length]);
            }
        });
    }
}
