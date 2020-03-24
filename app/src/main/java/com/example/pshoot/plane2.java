package com.example.pshoot;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class plane2 extends plane {

    Bitmap[] plane = new Bitmap[13];

    public plane2(Context context) {
        super(context);
        plane[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.pl1);
        plane[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.pl2);
        plane[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.pl3);
        plane[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.pl4);
        plane[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.pl5);
        plane[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.pl6);
        plane[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.pl7);
        plane[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.pl8);
        plane[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.pl9);
        plane[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.pl10);
        plane[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.pl11);
        plane[11] = BitmapFactory.decodeResource(context.getResources(),R.drawable.pl12);
        plane[12] = BitmapFactory.decodeResource(context.getResources(),R.drawable.pl13);
        resetPosition();

    }

    @Override
    public Bitmap getBitmap() {
        return plane[planeFrame];
    }

    @Override
    public int getWidth() {
        return plane[0].getWidth();
    }

    @Override
    public int getHeight() {
        return  plane[0].getHeight();
    }

    @Override
    public void resetPosition() {
        planeX = -(200 + random.nextInt(1500));
        planeY = random.nextInt(400);
        velocity = 5 + random.nextInt(21);
    }
}
