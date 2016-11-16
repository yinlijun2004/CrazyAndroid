package com.example.crazyandroid;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class AdapterViewFlipperActivity extends AppCompatActivity {
    int[] imageIds = new int[] {
            android.R.drawable.ic_btn_speak_now, android.R.drawable.ic_delete, android.R.drawable.ic_dialog_alert, android.R.drawable.ic_dialog_dialer,
            android.R.drawable.ic_dialog_email, android.R.drawable.ic_dialog_info, android.R.drawable.ic_dialog_map, android.R.drawable.ic_input_add,
            android.R.drawable.ic_input_delete, android.R.drawable.ic_input_get, android.R.drawable.ic_lock_idle_alarm, android.R.drawable.ic_lock_idle_low_battery
    };
    private AdapterViewFlipper flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_flipper);
        flipper = (AdapterViewFlipper)findViewById(R.id.flipper);
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                ImageView imageView = new ImageView(AdapterViewFlipperActivity.this);
                imageView.setImageResource(imageIds[i]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        };
        flipper.setAdapter(adapter);
    }
    public void prev(View v) {
        flipper.showPrevious();
        flipper.stopFlipping();
    }
    public void next(View v) {
        flipper.showNext();
        flipper.stopFlipping();
    }
    public void auto(View v) {
        flipper.startFlipping();
    }
}
