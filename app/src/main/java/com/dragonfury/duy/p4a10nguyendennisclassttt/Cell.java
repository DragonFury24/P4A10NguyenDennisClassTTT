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

    int state = 100; //Each box is open with a start state of 100

    public void draw(Canvas c, Paint p) {
        p.setStyle(Paint.Style.STROKE);
        c.drawRect(this, p);
        if (state==0) { //If the state changes to 0 then draw an X
            c.drawLine(this.left, this.top, this.right, this.bottom, p);
            c.drawLine(this.right, this.top, this.left, this.bottom, p);
        } else if (state==1) { //If state changes to 1 then draw an O
            c.drawCircle(this.centerX(), this.centerY(), this.width()/2, p);
        }
    }

    public void update(Canvas c) {

    }

    public boolean isOpen() { //Request to check if box is open
        return state==100;
    }

    public void assignState(int turnCount) { //Changes the state to 0 or 1; Alternates because of modular division
        state = turnCount%2;
    }

    public int getState() { //Returns the current value of state
        return state;
    }
}
