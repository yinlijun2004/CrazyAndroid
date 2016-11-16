package com.example.crazyandroid.bitmap;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yinlijun on 16-11-16.
 */

public class MyView extends View {
    private int styleIndex = 0;
    public MyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                styleIndex = (styleIndex + 1) % 3;
                MyView.this.invalidate();
            }
        });
    }

    private void setStyle(Paint paint) {
        switch (styleIndex) {
            case 0:
                paint.setColor(Color.BLUE);
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(4);
                break;
            case 1:
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.RED);
                break;
            case 2:
                paint.setAntiAlias(true);
                Shader shader = new LinearGradient(0, 0, 40, 60,
                        new int[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW},
                        null,
                        Shader.TileMode.REPEAT);
                paint.setShader(shader);
                paint.setShadowLayer(25, 20, 20, Color.GRAY);
                break;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        setStyle(paint);

        int viewWidth = this.getWidth();
        canvas.drawCircle(viewWidth/10 + 10, viewWidth/10 + 10, viewWidth/10, paint);
        canvas.drawRect(10, viewWidth/5 + 20, viewWidth/5 + 10, viewWidth*2/5 + 20, paint);
        canvas.drawRect(10, viewWidth*2/5 + 30, viewWidth/5 + 10, viewWidth/2 + 30, paint);
        RectF rel = new RectF(10, viewWidth/2 + 40, 10 + viewWidth / 5, viewWidth*3/5 + 40);
        canvas.drawRoundRect(rel, 15, 15, paint);
        RectF rel1 = new RectF(10, viewWidth*3/5 + 50, 10 + viewWidth/5, viewWidth*7/10 + 50);
        canvas.drawOval(rel1, paint);
        Path path1 = new Path();
        path1.moveTo(10, viewWidth*9/10 + 60);
        path1.lineTo(viewWidth/5 + 10, viewWidth*9/10 + 60);
        path1.lineTo(viewWidth/10 + 10, viewWidth*7/10 + 60);
        path1.close();
        canvas.drawPath(path1, paint);
    }
}
