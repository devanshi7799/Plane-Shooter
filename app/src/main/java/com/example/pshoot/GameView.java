package com.example.pshoot;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

import androidx.annotation.Nullable;

public class GameView extends View {

    Bitmap background,tank;
    Rect rect;
    static int screenWidth,screenHeight;
    Handler handler;
    Runnable runnable;
    final long UPDATE_MILLIS = 30;
    int tankWidth,tankHeight;

    ArrayList<plane> planes,planes2;

    public GameView(Context context) {
        super(context);
        background = BitmapFactory.decodeResource(getResources(),R.drawable.background);
        tank = BitmapFactory.decodeResource(getResources(),R.drawable.tankimg);
        Display display = ((Activity)getContext()).getWindowManager().getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);

        screenWidth = size.x;
        screenHeight = size.y;
        rect = new Rect(0,0,screenWidth,screenHeight);

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };

        tankWidth = tank.getWidth();
        tankHeight = tank.getHeight();

        planes = new ArrayList<>();
        planes2 = new ArrayList<>();

        for(int i=0;i<2;i++){
            plane p = new plane(context);
            planes.add(p);
            plane2 p2 = new plane2(context);
            planes2.add(p2);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(background,null,rect,null);

        for(int i=0;i<planes.size();i++) {
            canvas.drawBitmap(planes.get(i).getBitmap(),planes.get(i).planeX,planes.get(i).planeY,null);
            planes.get(i).planeFrame++;

            if(planes.get(i).planeFrame > 4 ) {
                planes.get(i).planeFrame = 0;
            }

            planes.get(i).planeX -= planes.get(i).velocity;

            if(planes.get(i).planeX < -planes.get(i).getWidth()){
                planes.get(i).resetPosition();
            }

            canvas.drawBitmap(planes2.get(i).getBitmap(),planes2.get(i).planeX,planes2.get(i).planeY,null);
            planes2.get(i).planeFrame++;

            if(planes2.get(i).planeFrame > 12) {
                planes2.get(i).planeFrame = 0;
            }

            planes2.get(i).planeX += planes2.get(i).velocity;

            if(planes2.get(i).planeX > (screenWidth + planes2.get(i).getWidth())) {
                planes2.get(i).resetPosition();
            }
        }

        canvas.drawBitmap(tank,(screenWidth/2 - tankWidth/2),screenHeight - tankHeight , null);
        handler.postDelayed(runnable,UPDATE_MILLIS);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        int action = event.getAction();

        if(action == MotionEvent.ACTION_DOWN) {
            if(touchX >= (screenWidth/2 - tankWidth/2) && touchX <=(screenWidth/2 + tankWidth/2) && touchY >= (screenHeight - tankHeight)) {
                Log.i("tank","is tapped");
            }
        }
        return true;
    }
}
