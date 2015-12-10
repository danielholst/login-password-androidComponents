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

        int color1 = 1, color2 = 1, color3 = 1;
        Paint rect = new Paint();
        rect.setColor(getResources().getColor(R.color.colorStrengthMeterBackground));
        rect.setStrokeWidth(10);
        canvas.drawRect(0, 0, 70, 150, rect);

        if(passwordStrength == 0) {
            color1 = getResources().getColor(R.color.colorCircleRedLit);
            color2 = getResources().getColor(R.color.colorCircleYellow);
            color3 = getResources().getColor(R.color.colorCirleGreen);
        }

        if(passwordStrength == 1) {
            color1 = getResources().getColor(R.color.colorCircleRed);
            color2 = getResources().getColor(R.color.colorCircleYellowLit);
            color3 = getResources().getColor(R.color.colorCirleGreen);
        }

        if(passwordStrength == 2) {
            color1 = getResources().getColor(R.color.colorCircleRed);
            color2 = getResources().getColor(R.color.colorCircleYellow);
            color3 = getResources().getColor(R.color.colorCirleGreenLit);
        }

        Paint circle = new Paint();
        circle.setColor(color1);
        circle.setStrokeWidth(10);
        canvas.drawCircle(35, 35, 15, circle);

        Paint circle2 = new Paint();
        circle2.setColor(color2);
        circle.setStrokeWidth(10);
        canvas.drawCircle(35, 75, 15, circle2);

        Paint circle3 = new Paint();
        circle3.setColor(color3);
        circle3.setStrokeWidth(10);
        canvas.drawCircle(35, 115, 15, circle3);
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
