package com.example.danielholst.logincomponent;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by danielholst on 15-12-08.
 */
public class PasswordStrengthMeter extends View {

    private int passwordStrength;

    public PasswordStrengthMeter(Context context, int Strength) {
        super(context);
        passwordStrength = Strength;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint myPaint = new Paint();
        myPaint.setColor(getResources().getColor(R.color.colorStrengthMeterBackground));
        myPaint.setStrokeWidth(10);
        canvas.drawRect(0, 0, 70, 130, myPaint);
/*
        //worst case
        if(passwordStrength == 0) {
            Paint customColor = new Paint();
            customColor.setColor(Color.parseColor("#ff9999"));
            customColor.setStyle(Paint.Style.FILL);
            canvas.drawPaint(customColor);
            canvas.drawText(name, 40, 50, items);
        }
        else {
            Paint customColor = new Paint();
            customColor.setColor(Color.parseColor("#F8EEF1"));
            customColor.setStyle(Paint.Style.FILL);
            canvas.drawPaint(customColor);
            canvas.drawText("", 40, 50, items);
        }
        */
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){

        //Sets the dimensions for the item.
        setMeasuredDimension(200, 200);
    }
}
