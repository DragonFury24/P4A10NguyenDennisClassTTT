package com.dragonfury.duy.p4a10nguyendennisclassttt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 1383504 on 2/16/2017.
 */
public class DrawView extends View {

    int rowVar = 3;
    int colVar = 3;
    Cell namInABox [][] = new Cell[rowVar][colVar];
    Paint nam = new Paint();
    private int turnCount;

    public DrawView(Context context) {
        super(context);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i<namInABox.length; i++) {
            for (Cell namBox : namInABox[i]) {
                namBox.draw(canvas, nam);
            }
        }
        invalidate();

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {

        super.onLayout(changed, left, top, right, bottom);
        for(int j = 0; j< namInABox.length; j++) {
            for (int i = 0; i < namInABox.length; i++) {
                namInABox[i][j]=new Cell(getWidth() / rowVar * i, getHeight() * j / colVar, getWidth() / rowVar * (i + 1), getHeight() / colVar * (j+1));
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        for(int j = 0; j < namInABox.length; j++) {
            for (Cell namBox : namInABox[j]) {
                if (namBox.isOpen() && namBox.contains(event.getX(), event.getY())){
                    namBox.assignState(turnCount++);
                }
            }
        }

        return super.onTouchEvent(event);
    }
}
