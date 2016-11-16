package com.example.crazyandroid.bitmap;

import android.app.Activity;
import android.os.Bundle;

public class PaintMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this, null));
    }

}
