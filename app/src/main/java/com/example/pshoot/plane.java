package com.example.pshoot;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

public class plane {

    Bitmap plane[] = new Bitmap[5];

    int planeX,planeY,velocity;
    int planeFrame;

    Random random;

    public plane(Context context) {

        plane[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.p1);
        plane[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.p2);
        plane[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.p3);
        plane[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.p4);
        plane[4] = BitmapFactory.decodeResource(context. getResources(),R.drawable.p5);

        random = new Random();
        resetPosition();

    }

    public  Bitmap getBitmap() {
        return plane[planeFrame];
    }

    public int getWidth() {
        return plane[0].getWidth();
    }

    public  int getHeight() {
        return  plane[0].getHeight();
    }

    public void resetPosition() {
        planeX = GameView.screenWidth + random.nextInt(1200);
        planeY = random.nextInt(300);
        velocity = 8 + random.nextInt(13);

        planeFrame = 0;
    }
}
