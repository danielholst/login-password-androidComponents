package com.example.danielholst.logincomponent.LoginForm;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.example.danielholst.logincomponent.R;

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

        //draw rectangle
        Paint rect = new Paint();
        rect.setColor(getResources().getColor(R.color.colorStrengthMeterBackground));
        rect.setStrokeWidth(10);
        canvas.drawRect(0, 0, 70, 150, rect);

        if(passwordStrength == 0) {
            color1 = getResources().getColor(R.color.colorCircleRedLit);
            color2 = getResources().getColor(R.color.colorCircleYellow);
            color3 = getResources().getColor(R.color.colorCircleGreen);
        }

        if(passwordStrength == 1) {
            color1 = getResources().getColor(R.color.colorCircleRed);
            color2 = getResources().getColor(R.color.colorCircleYellowLit);
            color3 = getResources().getColor(R.color.colorCircleGreen);
        }

        if(passwordStrength == 2) {
            color1 = getResources().getColor(R.color.colorCircleRed);
            color2 = getResources().getColor(R.color.colorCircleYellow);
            color3 = getResources().getColor(R.color.colorCircleGreenLit);
        }

        //draw circles
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
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){

        //Sets the dimensions for the item.
        setMeasuredDimension(200, 200);
    }
}
