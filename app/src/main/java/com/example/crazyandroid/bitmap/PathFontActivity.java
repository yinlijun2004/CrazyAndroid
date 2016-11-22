package com.example.crazyandroid.bitmap;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class PathFontActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
    class MyView extends View {
        final String DRAW_STRING = "您好世界";
        Path[] paths = new Path[3];
        Paint paint;
        public MyView(Context context) {
            super(context);
            paths[0] = new Path();
            paths[0].moveTo(0, 0);
            for(int i = 0; i < 20; i++) {
                paths[0].lineTo(i * 30, (float) Math.random()*30);
            }
            paths[1] = new Path();
            RectF rectF = new RectF(0, 0, 600, 360);
            paths[1].addOval(rectF, Path.Direction.CCW);
            paths[2] = new Path();
            paths[2].addArc(rectF, 60, 180);
            paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(1);
            paint.setColor(Color.CYAN);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);
            canvas.translate(40, 40);
            paint.setTextAlign(Paint.Align.RIGHT);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(paths[0], paint);
            paint.setTextSize(40);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawTextOnPath(DRAW_STRING, paths[0], -8, 20, paint);
            canvas.translate(0, 60);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(paths[1], paint);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawTextOnPath(DRAW_STRING, paths[1], -20, 20, paint);
            canvas.translate(0, 360);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(paths[2], paint);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawTextOnPath(DRAW_STRING, paths[2], -10, 20,  paint);
        }
    }
}
