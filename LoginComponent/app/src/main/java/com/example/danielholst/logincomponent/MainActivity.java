package com.example.danielholst.logincomponent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.example.danielholst.logincomponent.SignupForm.PasswordAlgorithm;
import com.example.danielholst.logincomponent.SignupForm.PasswordForm;
import com.example.danielholst.logincomponent.SignupForm.SignupForm;
import com.example.danielholst.logincomponent.SignupForm.PasswordStrengthMeter;

public class MainActivity extends AppCompatActivity {

    SignupForm signupForm;
    PasswordForm passwordForm;
    PasswordStrengthMeter passwordStrengthMeter;
    PasswordAlgorithm passwordAlgorithm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout myLayout = new RelativeLayout(this);

        //create password strength meter
        passwordStrengthMeter = new PasswordStrengthMeter(this);

        //create password algorithm
        passwordAlgorithm = new PasswordAlgorithm();

        //create password form with password strength meter and password algorithm
        passwordForm = new PasswordForm(this, passwordStrengthMeter, passwordAlgorithm);

        //create sign up form without password field
        //singupForm = new SignupForm(this);

        //create sign up form with password field
        signupForm = new SignupForm(this, passwordForm);

        RelativeLayout.LayoutParams loginParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT);

        myLayout.addView(signupForm, loginParams);

        setContentView(myLayout);
    }
}
