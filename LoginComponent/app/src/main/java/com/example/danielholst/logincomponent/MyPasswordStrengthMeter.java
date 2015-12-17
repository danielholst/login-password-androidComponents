package com.example.danielholst.logincomponent;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.danielholst.logincomponent.SignupForm.PasswordStrengthMeter;

/**
 * Created by danielholst on 15-12-16.
 */
public class MyPasswordStrengthMeter extends PasswordStrengthMeter {

    private int passwordStrength;
    public MyPasswordStrengthMeter(Context context) {
        super(context);
    }

    public void updatePasswordStrength(int strength) {
        passwordStrength = strength;
        System.out.println(passwordStrength);
        invalidate();
    }

    protected void onDraw(Canvas canvas) {

        int color1 = 1, color2 = 1, color3 = 1;

        //draw rectangle
        Paint rect = new Paint();
        rect.setColor(getResources().getColor(R.color.colorStrengthMeterBackground));
        rect.setStrokeWidth(10);
        canvas.drawRect(0, 0, 70, 150, rect);

        if(passwordStrength == 0 || passwordStrength == 1) {
            color1 = getResources().getColor(R.color.colorCircleRedLit);
            color2 = getResources().getColor(R.color.colorCircleYellow);
            color3 = getResources().getColor(R.color.colorCircleGreen);
        }

        if(passwordStrength == 2) {
            color1 = getResources().getColor(R.color.colorCircleRedHalfLit);
            color2 = getResources().getColor(R.color.colorCircleYellowHalfLit);
            color3 = getResources().getColor(R.color.colorCircleGreen);
        }

        if(passwordStrength == 3) {
            color1 = getResources().getColor(R.color.colorCircleRed);
            color2 = getResources().getColor(R.color.colorCircleYellowLit);
            color3 = getResources().getColor(R.color.colorCircleGreen);
        }

        if(passwordStrength == 4) {
            color1 = getResources().getColor(R.color.colorCircleRed);
            color2 = getResources().getColor(R.color.colorCircleYellowHalfLit);
            color3 = getResources().getColor(R.color.colorCircleGreenHalfLit);
        }

        if(passwordStrength >= 5) {
            color1 = getResources().getColor(R.color.colorCircleRed);
            color2 = getResources().getColor(R.color.colorCircleYellow);
            color3 = getResources().getColor(R.color.colorCircleGreenLit);
        }

        if(passwordStrength == 6) {
            color1 = getResources().getColor(R.color.colorCircleRed);
            color2 = getResources().getColor(R.color.colorCircleYellow);
            color3 = getResources().getColor(R.color.colorCircleGreenLit);
        }

        //draw circles
        Paint rect1 = new Paint();
        rect1.setColor(color1);
        rect1.setStrokeWidth(10);
        canvas.drawRect(15, 10, 55, 45, rect1);

        Paint rect2 = new Paint();
        rect2.setColor(color2);
        rect2.setStrokeWidth(10);
        canvas.drawRect(15, 55, 55, 95, rect2);

        Paint rect3 = new Paint();
        rect3.setColor(color3);
        rect3.setStrokeWidth(10);
        canvas.drawRect(15, 105, 55, 140, rect3);
    }
}
