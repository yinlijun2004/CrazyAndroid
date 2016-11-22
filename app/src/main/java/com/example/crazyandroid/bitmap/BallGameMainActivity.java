package com.example.crazyandroid.bitmap;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Handler;
import android.widget.Switch;

public class BallGameMainActivity extends Activity {
    private int tableWidth;
    private int tableHeight;
    private int racketY;
    private final int RACKET_HEIGHT = 30;
    private final int RACKET_WIDTH = 90;
    private final int BALL_SIZE = 16;
    private int ySpeed = 15;
    Random rand = new Random();
    private double xyRate = rand.nextDouble() - 0.5;
    private int xSpeed = (int)(ySpeed * xyRate * 2);
    private int ballX = rand.nextInt(100) + 20;
    private int ballY = rand.nextInt(10) + 20;
    private boolean isLose = false;
    private int racketX = rand.nextInt(200);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final GameView gameView = new GameView(this);
        setContentView(gameView);
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        tableHeight = metrics.heightPixels;
        tableWidth = metrics.widthPixels;
        racketY = tableHeight - 80;
        final Handler hanlder = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if(msg.what == 0x123) {
                    gameView.invalidate();
                }
            }
        };

        gameView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.KEYCODE_A:
                        if(racketX > 0) racketX -= 10;
                        break;
                    case KeyEvent.KEYCODE_D:
                        if(racketX < tableWidth - RACKET_WIDTH) racketX += 10;
                        break;
                }
                gameView.invalidate();
                return true;
            }
        });

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(ballX <= 0 || ballX >= tableWidth - BALL_SIZE) {
                    xSpeed = -xSpeed;
                }
                if(ballY >= racketY - BALL_SIZE && (ballX < racketX || ballX > racketX + RACKET_WIDTH)) {
                    timer.cancel();
                    isLose = true;
                } else if(ballY <= 0 || (ballY >= racketY - BALL_SIZE && ballX > racketX && ballX <= racketX + RACKET_WIDTH)) {
                    ySpeed = - ySpeed;
                }
                ballY += ySpeed;
                ballX += xSpeed;
                hanlder.sendEmptyMessage(0x123);
            }
        }, 0,100);
    }
    class GameView extends View {
        Paint paint = new Paint();
        public GameView(Context context) {
            super(context);
            setFocusable(true);
        }
        public void onDraw(Canvas canvas) {
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            if(isLose) {
                paint.setColor(Color.RED);
                paint.setTextSize(40);
                canvas.drawText("Game Over", tableWidth / 2 - 100, 200, paint);
            } else {
                paint.setColor(Color.rgb(255, 0, 0));
                canvas.drawCircle(ballX, ballY, BALL_SIZE, paint);
                paint.setColor(Color.rgb(80, 80, 200));
                canvas.drawRect(racketX, racketY, racketX + RACKET_WIDTH, racketY + RACKET_HEIGHT, paint);
            }
        }
    }
}
