package com.dragonfury.duy.p4a10nguyendennisclassttt;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by 1383504 on 2/16/2017.
 */
public class Cell extends RectF {
    public static final Creator<RectF> CREATOR = null;
    public Cell(float left, float top, float right, float bottom) {
        super(left, top, right, bottom);
    }

    int state = 100;

    public void draw(Canvas c, Paint p) {
        p.setStyle(Paint.Style.STROKE);
        c.drawRect(this, p);
        if (state==0) {
            c.drawLine(this.left, this.top, this.right, this.bottom, p);
            c.drawLine(this.right, this.top, this.left, this.bottom, p);
        } else if (state==1) {
            c.drawCircle(this.centerX(), this.centerY(), this.width()/2, p);
        }
    }

    public void update(Canvas c) {

    }

    public boolean isOpen() {
        return state==100;
    }

    public void assignState(int turnCount) {
        state = turnCount%2;
    }

    public int getState() {
        return state;
    }
}
